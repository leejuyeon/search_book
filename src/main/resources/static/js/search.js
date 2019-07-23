

var searchBook = {
		init : function (){
			$('.modal').modal();
			$('#searchBtn').click(function(){
				searchBook.search(1);
			});
			$('#mybtn').click(function(){
				searchBook.history();
			});
			
			searchBook.topic();
		}, show : function (component){
			var book = $(component).data();

			$("#book-title").html(book.title);
			$("#book-img").html('<img src="' + book.thumbnail + '" alt="">');
			$("#book-isbn").html("ISBN : " + book.isbn);
			$("#book-publisher").html("publisher : " + book.publisher);
			$("#book-authors").html("authors : " + book.authors);
			$("#book-datetime").html("datetime : " + book.datetime);
			$("#book-price").html("price : " + book.price);
			$("#book-salePrice").html("salePrice : " + book.saleprice < 0? '정가' : book.saleprice);
			$("#book-contents").html("contents : " + book.contents);
		}
		, paging : function(total, page, currentPage){
			var pageCount = 10;
			
			var totalPage = Math.ceil(total / page);    // 총 페이지 수
			var pageGroup = Math.ceil(currentPage / pageCount);    // 페이지 그룹
			var last = pageGroup * pageCount;    // 화면에 보여질 마지막 페이지 번호
			if(last > totalPage) last = totalPage;
			var first = last - (pageCount - 1);    // 화면에 보여질 첫번째 페이지 번호
			if(first < 0) first = 1;
			var next = last + 1;
		    var prev = first - 1;


			console.log("totalPage:" + totalPage);
			console.log("pageGroup:" + pageGroup);
			console.log("last:" + last);
			console.log("first:" + first);
			console.log("next:" + next);
			console.log("prev:" + prev);
			
	        
	        var paginghtml = '';

	         if(prev == 0){
	       		 paginghtml = paginghtml + '<li class="disabled"><a onclick="#!"><i class="material-icons">chevron_left</i></a></li>';
	         }else{
	       		 paginghtml = paginghtml + '<li class="waves-effect"><a onclick="searchBook.search('+ prev +')"><i class="material-icons">chevron_left</i></a></li>';
	         }
	         	
	         for(var i = first; i < last + 1;i ++){
	        	 if(i == currentPage){
	        		 paginghtml = paginghtml + '<li class="active"><a href="#!">'+ i +'</a></li>';
	        	 }else{
		        	 paginghtml = paginghtml + '<li class="waves-effect"><a onclick="searchBook.search('+ i +')">'+ i +'</a></li>';
	        	 }
	         }
	         
	         if(last < totalPage)
	        	 paginghtml = paginghtml + '<li class="waves-effect"><a onclick="searchBook.search('+ next +')"><i class="material-icons">chevron_right</i></a></li>';
	         
	        $("#book-page").html(paginghtml);
	    }
		, search : function(page){
			if(page < 1) page = 1;
			
			var keyword = $("#search").val();
			$.ajax({ type: "GET", url: "/search/book", data: {keyword : keyword, page : page}, success: function(result){
				console.log(result);
				var listhtml = "";
				
				if(result.books.length > 0){

					result.books.forEach(function(book){
						var bookhtml = '<li class="collection-item avatar row"><div class="col s10">';
						bookhtml = bookhtml + (book.thumbnail == "" ? '<i class="material-icons circle">book</i>' : '<img src="' + book.thumbnail + '" alt="" class="circle">');
						bookhtml = bookhtml + '<span class="title">' + book.title +'</span>  </div>';
						bookhtml = bookhtml + '<div class="col s2"><button data-target="book-detail" ';
						bookhtml = bookhtml + 'data-title="' + book.title +'"';
						bookhtml = bookhtml + 'data-contents="' + book.contents +'"';
						bookhtml = bookhtml + 'data-thumbnail="' + book.thumbnail +'"';
						bookhtml = bookhtml + 'data-isbn="' + book.isbn +'"';
						bookhtml = bookhtml + 'data-authors="' + book.authors +'"';
						bookhtml = bookhtml + 'data-datetime="' + book.datetime +'"';
						bookhtml = bookhtml + 'data-price="' + book.price +'"';
						bookhtml = bookhtml + 'data-salePrice="' + book.salePrice +'"';
						bookhtml = bookhtml + 'data-publisher="' + book.publisher +'"';
						bookhtml = bookhtml + 'class="btn modal-trigger" onclick="searchBook.show(this)">detail</button> </div></li>';
						
						listhtml = listhtml + bookhtml;
					});
					
					$("#book-list").html(listhtml);
					
					searchBook.paging(result.total, 10, page);
					searchBook.topic();
				}else{
					searchBook.message("검색 결과가 없습니다.");
					return;
				}
				
			}, error : function(e){
				console.log(e);				
				searchBook.message(e.responseJSON.message);
			}, dataType: "json" }); 
		}
		, history : function(){
			$.ajax({ type: "GET", url: "/search/my", success: function(result){
				console.log(result);
				var listhtml = '<li class="collection-item row active"><div class="col s6">keyword</div><div class="col s6">search time</div></li>' ;
				
				
				result.forEach(function(log){
					var historyhtml = '';
					historyhtml = historyhtml + '<li class="collection-item row">' ;
					historyhtml = historyhtml + '<div class="col s6">'+log.myKeywordId.keyword+'</div>'
					historyhtml = historyhtml + '<div class="col s6">'+log.searchTime+'</div>'
					historyhtml = historyhtml + '</li>';

					listhtml = listhtml + historyhtml;
				});
				
				
				$("#keyword-history").html(listhtml);
			}, error : function(e){
				console.log(e);				
				searchBook.message(e.responseJSON.message);
			}, dataType: "json" }); 
		}
		, topic : function(){
			$.ajax({ type: "GET", url: "/search/topic", success: function(result){
				console.log(result);

				var listhtml = '' ;
				result.forEach(function(topic){
					var taghtml = '<div class="chip">' + topic.keyword + '('+ topic.count + ')';
					taghtml = taghtml + '</div>';

					listhtml = listhtml + taghtml;
				});
				$("#keyword-tag").html(listhtml);
				
			}, error : function(e){
				console.log(e);				
				searchBook.message(e.responseJSON.message);
			}, dataType: "json" }); 
		}
		, message : function(msg){
			 M.toast({html: msg});
		}
}

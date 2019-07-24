# search_book
- 결과물은 해당 repository의 book-search-0.0.1-SNAPSHOT.jar
- 또는 http://naver.me/x5KNXzYX (aaaa1111) book-search-0.0.1-SNAPSHOT.jar

## back-end
- java8
- spring 5.1.8
- spring boot 2.1.6
- spring secutiry : 로그인/회원가입
- spring thymeleaf : 간단한 html 문법
- spring data jpa : jpa 활용
- okhttp3 3.14.2 : 외부연동 api의 http client 관리 및 pojo를 통해 json 응답 직렬화

## front-end
- materialize : 웹디자인 편의성

## 기능 설명
- 로그인 : http://localhost:8089/login
- 회원가입 : http://localhost:8089/join
- 검색 (로그인 후 확인 가능) : http://localhost:8089/ search 버튼 클릭하여 검색
- 내 검색 히스토리 (로그인 후 확인 가능) : http://localhost:8089/ 오른쪽 상단의 id 버튼
- 인기 검색어 (로그인 후 확인 가능) : http://localhost:8089/ 검색창 하단의 tag 형식으로 검색할 때마다 새로고침

package com.sample.book.component.api.kakao.domain.mixin;

import com.fasterxml.jackson.annotation.JsonProperty;

public class KaKaoSearchMetaMixin {
	@JsonProperty("is_end")
	private boolean end;
	@JsonProperty("pageable_count")
	private int pageableCount;
	@JsonProperty("total_count")
	private int totalCount;
	
	public boolean isEnd() {
		return end;
	}
	public void setEnd(boolean end) {
		this.end = end;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getPageableCount() {
		return pageableCount;
	}
	public void setPageableCount(int pageableCount) {
		this.pageableCount = pageableCount;
	}
}

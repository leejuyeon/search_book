package com.sample.book.component.api.kakao.domain;

public class KaKaoSearchMeta {
	private boolean end;
	private int pageableCount;
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

	@Override
	public String toString() {
		return "KaKaoSearchMeta [end=" + end + ", pageableCount=" + pageableCount + ", totalCount=" + totalCount + "]";
	}
}

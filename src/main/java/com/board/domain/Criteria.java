package com.board.domain;

public class Criteria {
	//보여줄 페이지 번호
	private int page;
	//한 페이지당 보여줄 페이지의 개수
	private int perPageNum;
	private int rowStart;
	private int rowEnd;
	
	//한페이지에 출력되는 페이지의 수
	public Criteria() {
		this.page = 1;
		this.perPageNum = 10;
	}
	
	//현 출력되는 페이지 숫자 설정
	public void setPage(int page) {
		if(page<=0) {
			this.page = 1;
			return;
		}
		this.page = page;
	}
	
	//마지막 페이지 설정
	public void setPerPageNum(int perPageNum) {
		if(perPageNum <= 0 || perPageNum > 100) {
			this.perPageNum = 10;
			return;
		}
		this.perPageNum = perPageNum;
	}
	
	//페이지 숫자 받아오기
	public int getPage() {
		return page;
	}
	
	
	//시작 페이지 숫자 받아오기
	public int getPageStart() {
		return (this.page -1) * perPageNum;
	}
	
	//마지막 페이지 숫자 받아오기
	public int getPerPageNum() {
		return this.perPageNum;
	}

	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + ", rowStart=" + rowStart + ", rowEnd=" + rowEnd
				+ "]";
	}
	
	/* limit 구문에서 시작 위치를 지정할 때 사용된다. 예를 들어 10개씩 출력하는 경우 3페이지의 데이터는 linit 20, 10 과 같은 형태가 되어야 한다. */
	/* this.page 가 1이면 0이 되어야 한다 mysql limit 0, 10 해야 처음부터 10개씩 나온다. */
	/* 마이바티스 조회쿼리의 #{pageStart}에 전달된다. */
	//시작 출력문의 번호
	public int getRowStart() {
		rowStart = ((page-1)*perPageNum)+1;
		return rowStart;
	}
	
	//끝 출력문의 번호
	public int getRowEnd() {
		rowEnd = rowStart + perPageNum -1;
		return rowEnd;
	}
	
}

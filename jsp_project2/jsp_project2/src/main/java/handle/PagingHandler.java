package handle;

import domain.PagingVO;

public class PagingHandler {

	private int startPage; //현재화면에서 보여지는 시작 페이지네이션 번호
	private int endPage; //현재화면에서 보여지는 끝 페이지네이션 번호
	private boolean prev, next; //이전, 다음버튼의 존재여부 (첫페이지에는 이전없음/마지막페이지에는 다음없음)
	
	private int totalCount; //전체 게시물의 수
	private PagingVO pgvo; //만들어 놓은 PagingVO 가져오기
	
	public PagingHandler(PagingVO pgvo, int totalCount) {
		this.pgvo = pgvo;
		this.totalCount = totalCount;
		
		//계산
		//예) 127개의 게시글 페이지네이션번호 = 1~13, 
		//	1페이지에 보이는 startPage = 1, endPage = 10
		//	11페이지에 보이는 startPage = 11, endPage = 13
		
		// (현재페이지 번호 / 한화면에 보여지는 게시글 수) * 한화면에 게시글 수
		//예) ( 1 / 10 ) * 10 = 0.1(1) * 10 = 10 : endPage = 10
		//	 ( 2 / 10 ) * 10 = 0.5(1) * 10 = 10 : endPage = 10
		//   ( 13 / 10 ) * 10 = 1.3(2) * 10 = 20 : endPage = 20 
		//   ( 23 / 10 ) * 10 = 2.3(3) * 10 = 30 : endPage = 30 ..
		//즉, 1~10페이지까지 endPage = 10 / 11~13페이지까지 endPage = 13
		
		// ceil = 올림
		// 정수/정수 = 정수임으로 1.0을 곱해줌! 
		// 끝페이지
		this.endPage = (int)(Math.ceil(pgvo.getPageNo() / (pgvo.getQty()*1.0))*pgvo.getQty());
		
		// 시작 페이지
		this.startPage = this.endPage-9;
		
		// 아에 전체에서 마지막 페이지번호 (페이지네이션의 전체 끝 페이지)
		int realEndPage = (int)Math.ceil((totalCount*1.0)/ pgvo.getQty()); 
		if(realEndPage < this.endPage) {
			this.endPage = realEndPage;
		}
		
		//다음, 이전
		//1, 11, 21으로 startPage가 존재
		this.prev = this.startPage > 1; //시작페이지가 존재하면 true
		this.next = this.endPage < realEndPage; //전체 끝페이지보다 끝페이지가 작은 경우 true
		
	}
	
	//시작페이지를 리턴해주는 메서드
	public int getStartPage() {
		return startPage;
	}

	//getter,setter
	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public PagingVO getPgvo() {
		return pgvo;
	}

	public void setPgvo(PagingVO pgvo) {
		this.pgvo = pgvo;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	
	
}

package domain;

public class PagingVO {

	
	private int pageNo; //화면에 출력되는 페이지의 번호
	private int qty; //한 페이지에 보여지는 게시글의 수 = 10개 (보통 변수로 받음)
	
	public PagingVO() { //페이지네이션을 클릭하기 전 기본 값으로 생성
		this(1,10); //기본적으로 생성도록! 1페이지에 10개씩 보여주세요
	}
	public PagingVO(int pageNo, int qty) {
		 this.pageNo = pageNo;
		 this.qty = qty;
	}
	
	public int getPageStart() { //시작페이지 번호 (시작 limit번지)
		return (this.pageNo-1)*10; 
	}
	
	
	//---------------------------------------------------------------
	
	//getter,setter
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	//----------------------------------------------------------------
	//검색 
	
	private String keyword;
	private String type;


	//타입이 2개인경우
	public String[] getTypeToArray() {
		return this.type == null ? new String[] {} : this.type.split("");
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	@Override
	public String toString() {
		return "PagingVO [pageNo=" + pageNo + ", qty=" + qty + ", keyword=" + keyword + ", type=" + type + "]";
	}
	
	
	
}

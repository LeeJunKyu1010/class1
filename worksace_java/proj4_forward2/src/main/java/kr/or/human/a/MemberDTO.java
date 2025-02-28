package kr.or.human.a;

public class MemberDTO {
	
	private String id;
	private String pw;
	
	public String getId() {
		System.out.println("MemberDTO getId 실행");
		return id;
	}
	public void setId(String id) {
		System.out.println("MemberDTO setId 실행"+id);
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	
	
}

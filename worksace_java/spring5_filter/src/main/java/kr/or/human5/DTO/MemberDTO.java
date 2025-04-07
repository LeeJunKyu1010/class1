package kr.or.human5.DTO;

public class MemberDTO {
	
	public String id;	// 아이디
	public String pw;	// 비밀번호
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String name;	// 이름
	
}

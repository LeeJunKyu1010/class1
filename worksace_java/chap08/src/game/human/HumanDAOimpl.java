package game.human;

public class HumanDAOimpl implements HumanDAO{
	
	String id = "admin";
	String pw = "1234";
	String name = "이름";
	int age = 20;
	
	@Override
	public HumanDTO selectMember(HumanDTO dto) {
		
		if(dto.getId().equals(this.id) && dto.getPw().equals(this.pw)) {
			dto.setName(this.name);
			dto.setAge(this.age);
			
			return dto;
		}else {
			return null;			
		}
		
	}
	
}

import java.util.ArrayList;
import java.util.List;

public class WeekDTO {
	
	String p_code;
	Integer p_c;
	// ID는 상품명의 ID
	Integer p_id;
	// I가 생산계획번호
	Integer p_i;
	Integer p_y;
	Integer p_w;
	
	String p_name;
	
	private List check = new ArrayList();

	public String getP_code() {
		return p_code;
	}

	public void setP_code(String p_code) {
		this.p_code = p_code;
	}

	public Integer getP_id() {
		return p_id;
	}

	public void setP_id(Integer p_id) {
		this.p_id = p_id;
	}

	public Integer getP_c() {
		return p_c;
	}

	public void setP_c(Integer p_c) {
		this.p_c = p_c;
	}

	public Integer getP_y() {
		return p_y;
	}

	public void setP_y(Integer p_y) {
		this.p_y = p_y;
	}

	public Integer getP_w() {
		return p_w;
	}

	public void setP_w(Integer p_w) {
		this.p_w = p_w;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public Integer getP_i() {
		return p_i;
	}

	public void setP_i(Integer p_i) {
		this.p_i = p_i;
	}
	
	public List getCheck() {
		return check;
	}
	public void setCheck(String check) {
		this.check.add(check);
	}

}

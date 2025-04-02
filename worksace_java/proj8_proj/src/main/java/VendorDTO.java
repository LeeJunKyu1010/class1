import java.util.ArrayList;
import java.util.List;

public class VendorDTO {

	private Integer c_c;
	private String c_n;
	private String c_m;
	private String c_p;
	private String c_a;
	private Integer c_i;
	private List check = new ArrayList();
	
	public Integer getC_c() {
		return c_c;
	}
	public void setC_c(Integer c_c) {
		this.c_c = c_c;
	}
	public String getC_n() {
		return c_n;
	}
	public void setC_n(String c_n) {
		this.c_n = c_n;
	}
	public String getC_m() {
		return c_m;
	}
	public void setC_m(String c_m) {
		this.c_m = c_m;
	}
	public String getC_p() {
		return c_p;
	}
	public void setC_p(String c_p) {
		this.c_p = c_p;
	}
	public String getC_a() {
		return c_a;
	}
	public void setC_a(String c_a) {
		this.c_a = c_a;
	}
	public Integer getC_i() {
		return c_i;
	}
	public void setC_i(Integer c_i) {
		this.c_i = c_i;
	}
	
	public List getCheck() {
			return check;			
	}
	public void setCheck(String check) {
		this.check.add(check);
	}
	
	
}

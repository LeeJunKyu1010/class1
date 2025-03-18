import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BillDTO {

	private Date c_d;
	private Integer c_c;
	private String c_n;
	private String c_p;
	private String c_j;
	private Integer c_b;
	private Integer c_i;
	private Integer c_q;
	private String c_a;
	private List check = new ArrayList();
	
	public Date getC_d() {
		return c_d;
	}
	public void setC_d(Date c_d) {
		this.c_d = c_d;
	}
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
	public String getC_p() {
		return c_p;
	}
	public void setC_p(String c_p) {
		this.c_p = c_p;
	}
	public String getC_j() {
		return c_j;
	}
	public void setC_j(String c_j) {
		this.c_j = c_j;
	}
	public Integer getC_b() {
		return c_b;
	}
	public void setC_b(Integer c_b) {
		this.c_b = c_b;
	}
	public Integer getC_i() {
		return c_i;
	}
	public void setC_i(Integer c_i) {
		this.c_i = c_i;
	}
	public Integer getC_q() {
		return c_q;
	}
	public void setC_q(Integer c_q) {
		this.c_q = c_q;
	}
	public String getC_a() {
		return c_a;
	}
	public void setC_a(String c_a) {
		this.c_a = c_a;
	}
	public List getCheck() {
		return check;
	}
	public void setCheck(String check) {
		this.check.add(check);
	}

}

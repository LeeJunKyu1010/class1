import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class WorkDTO {

	private Integer year;
	private Integer week;

	private String sku_name;
	private Integer plan_id;

	private Integer sku_code;
	private Integer plan_count;

	private Integer bom;
	private Integer qnt;

	private Date date;
	private Integer work_id;
	private Integer plan_s;
	
	private String coml;

	private List check = new ArrayList();

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getWeek() {
		return week;
	}

	public void setWeek(Integer week) {
		this.week = week;
	}

	public String getSku_name() {
		return sku_name;
	}

	public void setSku_name(String sku_name) {
		this.sku_name = sku_name;
	}

	public Integer getPlan_id() {
		return plan_id;
	}

	public void setPlan_id(Integer plan_id) {
		this.plan_id = plan_id;
	}

	public Integer getSku_code() {
		return sku_code;
	}

	public void setSku_code(Integer sku_code) {
		this.sku_code = sku_code;
	}

	public Integer getPlan_count() {
		return plan_count;
	}

	public void setPlan_count(Integer plan_count) {
		this.plan_count = plan_count;
	}

	public Integer getBom() {
		return bom;
	}

	public void setBom(Integer bom) {
		this.bom = bom;
	}

	public Integer getQnt() {
		return qnt;
	}

	public void setQnt(Integer qnt) {
		this.qnt = qnt;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getWork_id() {
		return work_id;
	}

	public void setWork_id(Integer work_id) {
		this.work_id = work_id;
	}

	public Integer getPlan_s() {
		return plan_s;
	}

	public void setPlan_s(Integer plan_s) {
		this.plan_s = plan_s;
	}

	public List getCheck() {
		return check;
	}

	public void setCheck(String check) {
		this.check.add(check);
	}

	public String getComl() {
		return coml;
	}

	public void setComl(String coml) {
		this.coml = coml;
	}
	
	

}

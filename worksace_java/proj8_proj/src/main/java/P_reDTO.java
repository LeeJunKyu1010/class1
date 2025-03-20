import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class P_reDTO {
	private int repair_id;
	private String facility_code;
	private Date repair_request_date;
	private String repair_details;
	private String repair_requester;
	private String repair_item;
	private String remarks;
	private String facility_name;
	private List check = new ArrayList();

	public int getRepair_id() {
		return repair_id;
	}

	public void setRepair_id(int repair_id) {
		this.repair_id = repair_id;
	}

	public String getFacility_code() {
		return facility_code;
	}

	public void setFacility_code(String facility_code) {
		this.facility_code = facility_code;
	}

	public Date getRepair_request_date() {
		return repair_request_date;
	}

	public void setRepair_request_date(Date repair_request_date) {
		this.repair_request_date = repair_request_date;
	}

	public String getRepair_details() {
		return repair_details;
	}

	public void setRepair_details(String repair_details) {
		this.repair_details = repair_details;
	}

	public String getRepair_requester() {
		return repair_requester;
	}

	public void setRepair_requester(String repair_requester) {
		this.repair_requester = repair_requester;
	}

	public String getRepair_item() {
		return repair_item;
	}

	public void setRepair_item(String repair_item) {
		this.repair_item = repair_item;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getFacility_name() {
		return facility_name;
	}

	public void setFacility_name(String facility_name) {
		this.facility_name = facility_name;
	}

	public List getCheck() {
		return check;
	}

	public void setCheck(String check) {
		this.check.add(check);
	}
}

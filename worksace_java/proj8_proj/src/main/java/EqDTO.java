import java.sql.Date;

public class EqDTO {
	
	int facility_code;
	String facility_manager;
	Date installation_date;
	String facility_name;
	String facility_location;
	String inspection_cycle;
	String remarks;
	
	public int getFacility_code() {
		return facility_code;
	}
	public void setFacility_code(int facility_code) {
		this.facility_code = facility_code;
	}
	public String getFacility_manager() {
		return facility_manager;
	}
	public void setFacility_manager(String facility_manager) {
		this.facility_manager = facility_manager;
	}
	public Date getInstallation_date() {
		return installation_date;
	}
	public void setInstallation_date(Date installation_date) {
		this.installation_date = installation_date;
	}
	public String getFacility_name() {
		return facility_name;
	}
	public void setFacility_name(String facility_name) {
		this.facility_name = facility_name;
	}
	public String getFacility_location() {
		return facility_location;
	}
	public void setFacility_location(String facility_location) {
		this.facility_location = facility_location;
	}
	public String getInspection_cycle() {
		return inspection_cycle;
	}
	public void setInspection_cycle(String inspection_cycle) {
		this.inspection_cycle = inspection_cycle;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	
}
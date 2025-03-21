import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class EqDTO {
<<<<<<< HEAD
	private String facility_code; // 시설 코드 (Primary Key)
	private String facility_manager; // 시설 관리자
	private Date installation_date; // 설치 날짜
	private String facility_name; // 시설 이름
	private String facility_location; // 시설 위치
	private String inspection_cycle; // 점검 주기
	private String remarks; // 비고
	private List check = new ArrayList();

	// Getter 및 Setter 메서드

	public String getFacility_code() {
		return facility_code;
	}

	public void setFacility_code(String facility_code) {
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

	public List getCheck() {
		return check;
	}

	public void setCheck(String check) {
		this.check.add(check);
	}

=======
    private String facility_code;       // 시설 코드 (Primary Key)
    private String facility_manager;   // 시설 관리자
    private Date installation_date;    // 설치 날짜
    private String facility_name;      // 시설 이름
    private String facility_location;  // 시설 위치
    private String inspection_cycle;   // 점검 주기
    private String remarks;            // 비고

    // Getter 및 Setter 메서드

    public String getFacility_code() {
        return facility_code;
    }

    public void setFacility_code(String facility_code) {
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
>>>>>>> 06b1743101ba23a8403427f8adfb8f0b1bd2768a
}

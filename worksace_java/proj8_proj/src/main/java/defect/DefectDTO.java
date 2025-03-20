package defect;

public class DefectDTO {

	int defectId;
	String defectDate;
	int defectCount;
	int workOrderId;
	
	public int getDefectId() {
		return defectId;
	}
	public void setDefectId(int defectId) {
		this.defectId = defectId;
	}
	public String getDefectDate() {
		return defectDate;
	}
	public void setDefectDate(String defectDate) {
		this.defectDate = defectDate;
	}
	public int getDefectCount() {
		return defectCount;
	}
	public void setDefectCount(int defectCount) {
		this.defectCount = defectCount;
	}
	public int getWorkOrderId() {
		return workOrderId;
	}
	public void setWorkOrderId(int workOrderId) {
		this.workOrderId = workOrderId;
	}
	
}

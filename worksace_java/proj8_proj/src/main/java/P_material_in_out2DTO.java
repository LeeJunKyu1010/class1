import java.sql.Date;

public class P_material_in_out2DTO {
	
	
     
	int ib_id;
	int material_count;
	int material_price;
	String sku_type;
	Date create_date;
	Date modify_date;
	String remarks;
	int sku_id;
	int bill_id;
	 String sku_code;
     String sku_name;
     String sku_size;
     
     
	
	public String getSku_code() {
		return sku_code;
	}
	public void setSku_code(String sku_code) {
		this.sku_code = sku_code;
	}
	public String getSku_name() {
		return sku_name;
	}
	public void setSku_name(String sku_name) {
		this.sku_name = sku_name;
	}
	public String getSku_size() {
		return sku_size;
	}
	public void setSku_size(String sku_size) {
		this.sku_size = sku_size;
	}
	public int getIb_id() {
		return ib_id;
	}
	public void setIb_id(int ib_id) {
		this.ib_id = ib_id;
	}
	public int getMaterial_count() {
		return material_count;
	}
	public void setMaterial_count(int material_count) {
		this.material_count = material_count;
	}
	public int getMaterial_price() {
		return material_price;
	}
	public void setMaterial_price(int material_price) {
		this.material_price = material_price;
	}
	public String getSku_type() {
		return sku_type;
	}
	public void setSku_type(String sku_type) {
		this.sku_type = sku_type;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public Date getModify_date() {
		return modify_date;
	}
	public void setModify_date(Date modify_date) {
		this.modify_date = modify_date;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public int getSku_id() {
		return sku_id;
	}
	public void setSku_id(int sku_id) {
		this.sku_id = sku_id;
	}
	public int getBill_id() {
		return bill_id;
	}
	public void setBill_id(int bill_id) {
		this.bill_id = bill_id;
	}
	
	
}

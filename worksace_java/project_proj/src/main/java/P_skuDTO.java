import java.sql.Date;

public class P_skuDTO {

	int sku_id;
	String sku_code;
	String sku_name;
	String sku_size;
	String vendor_name;
	int price;
	Date create_date;
	Date modify_date;
	String sku_category;
	
	public int getSku_id() {
		return sku_id;
	}
	public void setSku_id(int sku_id) {
		this.sku_id = sku_id;
	}
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
	public String getVendor_name() {
		return vendor_name;
	}
	public void setVendor_name(String vendor_name) {
		this.vendor_name = vendor_name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
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
	public String getSku_category() {
		return sku_category;
	}
	public void setSku_category(String sku_category) {
		this.sku_category = sku_category;
	}
		
}

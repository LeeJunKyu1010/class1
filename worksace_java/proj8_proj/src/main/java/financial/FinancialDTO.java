package financial;

import java.sql.Date;

public class FinancialDTO {

	int financialId;
	Date reportDate;
	int totalSales;
	int operatingProfit;
	int netProfit;
	int ibId;
	
	
	public int getFinancialId() {
		return financialId;
	}
	public void setFinancialId(int financialId) {
		this.financialId = financialId;
	}
	public Date getReportDate() {
		return reportDate;
	}
	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}
	public int getTotalSales() {
		return totalSales;
	}
	public void setTotalSales(int totalSales) {
		this.totalSales = totalSales;
	}
	public int getOperatingProfit() {
		return operatingProfit;
	}
	public void setOperatingProfit(int operatingProfit) {
		this.operatingProfit = operatingProfit;
	}
	public int getNetProfit() {
		return netProfit;
	}
	public void setNetProfit(int netProfit) {
		this.netProfit = netProfit;
	}
	public int getIbId() {
		return ibId;
	}
	public void setIbId(int ibId) {
		this.ibId = ibId;
	}
	
	
}

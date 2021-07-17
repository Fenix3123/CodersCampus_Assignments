
public class CarSales {
	private String year;
	private String month;
	private Integer sale;
	
	public String getYear() {
		return year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public int getSale() {
		return sale;
	}

	public void setSale(int sale) {
		this.sale = sale;
	}
	//constructor
	public CarSales(String year, String month, Integer sale) {
		this.year = year;
		this.month = month;
		this.sale = sale;
	}
}

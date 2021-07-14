
public class CarSales {
	private String date;
	private String sale;
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getSale() {
		return sale;
	}

	public void setSale(String sale) {
		this.sale = sale;
	}
	//constructor
	public CarSales(String date, String sale) {
		this.date = date;
		this.sale = sale;
	}
}

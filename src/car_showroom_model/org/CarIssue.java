package car_showroom_model.org;

public class CarIssue {

	private int issueid;
	private String issuename;
	private int price;
	private int quantity;

	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price=price;
	}

	public CarIssue(String issuename, int price, int quantity) {
		this.issuename = issuename;
		this.price = price;
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public CarIssue(String issuename) {
		this.issuename = issuename;
	}

	public CarIssue() {

	}

	public int getIssueid() {
		return issueid;
	}

	public void setIssueid(int issueid) {
		this.issueid = issueid;
	}

	public String getIssuename() {
		return issuename;
	}

	public void setIssuename(String issuename) {
		this.issuename = issuename;
	}

}

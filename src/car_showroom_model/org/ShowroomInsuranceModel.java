package car_showroom_model.org;

public class ShowroomInsuranceModel {
	private int insId;
	private String name;
	private long price;

	public ShowroomInsuranceModel() {

	}

	public ShowroomInsuranceModel(String name, long price) {
		this.name = name;
		this.price = price;
	}

	public int getInsId() {
		return insId;
	}

	public void setInsId(int insId) {
		this.insId = insId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

}

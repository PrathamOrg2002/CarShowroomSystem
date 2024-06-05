package car_showroom_model.org;

public class ShowroomCarBillModel {
	private int custId;
	private int carId;
	private int bId;
	private int insId;
	private long total;

	public ShowroomCarBillModel() {

	}

	public ShowroomCarBillModel(int custId, int carId) {
		this.custId = custId;
		this.carId = carId;
	}
	
	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}
	public int getbId() {
		return bId;
	}

	public void setbId(int bId) {
		this.bId = bId;
	}

	public int getIncurance() {
		return insId;
	}

	public void setIncurance(int insId) {
		this.insId = insId;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}
}

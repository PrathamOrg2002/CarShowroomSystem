package car_showroom_model.org;

public class ShowroomCarBillModel {
	private int custId;
	private int carId;

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

}

package car_showroom_model.org;

public class CarMasterModel {
	private int carId;
	private String carName;
	private long carPrice;
	private int noOfCar;
	private String fuel;
	private long carCC;
	private int mileage;

	public CarMasterModel() {

	}

	public CarMasterModel(String carName, long carPrice, int noOfCar) {
		this.carName = carName;
		this.carPrice = carPrice;
		this.noOfCar = noOfCar;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public long getCarPrice() {
		return carPrice;
	}

	public void setCarPrice(long carPrice) {
		this.carPrice = carPrice;
	}

	public int getNoOfCar() {
		return noOfCar;
	}

	public void setNoOfCar(int noOfCar) {
		this.noOfCar = noOfCar;
	}
	
	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public long getCarCC() {
		return carCC;
	}

	public void setCarCC(long carCC) {
		this.carCC = carCC;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int milage) {
		this.mileage = milage;
	}

}

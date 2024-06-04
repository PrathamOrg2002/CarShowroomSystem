package car_showroom_model.org;

public class ShowroomCarBillModel {
	private int custId;
	private int carId;
	private int billid;
	private long insurance;
	private long total;
	public ShowroomCarBillModel()
	{
		
	}
	public ShowroomCarBillModel(int custId,int carId)
	{
		this.custId=custId;
		this.carId=carId;
	}
	
	public int getBillid() {
		return billid;
	}
	public void setBillid(int billid) {
		this.billid = billid;
	}
	public long getInsurance() {
		return insurance;
	}
	public void setInsurance(long insurance) {
		this.insurance = insurance;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
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

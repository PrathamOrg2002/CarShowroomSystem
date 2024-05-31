package car_showroom_model.org;

public class ServicingCustomerModel {
	private int id;
	private String name;
	private String contact;
	private int recurrance;
	private ServicingCarModel Model;
	
	public ServicingCustomerModel(String name, String contact, ServicingCarModel model) {
		this.name = name;
		this.contact = contact;
		Model = model;
	}
	public ServicingCustomerModel() {
		
	}
	public ServicingCarModel getModel() {
		return Model;
	}
	public void setModel(ServicingCarModel model) {
		Model = model;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public int getRecurrance() {
		return recurrance;
	}
	public void setRecurrance(int recurrance) {
		this.recurrance = recurrance;
	}

}

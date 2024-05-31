package car_showroom_model.org;

public class ShowRoomCustomreModel {
	private int scid;
	private String custName;
	private String contact;
	private String city;
	public ShowRoomCustomreModel()
	{
		
	}
	public ShowRoomCustomreModel(String custName,String contact,String city)
	{
		this.custName=custName;
		this.contact=contact;
		this.city=city;
	}
	public int getScid() {
		return scid;
	}
	public void setScid(int scid) {
		this.scid = scid;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
}

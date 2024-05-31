package car_showroom_model.org;

public class CarIssue {

	private int issueid;
	private String issuename;
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

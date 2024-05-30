package car_showroom_model.org;

public class LoginModel {
	private int rid;
	private String uName;
	private String pWord;
	private boolean accessStatus=false;  // is used for validating employee

	public LoginModel()
	{
		
	}
	public LoginModel(String uName,String pWord)
	{
		this.uName=uName;
		this.pWord=pWord;
	}
	
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getpWord() {
		return pWord;
	}
	public void setpWord(String pWord) {
		this.pWord = pWord;
	}
	public boolean isAccessStatus() {
		return accessStatus;
	}
	public void setAccessStatus(boolean accessStatus) {
		this.accessStatus = accessStatus;
	}
}

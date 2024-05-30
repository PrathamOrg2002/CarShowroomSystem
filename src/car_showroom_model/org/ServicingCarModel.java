package car_showroom_model.org;

import java.util.ArrayList;

public class ServicingCarModel {

	private int id;
	private String carnumber;
	private String carmodelname;
	ArrayList<CarIssue>al=null;
	boolean carstatus=false;
	public ArrayList<CarIssue> getAl() {
		return al;
	}

	public void setAl(ArrayList<CarIssue> al) {
		this.al = al;
	}


	public String getCarnumber() {
		return carnumber;
	}

	public void setCarnumber(String carnumber) {
		this.carnumber = carnumber;
	}

	public String getCarmodelname() {
		return carmodelname;
	}

	public void setCarmodelname(String carmodelname) {
		this.carmodelname = carmodelname;
	}



	public ServicingCarModel( String carnumber,String modelname,ArrayList<CarIssue> al) {

		this.carnumber = carnumber;
		this.carmodelname = modelname;
		this.al = al;
	}

	public ServicingCarModel() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModelname() {
		return carmodelname;
	}

	public void setModelname(String modelname) {
		this.carmodelname = modelname;
	}


	public boolean isCar_status() {
		return carstatus;
	}

	public void setCar_status(boolean car_status) {
		this.carstatus = car_status;
	}

}

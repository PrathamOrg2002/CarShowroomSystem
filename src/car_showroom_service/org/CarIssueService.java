package car_showroom_service.org;

import java.util.ArrayList;

import car_showroom_model.org.CarIssue;
import car_showroom_repository.org.CarIssueRepository;

public class CarIssueService {

	CarIssueRepository cisrepo = new CarIssueRepository();

	public boolean isAddIssue(CarIssue imodel) {
		return cisrepo.isAddIssue(imodel);
	}

	public int getIssueId(String iname) {
		return cisrepo.getIssueId(iname);
	}

	public boolean isShowAllIssue() {
		return cisrepo.isShowAllIssue();
	}

	public boolean isupdateIssueByName(String name) {
		return cisrepo.isupdateIssueByName(name);
	}

	public boolean isupdateIssueById(int id) {
		return cisrepo.isupdateIssueById(id);
	}

	public boolean getIssueById(int id) {
		return cisrepo.getIssueById(id);
	}

	public boolean deleteIssueById(int id) {
		return cisrepo.deleteIssueById(id);
	}
	
	public ArrayList<CarIssue> getAllIssueOfCar(int id)
	{
		return cisrepo.getAllIssueOfCar(id);
	}

}

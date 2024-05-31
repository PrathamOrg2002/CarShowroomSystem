package car_showroom_service.org;

import car_showroom_model.org.CarIssue;
import car_showroom_repository.org.CarIssueRepository;

public class CarIssueService {

	CarIssueRepository cisrepo=new CarIssueRepository();
	public boolean isAddIssue(CarIssue imodel) {
		return cisrepo.isAddIssue(imodel);
	}
	public int getIssueId(String iname)
	{
		return cisrepo.getIssueId(iname);
	}
	public boolean isShowAllIssue() {
		return cisrepo.isShowAllIssue();
	}
		

}

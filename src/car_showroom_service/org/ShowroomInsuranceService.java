package car_showroom_service.org;

import java.util.ArrayList;

import car_showroom_model.org.CarMasterModel;
import car_showroom_model.org.ShowroomInsuranceModel;
import car_showroom_repository.org.ShowroomInsuranceRepository;

public class ShowroomInsuranceService {
	ShowroomInsuranceRepository shInsRep= new ShowroomInsuranceRepository();
	public boolean setInsuranceInfo(ShowroomInsuranceModel shInsModel) {
		// TODO Auto-generated method stub
		return shInsRep.setInsuranceInfo(shInsModel);
	}
	public ArrayList<ShowroomInsuranceModel> getInsuranceList() {
		// TODO Auto-generated method stub
		return shInsRep.getInsuranceList();
	}
	public ShowroomInsuranceModel getInsurancePrice(int insId) {
		// TODO Auto-generated method stub
		return shInsRep.getInsurancePrice(insId);
	}

}

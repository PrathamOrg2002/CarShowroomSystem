package car_showroom_service.org;

import java.util.ArrayList;

import car_showroom_model.org.CarMasterModel;
import car_showroom_model.org.ShowroomInsuranceModel;
import car_showroom_repository.org.ShowroomInsuranceRepository;

public class ShowroomInsuranceService {
	ShowroomInsuranceRepository shInsRep = new ShowroomInsuranceRepository();

	public boolean setInsuranceInfo(ShowroomInsuranceModel shInsModel) {
		return shInsRep.setInsuranceInfo(shInsModel);
	}

	public ArrayList<ShowroomInsuranceModel> getInsuranceList() {
		return shInsRep.getInsuranceList();
	}

	public ShowroomInsuranceModel getInsurancePrice(int insId) {
		return shInsRep.getInsurancePrice(insId);
	}

}

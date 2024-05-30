package car_showroom_service.org;

import car_showroom_model.org.CarMasterModel;
import car_showroom_repository.org.CarMasterRepository;

public class CarMasterService {
	CarMasterRepository cMRepo= new CarMasterRepository();
	public boolean addCarData(CarMasterModel cMModel) {
		// TODO Auto-generated method stub
		return cMRepo.addCarData(cMModel);
	}

}

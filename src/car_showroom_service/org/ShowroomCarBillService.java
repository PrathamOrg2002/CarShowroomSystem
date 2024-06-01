package car_showroom_service.org;

import car_showroom_model.org.ShowroomCarBillModel;
import car_showroom_repository.org.ShowroomCarBillRepository;

public class ShowroomCarBillService {
	ShowroomCarBillRepository sCBRepo= new ShowroomCarBillRepository();
	public boolean addDataInBill(ShowroomCarBillModel sCBillModel) {
		// TODO Auto-generated method stub
		return sCBRepo.addDataInBill(sCBillModel);
	}

}

package car_showroom_service.org;

import car_showroom_model.org.ShowroomCarBillModel;
import car_showroom_repository.org.ShowroomCarBillRepository;

public class ShowroomCarBillService {
	ShowroomCarBillRepository sCBRepo= new ShowroomCarBillRepository();
	public boolean addDataInCarCustJoin(ShowroomCarBillModel sCBillModel) {
		// TODO Auto-generated method stub
		return sCBRepo.addDataInCarCustJoin(sCBillModel);
	}
	public void addDataInCustBill(ShowroomCarBillModel sCBillModel) {
		// TODO Auto-generated method stub
		
	}

}

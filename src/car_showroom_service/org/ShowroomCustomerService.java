package car_showroom_service.org;

import car_showroom_model.org.ShowRoomCustomreModel;
import car_showroom_repository.org.ShowroomCustomerRepository;

public class ShowroomCustomerService {
	ShowroomCustomerRepository scRepo= new ShowroomCustomerRepository();
	public boolean AddShowRCustInfo(ShowRoomCustomreModel scModel) {
		// TODO Auto-generated method stub
		return scRepo.AddShowRCustInfo(scModel);
	}
	public boolean checkDiscount() {
		// TODO Auto-generated method stub
		return scRepo.checkDiscount();
	}
	public int getCustIdByName(ShowRoomCustomreModel showRoomCustomreModel) {
		// TODO Auto-generated method stub
		return scRepo.getCustIdByName(showRoomCustomreModel);
	}

}

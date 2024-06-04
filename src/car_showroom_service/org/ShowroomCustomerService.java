package car_showroom_service.org;

import car_showroom_model.org.ShowRoomCustomreModel;
import car_showroom_repository.org.ShowroomCustomerRepository;

public class ShowroomCustomerService {
	ShowroomCustomerRepository scRepo = new ShowroomCustomerRepository();

	public boolean AddShowRCustInfo(ShowRoomCustomreModel scModel) {
		return scRepo.AddShowRCustInfo(scModel);
	}

	public boolean checkDiscount() {
		return scRepo.checkDiscount();
	}
	public int getCustIdByName(ShowRoomCustomreModel showRoomCustomreModel) {
		// TODO Auto-generated method stub
		return scRepo.getCustIdByName(showRoomCustomreModel);
	}

	public int getCustIdByName(ShowRoomCustomreModel showRoomCustomreModel) {
		return scRepo.getCustIdByName(showRoomCustomreModel);
	}

}

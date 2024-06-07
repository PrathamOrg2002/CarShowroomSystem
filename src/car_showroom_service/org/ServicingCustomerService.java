package car_showroom_service.org;

import car_showroom_model.org.ServicingCustomerModel;
import car_showroom_repository.org.ServicingCustomerRepository;

public class ServicingCustomerService {
	ServicingCustomerRepository scr = new ServicingCustomerRepository();

	public boolean isAddServicigCutomer(ServicingCustomerModel customermodel) {

		return scr.isAddServicigCutomer(customermodel);
	}

	public int getCustomerIdByName(String name) {

		return scr.getCustomerIdByName(name);
	}

	public boolean isShowAllServicigCutomer() {

		return scr.isShowAllServicigCutomer();
	}

	public boolean getCustomerByName(String name) {
		
		return scr.getCustomerByName(name);
	}
	
	public boolean getCustomerById(int id) {
		
		return scr.getCustomerById(id);
	}

	public boolean isupdateCustomerByName(String name) {
		
		return scr.isupdateCustomerByName(name);
	}

	public boolean isUpdateCustomerById(int id) {
		
		return scr.isUpdateCustomerById(id);
	}

}

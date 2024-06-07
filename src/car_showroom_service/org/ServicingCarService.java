package car_showroom_service.org;

import car_showroom_repository.org.ServicingCarRepository;

public class ServicingCarService {

	ServicingCarRepository scr = new ServicingCarRepository();

	public int getCarIdByNumber(String number) {
		return scr.getCarIdByNumber(number);
	}

	public boolean getCarById(int id) {
		return scr.getCarById(id);
	}

	public boolean changeCarStatusYesById(int carid) {

		return scr.changeCarStatusYesById(carid);
	}

	public boolean changeCarStatusNoById(int carid) {

		return scr.changeCarStatusNoById(carid);
	}
	
	public boolean getCarByCustId(int id) {
		
		return scr.getCarByCustId(id);
	}

	public boolean isUpdateCarById(int carid) {
		
		return scr.isUpdateCarById(carid);
	}

	public boolean isUpdateCarByCusId(int id) {
		
		return scr.isUpdateCarByCusId(id);
	}
}

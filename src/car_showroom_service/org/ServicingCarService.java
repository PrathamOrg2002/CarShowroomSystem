package car_showroom_service.org;

import car_showroom_repository.org.ServicingCarRepository;

public class ServicingCarService {

	ServicingCarRepository scr=new ServicingCarRepository();
	
	public int getCarIdByNumber(String number)
	{
		return scr.getCarIdByNumber(number);
	}
}

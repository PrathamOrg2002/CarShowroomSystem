package car_showroom_service.org;

import car_showroom_repository.org.ServicingCarBillRepository;

public class ServicingCarBillService {
	ServicingCarBillRepository scbr=new ServicingCarBillRepository();
	public boolean setBill(int amt,int carid,int cusid)
	{
		return scbr.setBill(amt,carid,cusid);
	}
	public boolean getBill(int cusid)
	{
		return scbr.getBill(cusid);
	}
	public boolean getSaleByParticularDate(String fromdate, String todate) {
		return scbr.getSaleByParticularDate(fromdate,todate);
	}
	

}

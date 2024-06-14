package car_showroom_repository.org;

import car_showroom_config.org.DBHelper;
import car_showroom_model.org.ShowroomCarBillModel;

public class ShowroomCarBillRepository extends DBHelper{

	public boolean addDataInBill(ShowroomCarBillModel sCBillModel) {
		try
		{
			cs=conn.prepareCall(properties.getProperty("addDataIntoCarCustJoinAndBill"));
			cs.setInt(1, sCBillModel.getCarId());
			cs.setInt(2, sCBillModel.getCustId());
			cs.setInt(3, sCBillModel.getIncurance());
			cs.setLong(4, sCBillModel.getTotal());
			return !cs.execute();
		}
		catch(Exception ex)
		{
			System.out.println("error in Add data In Bill "+ex);
		}
		
		return false;
	}

}

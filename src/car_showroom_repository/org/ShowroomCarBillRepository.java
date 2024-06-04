package car_showroom_repository.org;

import car_showroom_config.org.DBHelper;
import car_showroom_model.org.ShowroomCarBillModel;

public class ShowroomCarBillRepository extends DBHelper{

	public boolean addDataInCarCustJoin(ShowroomCarBillModel sCBillModel) {
		// TODO Auto-generated method stub
		try
		{
			pstmt=conn.prepareStatement("insert into showCustCarjoin values (?,?)");
			pstmt.setInt(1, sCBillModel.getCustId());
			pstmt.setInt(2, sCBillModel.getCarId());
			int value=pstmt.executeUpdate();
			return value>0 ? true:false;
		}
		catch(Exception ex)
		{
			System.out.println("error in Add data In Bill "+ex);
		}
		
		return false;
	}

}

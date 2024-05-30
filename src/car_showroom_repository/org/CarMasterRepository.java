package car_showroom_repository.org;

import car_showroom_config.org.DBHelper;
import car_showroom_model.org.CarMasterModel;

public class CarMasterRepository extends DBHelper{

	public boolean addCarData(CarMasterModel cMModel) {
		// TODO Auto-generated method stub
		try {
			pstmt=conn.prepareStatement("insert into carmaster values('0' ,?,?,?);");
			pstmt.setString(1, cMModel.getCarName());
			pstmt.setLong(2, cMModel.getCarPrice());
			pstmt.setInt(3, cMModel.getNoOfCar());
			return pstmt.executeUpdate()>0 ? true:false;
			
		}
		catch(Exception ex)
		{
			System.out.println("Error in Car Adding Method!!! "+ex);
		}
		return false;
	}

}

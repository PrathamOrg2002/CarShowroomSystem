package car_showroom_repository.org;

import car_showroom_config.org.DBHelper;
import car_showroom_model.org.ShowRoomCustomreModel;

public class ShowroomCustomerRepository extends DBHelper{

	public boolean AddShowRCustInfo(ShowRoomCustomreModel scModel) {
		// TODO Auto-generated method stub
		try
		{
			pstmt=conn.prepareStatement("insert into showroomcust values('0',?,?,?)");
			pstmt.setString(1, scModel.getCustName());
			pstmt.setString(2, scModel.getContact());
			pstmt.setString(3, scModel.getCity());
			return pstmt.executeUpdate()>0 ? true : false; 
		}
		catch(Exception ex)
		{
			System.out.println("Error in ShowRoom Customer adding "+ex);
			return false;
		}
	}

	public boolean checkDiscount() {
		// TODO Auto-generated method stub
		return false;
	}

}

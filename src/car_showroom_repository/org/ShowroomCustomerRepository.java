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

	public int getCustIdByName(ShowRoomCustomreModel sRCModel) {
		try {
			pstmt=conn.prepareStatement("select scId from showroomcust where custName=? and contact=?");
			pstmt.setString(1, sRCModel.getCustName());
			pstmt.setString(2,sRCModel.getContact());
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				return rs.getInt(1);
			}
			else
			{
				return -1;
			}
		}catch(Exception ex)
		{
			System.out.println("Error in get Cust Id by Name "+ex);
		}
		return 0;
	}

}

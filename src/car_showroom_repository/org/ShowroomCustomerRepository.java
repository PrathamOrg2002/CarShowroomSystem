package car_showroom_repository.org;

import car_showroom_config.org.DBHelper;
import car_showroom_model.org.ShowRoomCustomreModel;

public class ShowroomCustomerRepository extends DBHelper{

	public boolean AddShowRCustInfo(ShowRoomCustomreModel scModel) {
		try
		{
			String insertInShowroomCust =p.getProperty("insertInShowroomCust");
			pstmt=conn.prepareStatement(insertInShowroomCust);
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
		return false;
	}

	public int getCustIdByName(ShowRoomCustomreModel sRCModel) {
		try {
			String selectIdByCustNameContact=p.getProperty("selectIdByCustNameContact");
			pstmt=conn.prepareStatement(selectIdByCustNameContact);
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
			return -1;
		}
	}

}

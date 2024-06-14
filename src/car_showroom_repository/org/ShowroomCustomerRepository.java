package car_showroom_repository.org;



import car_showroom_config.org.DBHelper;
import car_showroom_model.org.ShowRoomCustomreModel;

public class ShowroomCustomerRepository extends DBHelper{

	public boolean AddShowRCustInfo(ShowRoomCustomreModel scModel) {
		try
		{
			pstmt=conn.prepareStatement(properties.getProperty("insertInShowroomCust"));
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

	public boolean checkDiscount(int custId) {
		try
		{
			pstmt=conn.prepareStatement(properties.getProperty("checkDiscountByNumOfBill"));
			pstmt.setInt(1, custId);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				int count=rs.getInt(1);
//				if(count%2==0 a)
				return count%2==0 && count!=0 ? true :false;
			}
			else
			{
				return false;
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error in check Discount "+ex);
			return false;
		}
	}

	public int getCustIdByName(ShowRoomCustomreModel sRCModel) {
		try {
			pstmt=conn.prepareStatement(properties.getProperty("selectIdByCustNameContact"));
			pstmt.setString(1,sRCModel.getCustName());
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

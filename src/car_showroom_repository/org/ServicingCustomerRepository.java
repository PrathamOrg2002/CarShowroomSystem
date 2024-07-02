package car_showroom_repository.org;

import java.util.ArrayList;

import car_showroom_config.org.DBHelper;
import car_showroom_model.org.CarIssue;
import car_showroom_model.org.ServicingCustomerModel;
import car_showroom_service.org.ServicingCarService;

public class ServicingCustomerRepository extends DBHelper {

	public boolean isAddServicigCutomer(ServicingCustomerModel customermodel) {
		
		try {
			pstmt=conn.prepareStatement(properties.getProperty("insertIdNumNamInServicingCarModel"));
			pstmt.setString(1, customermodel.getModel().getCarnumber());
			pstmt.setString(2, customermodel.getModel().getCarmodelname());
			int value=pstmt.executeUpdate();
			
			if(value>0){
				System.out.println("car of customer added sucessfully");
				pstmt=conn.prepareStatement(properties.getProperty("insertIdNamConInSerCustModel"));
				pstmt.setString(1, customermodel.getName());
				pstmt.setString(2, customermodel.getContact());
				value=pstmt.executeUpdate();
				if(value>0)
				{
					System.out.println("customer added sucessfully");
					int cid=getCustomerIdByName(customermodel.getName());
					pstmt=conn.prepareStatement(properties.getProperty("insertCarCusomerJoin"));
					ServicingCarService scs=new ServicingCarService();
					int carid=scs.getCarIdByNumber(customermodel.getModel().getCarnumber());
					pstmt.setInt(1, carid);
					pstmt.setInt(2, cid);
					value=pstmt.executeUpdate();
					if(value>0)
					{
						System.out.println("customer car join added sucessfully");
					}
					else
					{
						System.out.println("Error while adding join of car and customer");
					}
					ArrayList<CarIssue>al=customermodel.getModel().getAl();
					for(CarIssue ci:al)
					{
						int cid1=ci.getIssueid();
						pstmt=conn.prepareStatement(properties.getProperty("insertInCarIssueJoin"));
						pstmt.setInt(1,carid);
						pstmt.setInt(2,cid1);
						value=pstmt.executeUpdate();
						
					}
					return true;
				}
				else
				{
					System.out.println("Error while adding customer");
					return false;
				}
				
			}
			else
			{
				System.out.println("Error while adding carmodel");
				return false;
			}
			
		}
		catch(Exception ex)
		{
			System.out.println("Error in Adding car Method!!! "+ex);
			return false;
		}
		
	}

	public int getCustomerIdByName(String name) {
		try
		{
			pstmt=conn.prepareStatement(properties.getProperty("selectIdByCustName"));
			pstmt.setString(1,name);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				return rs.getInt(1);
			}
			return 0;
		}
		catch(Exception e)
		{
			System.out.println("Error in finding customer id "+e);
			return 0;
		}
	}

	public boolean isShowAllServicigCutomer() {
		try
		{
			pstmt=conn.prepareStatement(properties.getProperty("selectAllCustAndCar"));
			rs=pstmt.executeQuery();
			System.out.println("Id\tName\tContact\t\trecurr\tCarid\tCarno\tCarName\tCarstatus");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(4)+"\t"+rs.getInt(7)+"\t"+rs.getString(8)+"\t"+rs.getString(9)+"\t"+rs.getInt(10));
			}
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Error fetching customer");
			return false;
		}
	}

}

package car_showroom_repository.org;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

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
			if(rs.isBeforeFirst())
			{
				System.out.println("Id\tName\tContact\t\trecurr\tCarid\tCarno\tCarName\tCarstatus");
				while(rs.next())
				{
					System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(4)+"\t"+rs.getInt(7)+"\t"+rs.getString(8)+"\t"+rs.getString(9)+"\t"+rs.getInt(10));
				}
				return true;
			}
			else
			{
				System.out.println("No customer found ");
				return false;
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Error fetching customer");
			return false;
		}
	}

	public boolean getCustomerByName(String name) {
		try
		{
			pstmt=conn.prepareStatement(properties.getProperty("selectCustByName"));
			pstmt.setString(1,name);
			rs=pstmt.executeQuery();
			if(rs.isBeforeFirst())
			{
				System.out.println("Id\tName\tContact\t\trecurr");
				while(rs.next())
				{
					System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(4));
				}
				return true;
			}
			else
			{
				System.out.println("Error fetching customer");
				return false;
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Error "+e);
			return false;
		}
		
	}
	
	public boolean getCustomerById(int id) {
		try
		{
			pstmt=conn.prepareStatement(properties.getProperty("selectCustById"));
			pstmt.setInt(1,id);
			rs=pstmt.executeQuery();
			if(rs.isBeforeFirst())
			{
				System.out.println("Id\tName\tContact\t\trecurr");
				while(rs.next())
				{
					System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(4));
				}
				return true;
			}
			else
			{
				System.out.println("Customer not found ");
				return false;
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Error "+e);
			return false;
		}
		
	}

	public boolean isupdateCustomerByName(String name) {
		getCustomerByName(name);
		Scanner sc2=new Scanner(System.in);
		System.out.println("choose id from above customer you want to update");
		int id=sc2.nextInt();
		sc2.nextLine();
		System.out.println("Enter update name contact of customer");
		String namex=sc2.nextLine();
		String contactx=sc2.nextLine();
		try {
			pstmt=conn.prepareStatement(properties.getProperty("updateCustomerByName"));
			pstmt.setString(1, namex);
			pstmt.setString(2, contactx);
			pstmt.setString(3, name);
			int value=pstmt.executeUpdate();
			if(value>0)
			{
				System.out.println("Data updated succesfully...");
				return true;
			}
			else
			{
				System.out.println("Data not updated...");
				return false;
			}
		} catch (Exception e) {
			System.out.println("Error is "+e);
			return false;
		}
		
	}
	
	public boolean isUpdateCustomerById(int id) {
		Scanner sc2=new Scanner(System.in);
		System.out.println("Enter updated name, contact of customer");
		String namex=sc2.nextLine();
		String contactx=sc2.nextLine();
		try {
			pstmt=conn.prepareStatement(properties.getProperty("updateCustomerById"));
			pstmt.setString(1, namex);
			pstmt.setString(2, contactx);
			pstmt.setInt(3, id);
			int value=pstmt.executeUpdate();
			if(value>0)
			{
				System.out.println("Data updated succesfully...");
				return true;
			}
			else
			{
				System.out.println("Data not updated...");
				return false;
			}
		} catch (Exception e) {
			System.out.println("Error is "+e);
			return false;
		}
		
	}

	public boolean deletecustomerById(int id) {
		try
		{
			pstmt=conn.prepareStatement(properties.getProperty("deletecustomerById"));
			pstmt.setInt(1, id);
			int value=pstmt.executeUpdate();
			if(value>0)
			{
				System.out.println("Data deleted succesfully...");
				return true;
			}
			else
			{
				System.out.println("Data not deleted...");
				return false;
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Error is "+e);
		}
		return false;
	}
}

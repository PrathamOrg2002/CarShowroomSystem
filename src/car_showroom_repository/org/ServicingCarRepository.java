package car_showroom_repository.org;

import java.util.Scanner;

import car_showroom_config.org.DBHelper;

public class ServicingCarRepository extends DBHelper {

	public int getCarIdByNumber(String number) {
		
		try
		{
			pstmt=conn.prepareStatement(properties.getProperty("selectIdByCarNumber"));
			pstmt.setString(1,number);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				return rs.getInt(1);
			}
			return 0;
		}
		catch(Exception e)
		{
			System.out.println("Error in finding car id");
			return 0;
		}
		
	}

	public boolean getCarById(int id) {
		try
		{
			pstmt=conn.prepareStatement(properties.getProperty("selectAllServicingCarModel"));
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(4));
				return true;
			}
			else
			{
				System.out.println("No id matched with database car id");
				return false;
			}
		}
		catch(Exception e)
		{
			System.out.println("Error is "+e);
			return false;
		}
	}

	public boolean changeCarStatusYesById(int carid) {
		try
		{
			pstmt=conn.prepareStatement(properties.getProperty("updateServicingCarModel"));
			pstmt.setInt(1, carid);
			int value=pstmt.executeUpdate();
			if(value>0)
			{
				System.out.println("Status updated");
				return true;
			}
			else
			{
				System.out.println("Status not updated");
				return false;
			}
		}
		catch(Exception e)
		{
			System.out.println("Error is "+e);
			return false;
		}

	}
	public boolean changeCarStatusNoById(int carid) {
		try
		{
			pstmt=conn.prepareStatement(properties.getProperty("updateservicingcarmodelId"));
			pstmt.setInt(1, carid);
			int value=pstmt.executeUpdate();
			if(value>0)
			{
				System.out.println("Status updated");
				return true;
			}
			else
			{
				System.out.println("Status not updated");
				return false;
			}
		}
		catch(Exception e)
		{
			System.out.println("Error is "+e);
			return false;
		}

	}
	public boolean getCarByCustId(int id) {
		try
		{
			pstmt=conn.prepareStatement(properties.getProperty("getCarByCustId"));
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			if(rs.next())
			{	
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(4));
				return true;
			}
			else
			{
				System.out.println("No cars in database");
				return false;
			}
		}
		catch(Exception e)
		{
			System.out.println("Error is "+e);
			return false;
		}
	}
	public int getCarIdByCustId(int id) {
		try
		{
			pstmt=conn.prepareStatement(properties.getProperty("getCarByCustId"));
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			if(rs.next())
			{	
				return rs.getInt(1);
			}
			else
			{
				System.out.println("No cars in database");
				return -1;
			}
		}
		catch(Exception e)
		{
			System.out.println("Error is "+e);
			return -1;
		}
	}


	public boolean isUpdateCarById(int carid) {
		Scanner sc2=new Scanner(System.in);
		System.out.println("Enter updated carnumber,carmodelname of car");
		String carnumber=sc2.nextLine();
		String carmodelname=sc2.nextLine();
		try {
			pstmt=conn.prepareStatement(properties.getProperty("UpdateCarById"));
			pstmt.setString(1, carnumber);
			pstmt.setString(2, carmodelname);
			pstmt.setInt(3,carid);
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

	public boolean isUpdateCarByCusId(int id) {
		Scanner sc2=new Scanner(System.in);
		try
		{
			pstmt=conn.prepareStatement(properties.getProperty("getCarByCustId"));
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				boolean b=isUpdateCarById(rs.getInt(1));
			}
			else
			{
				System.out.println("No cars in database");
				return false;
			}
		}
		catch(Exception e)
		{
			System.out.println("Error is "+e);
			return false;
		}
		
		return false;
	}

	public boolean deleteCarById(int id) {
		try
		{
			pstmt=conn.prepareStatement(properties.getProperty("deleteCarById"));
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

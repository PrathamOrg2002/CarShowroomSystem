package car_showroom_repository.org;

import java.util.Scanner;

import car_showroom_config.org.DBHelper;

public class ServicingCarRepository extends DBHelper {

	public int getCarIdByNumber(String number) {
		
		try
		{
			String selectIdByCarNumber=p.getProperty("selectIdByCarNumber");
			pstmt=conn.prepareStatement(selectIdByCarNumber);
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
			String selectAllServicingCarModel =p.getProperty("selectAllServicingCarModel");
			pstmt=conn.prepareStatement(selectAllServicingCarModel);
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
			String updateServicingCarModel=p.getProperty("updateServicingCarModel");
			pstmt=conn.prepareStatement(updateServicingCarModel);
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
			String updateservicingcarmodelId=p.getProperty("updateservicingcarmodelId");
			pstmt=conn.prepareStatement(updateservicingcarmodelId);
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
			String getCarByCustId=p.getProperty("getCarByCustId");
			pstmt=conn.prepareStatement(getCarByCustId);
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

	public boolean isUpdateCarById(int carid) {
		Scanner sc2=new Scanner(System.in);
		System.out.println("Enter updated carnumber,carmodelname of car");
		String carnumber=sc2.nextLine();
		String carmodelname=sc2.nextLine();
		String UpdateCarById = p.getProperty("UpdateCarById");
		try {
			pstmt=conn.prepareStatement(UpdateCarById);
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
			String getCarByCustId=p.getProperty("getCarByCustId");
			pstmt=conn.prepareStatement(getCarByCustId);
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

}

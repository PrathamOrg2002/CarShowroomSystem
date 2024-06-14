package car_showroom_repository.org;

import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

import car_showroom_config.org.DBHelper;
import car_showroom_config.org.DBPathHelper;
import car_showroom_model.org.CarIssue;
import java.io.*;


public class CarIssueRepository extends DBHelper {
	
	public boolean isAddIssue(CarIssue imodel) {
		try {
			pstmt = conn.prepareStatement(properties.getProperty("insertCarIssue"));
			pstmt.setString(1, imodel.getIssuename());
			pstmt.setInt(2, imodel.getPrice());
			pstmt.setInt(3, imodel.getQuantity());
			int value = pstmt.executeUpdate();
			if (value > 0) {
				return true;
			} else {
				System.out.println("Error while adding carmodel");
				return false;
			}
		} catch (Exception e) {
			System.out.println("Error in adding issue "+e);
			return false;
		}

	}

	public int getIssueId(String iname) {
		try {
			pstmt = conn.prepareStatement(properties.getProperty("selectIssueID"));
			pstmt.setString(1, iname);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			} else {
				System.out.println("No issue found");
				return 0;
			}
		} catch (Exception e) {
			System.out.println("Error fetching issue "+e);
			return 0;
		}

	}

	public boolean isShowAllIssue() {
		try {
			pstmt = conn.prepareStatement(properties.getProperty("selectAllCarIssue"));
			rs = pstmt.executeQuery();
			System.out.println("Id\tIssue");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getInt(4));
			}
			return true;

		} catch (Exception e) {
			System.out.println("Error fetching issue "+e);
			return false;
		}
	}

	public boolean isupdateIssueByName(String name) {
		Scanner sc2=new Scanner(System.in);
		System.out.println("Enter update name price and quantity of issue");
		String namex=sc2.nextLine();
		int price=sc2.nextInt();
		int quantity=sc2.nextInt();
		try {
			pstmt=conn.prepareStatement(properties.getProperty("updateIssueByName"));
			pstmt.setString(1, namex);
			pstmt.setInt(2, price);
			pstmt.setInt(3, quantity);
			pstmt.setString(4, name);
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

	public boolean isupdateIssueById(int id) {
		Scanner sc2=new Scanner(System.in);
		System.out.println("Enter update name price and quantity of issue");
		String namex=sc2.nextLine();
		int price=sc2.nextInt();
		int quantity=sc2.nextInt();
		try {
			pstmt=conn.prepareStatement(properties.getProperty("updateIssueById"));
			pstmt.setString(1, namex);
			pstmt.setInt(2, price);
			pstmt.setInt(3, quantity);
			pstmt.setInt(4, id);
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

	public boolean getIssueById(int id) {
		try {
			pstmt = conn.prepareStatement(properties.getProperty("getIssueById"));
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			System.out.println("Id\tIssue");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getInt(4));
			}
			return true;
		} catch (Exception e) {
			System.out.println("Error fetching issue "+e);
			return false;
		}
	}

	public boolean deleteIssueById(int id) {
		try
		{
			pstmt=conn.prepareStatement(properties.getProperty("deleteIssueById"));
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
	public ArrayList<CarIssue> getAllIssueOfCar(int id)
	{
		try
		{
			ArrayList<CarIssue> al=new ArrayList<CarIssue>();
			pstmt=conn.prepareStatement(properties.getProperty("getAllIssueOfCar"));
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			if(rs.isBeforeFirst())
			{
				while(rs.next())
				{
					CarIssue m=new CarIssue();
					m.setIssueid(rs.getInt(1));
					m.setIssuename(rs.getString(2));
					m.setPrice(rs.getInt(3));
					al.add(m);
				}
				return al;
			}
			else
			{
				System.out.println("No issue of car found");
				return null;
			}
		}
		catch(Exception e)
		{
			System.out.println("Error is "+e);
			return null;
		}
	}

}

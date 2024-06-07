package car_showroom_repository.org;

import java.util.Properties;
import java.util.Scanner;

import car_showroom_config.org.DBHelper;
import car_showroom_config.org.DBPathHelper;
import car_showroom_model.org.CarIssue;
import java.io.*;


public class CarIssueRepository extends DBHelper {
	
	public boolean isAddIssue(CarIssue imodel) {
		try {
			String insertCarIssue=p.getProperty("insertCarIssue");
			pstmt = conn.prepareStatement(insertCarIssue);
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
			
			String selectIssueID = p.getProperty("selectIssueID");
			pstmt = conn.prepareStatement(selectIssueID);
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
			String selectAllCarIssue =p.getProperty("selectAllCarIssue");
			pstmt = conn.prepareStatement(selectAllCarIssue);
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
		String updateIssueByName = p.getProperty("updateIssueByName");
		try {
			pstmt=conn.prepareStatement(updateIssueByName);
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
		String updateIssueById = p.getProperty("updateIssueById");
		try {
			pstmt=conn.prepareStatement(updateIssueById);
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

}

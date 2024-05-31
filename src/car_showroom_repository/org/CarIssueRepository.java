package car_showroom_repository.org;

import car_showroom_config.org.DBHelper;
import car_showroom_model.org.CarIssue;

public class CarIssueRepository extends DBHelper {

	public boolean isAddIssue(CarIssue imodel) {
		try
		{
			pstmt=conn.prepareStatement("insert into carIssue values('0',?);");
			pstmt.setString(1,imodel.getIssuename());
		int value=pstmt.executeUpdate();
		if(value>0)
		{
			return true;			
		}
		else
		{
			System.out.println("Error while adding carmodel");
			return false;
		}
		}
		catch(Exception e)
		{
			System.out.println("Error in adding issue");
			return false;
		}
		
	}
	public int getIssueId(String iname) {
		try
		{
			pstmt=conn.prepareStatement("select issueid from carIssue where issue=?;");
			pstmt.setString(1,iname);
		rs=pstmt.executeQuery();
		if(rs.next())
		{
			return rs.getInt(1);			
		}
		else
		{
			System.out.println("No issue found");
			return 0;
		}
		}
		catch(Exception e)
		{
			System.out.println("Error fetching issue");
			return 0;
		}
		
	}
	public boolean isShowAllIssue() {
		try
		{
			pstmt=conn.prepareStatement("select * from carIssue;");
			rs=pstmt.executeQuery();
			System.out.println("Issue id\tIssue name");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2));
			}
			return true;
		
		}
		catch(Exception e)
		{
			System.out.println("Error fetching issue");
			return false;
		}
	}

}

package car_showroom_repository.org;

import car_showroom_config.org.DBHelper;
import car_showroom_model.org.LoginModel;

public class LoginRepository extends DBHelper {

	public boolean isValidShowEmp(LoginModel eRM) {
		
		try
		{
			pstmt=conn.prepareStatement("select * from empCarlogin where uName=? and pWord=?;");
			pstmt.setString(1, eRM.getuName());
			pstmt.setString(2, eRM.getpWord());
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				System.out.println("Valid user ");
				if(rs.getInt(4)==1)
				{
					
					return true;
				}
				else
				{
					System.out.println("Take authentication from admin");
					return false;
				}
			}
			else
			{
				System.out.println("Invalid user please sign up first...");
				return false;
			}
		}
		catch(Exception e)
		{
			System.out.println("Erro is "+e);
			return false;
		}
		
	}
	public boolean isValidServiceEmp(LoginModel eLModel) {
		// TODO Auto-generated method stub
		try
		{
			pstmt=conn.prepareStatement("select * from empservicelogin where uName=? and pWord=?;");
			pstmt.setString(1, eLModel.getuName());
			pstmt.setString(2, eLModel.getpWord());
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				System.out.println("Valid user ");
				if(rs.getInt(4)==1)
				{
					return true;
				}
				else
				{
					System.out.println("Take authentication from admin");
					return false;
				}
			}
			else
			{
				System.out.println("Invalid user please sign up first...");
			}
		}
		catch(Exception e)
		{
			System.out.println("Erro is "+e);
			return false;
		}
		return false;
	}

	public boolean empSignUpInShowR(LoginModel eLModel) {
		// TODO Auto-generated method stub
		try
		{
			pstmt=conn.prepareStatement("insert into empCarlogin (eid,uName,pWord) values ('0',?,?)");
			pstmt.setString(1, eLModel.getuName());
			pstmt.setString(2, eLModel.getpWord());
			int value=pstmt.executeUpdate();
			if(value>0)
			{
				return true;
			}
			return false;
		}
		catch(Exception ex)
		{
			System.out.println("Error in Registration Method???!!! "+ ex);
			return false;
		}
		
	}

	public boolean empSignUpInService(LoginModel eLModel) {
		// TODO Auto-generated method stub
		try
		{
			pstmt=conn.prepareStatement("insert into empservicelogin (eid,uName,pWord) values ('0',?,?)");
			pstmt.setString(1, eLModel.getuName());
			pstmt.setString(2, eLModel.getpWord());
			int value=pstmt.executeUpdate();
			if(value>0)
			{
				return true;
			}
			return false;
		}
		catch(Exception ex)
		{
			System.out.println("Error in Registration Method???!!! "+ ex);
			return false;
		}
	}

	

}

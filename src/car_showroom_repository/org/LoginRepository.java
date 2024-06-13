package car_showroom_repository.org;

import java.sql.SQLException;

import car_showroom_config.org.DBHelper;
import car_showroom_custom_exception.org.CheckEmployeeException;
import car_showroom_custom_exception.org.RunTimeCustomException;
import car_showroom_model.org.LoginModel;

public class LoginRepository extends DBHelper {

	public boolean isValidShowEmp(LoginModel eRM) {
		
		try
		{
			String selectEmpCarLogin=p.getProperty("selectEmpCarLogin");
			pstmt=conn.prepareStatement(selectEmpCarLogin);
			pstmt.setString(1, eRM.getuName());
			pstmt.setString(2, eRM.getpWord());
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				if(rs.getInt(4)==1)
				{
					
					return true;
				}
				else
				{
					System.out.println("Not authorized.Take authentication from admin");
					return false;
				}
			}
			else
			{
				CheckEmployeeException.checkEmpPass();	
				return false;
			}
		}
		catch(RunTimeCustomException | SQLException e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
		
	}
	public boolean isValidServiceEmp(LoginModel eLModel) {
		try
		{
			String selectEmpSerLogin=p.getProperty("selectEmpSerLogin");
			pstmt=conn.prepareStatement(selectEmpSerLogin);
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
				CheckEmployeeException.checkEmpPass();
				return false;
			}
		}
		catch(RunTimeCustomException | SQLException e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean empSignUpInShowR(LoginModel eLModel) {
		try
		{
			String insertInEmpCarLogin=p.getProperty("insertInEmpCarLogin");
			pstmt=conn.prepareStatement(insertInEmpCarLogin);
			pstmt.setString(1, eLModel.getuName());
			pstmt.setString(2, eLModel.getpWord());
			int value=pstmt.executeUpdate();
			if(value>0)
			{
				return true;
			}
			return false;
		}
		catch(RunTimeCustomException | SQLException ex)
		{
			System.out.println("Error in Registration Method???!!! "+ ex);
			ex.printStackTrace();
			return false;
		}
		
	}

	public boolean empSignUpInService(LoginModel eLModel) {
		try
		{
			String insertInEmpSerLogin=p.getProperty("insertInEmpSerLogin");
			pstmt=conn.prepareStatement(insertInEmpSerLogin);
			pstmt.setString(1, eLModel.getuName());
			pstmt.setString(2, eLModel.getpWord());
			int value=pstmt.executeUpdate();
			if(value>0)
			{
				return true;
			}
			return false;
		}
		catch(RunTimeCustomException | SQLException ex)
		{
			System.out.println("Error in Registration Method???!!! "+ ex);
			ex.printStackTrace();
			return false;
		}
	}

	

}

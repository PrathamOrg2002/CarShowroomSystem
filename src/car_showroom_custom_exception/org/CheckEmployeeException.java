package car_showroom_custom_exception.org;

public class CheckEmployeeException {

	public static void checkEmpUname(String uName) {
		for(int i=0;i<uName.length();i++)
		{
			char ch= uName.charAt(i);
			int no=ch;
			if( !( (no>=65 && no<=90) || (no>=97 && no<=122) || (no==32) ) )
			{
				throw new RunTimeCustomException("Employee Name is Invalid Please Enter the Valid Name ");
			}
		}
	}
	public static void checkEmpPass(String pass)
	{
			if( !(pass.length()>=6 && pass.length()<=10) )
			{
				throw new RunTimeCustomException("Employee Pass Word is Invalid  Please Enter the Valid Pass Word (length between 6 to 10 )");
			}
	}
	public static void checkEmpPass() {
		throw new RunTimeCustomException("🤐🤐 Employee Name is Invalid 🙏 Please Enter the Valid Name OR Sign Up 🤐🤐");
	}
}

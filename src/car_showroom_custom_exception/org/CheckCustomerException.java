package car_showroom_custom_exception.org;

public class CheckCustomerException {
	
	public static void checkCustName(String name)
	{
		for(int i=0;i<name.length();i++)
		{
			char ch= name.charAt(i);
			int no=ch;
			if( !( (no>=65 && no<=90) || (no>=97 && no<=122) || (no==32) ) )
			{
				throw new RunTimeCustomException("🤐🤐 Customer Name is Invalid 🙏 Please Enter the Valid Name 🤐🤐");
			}
		}
	}
	
	public static void checkCustContact(String contact)
	{
		for(int i=0;i<contact.length();i++)
		{
			char ch= contact.charAt(i);
			int no=ch;
			if( no<48 || no>58 || contact.length()!=10)
			{
				throw new RunTimeCustomException("🤐🤐 Customer Contact is Invalid 🙏 Please Enter the Valid Contact 🤐🤐");
			}
		}
	}

	public static void checkCustCity(String city) {
		for(int i=0;i<city.length();i++)
		{
			char ch= city.charAt(i);
			int no=ch;
			if( !( (no>=65 && no<=90) || (no>=97 && no<=122) ) )
			{
				throw new RunTimeCustomException("🤐🤐 City Name is Invalid 🙏 Please Enter the Valid City Name 🤐🤐");
			}
		}
	}
}

package car_showroom_custom_exception.org;

public class RunTimeCustomException extends ArithmeticException{
	
	private String ex=null;
	public RunTimeCustomException(String ex)
	{
		this.ex=ex;
	}
	public String getMsg()
	{
		return ex;
	}
}

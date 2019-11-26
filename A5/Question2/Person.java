public class Person
{
	private String name;

	private PhoneNumber phoneNumber;
	private String userName;
	private String password;

	public Person(String name)
	{
		phoneNumber = new PhoneNumber();
		this.name = name;
	}

	public void setAreaCode(String areaCode){
		this.phoneNumber.setAreaCode(areaCode);
	}

	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber.setPhoneNumber(phoneNumber);
	}

	public String getPhoneNumber(){
		return this.phoneNumber.getPhoneNumber();
	}

	public void setLoginCredentials(String userName, String password)
	{
		this.userName = userName;
		this.password = password;
	}
	public boolean authenticateUser()
	{
		return (userName.equals("joe") && password.equals("joepass"));
	}
}
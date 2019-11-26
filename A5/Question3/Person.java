public class Person
{
	public String name;
	public String street;
	public String city;
	public String province;
	public String postalCode;

	public Person()
	{
		name = "Rob";
		street = "Rob street";
		city = "Rob city";
		province = "Rob province";
		postalCode = "Rob postalcode";
	}

	public boolean isPersonRob()
	{
		return  this.name.equals("Rob") &&
				this.street.equals("Rob street") &&
				this.city.equals("Rob city") &&
				this.province.equals("Rob province") &&
				this.postalCode.equals("Rob postalcode");
	}


}
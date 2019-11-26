public class Person
{
	public String name;
	public Address address;

	public Person()
	{
		name = "Rob";
		address = new Address();

	}

	public boolean isPersonRob()
	{
		return  this.name.equals("Rob") && isRobsAddress(this.address);
	}

	public boolean isRobsAddress(Address a){
			return a.street.equals("Rob street") &&
				a.city.equals("Rob city") &&
				a.province.equals("Rob province") &&
				a.postalCode.equals("Rob postalcode");
	}

}


package model;

public class Instructor {
	private String name;
	private int ext;
	private String email_id;
	
	public Instructor(String n,int e, String eid)
	{
		this.name=n;
		this.ext=e;
		this.email_id=eid;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public int getPhoneExtension()
	{
		return this.ext;
	}
	
	public String getEmail()
	{
		return this.email_id;
	}
	
	public void setName(String n)
	{
		this.name = n;
	}
	
	public void setPhoneExtension(int e)
	{
		this.ext = e;
	}
	
	public void setEmail(String e)
	{
		this.email_id = e;
	}
	
	public String getInformation()
	{
		String info = "Instructor "+this.name+" has campus phone extension "+this.ext+" and contact email "+this.email_id;
		return info;
	}
}

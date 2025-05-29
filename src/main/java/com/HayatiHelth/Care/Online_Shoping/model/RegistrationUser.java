package com.HayatiHelth.Care.Online_Shoping.model;

public class RegistrationUser 
{
	@Override
	public String toString()
	{
		return "RegistrationUser [name=" + name + " ,userid=" + userid + " ,email_Id=" + email_Id + " , dob=" + dob + " ,"
				+ " mobil_no=" + mobil_no + ", password=" + password + ", address=" + address + ", pincode="
				+ pincode + ", city=" + city + "]";
	}
	private String name;
	private String email_Id;
	private String dob;
	private Number mobil_no;
	private String password;
	private String address;
	private int pincode;
	private String city;
	private String userid;

	public String getName() 
	{
		return name;
	}
	public String getEmail_Id() 
	{
		return email_Id;
	}
	public String getDob()
	{
		return dob;
	}
	public Number getMobil_no() 
	{
		return mobil_no;
	}
	public String getPassword() 
	{
		return password;
	}
	public String getAddress() 
	{
		return address;
	}
	public int getPincode()
	{
		return pincode;
	}
	public String getCity() 
	{
		return city;
	}
	public String getUserid() 
	{
		return userid;
	}
	
	
	public void setName(String name) 
	{
		this.name = name;
	}
	public void setEmail_Id(String email_Id) 
	{
		this.email_Id = email_Id;
	}
	public void setDob(String dob) 
	{
		this.dob = dob;
	}
	public void setMobil_no(Long mobil_no) 
	{
		this.mobil_no = mobil_no;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
	public void setPincode(int pincode) 
	{
		this.pincode = pincode;
	}
	public void setCity(String city) 
	{
		this.city = city;
	}
	public void setUserid(String userid) 
	{
		this.userid = userid;
	}
}

package model;

public class Friend {

	private String name;
	private String phone;
	private String address;
	private String postalCode;
	private String city;
	
	
	public Friend(String name, String phone, String address, String postal, String city) {
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.postalCode = postal;
		this.city = city;
	}

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public void describe(){
		System.out.println("Name: " + name + "\n" + "Phone: " + phone + "\n" + "Address: " + address + "\n"
				+ "Postal Code: " + postalCode + "\n" + "City:" + city + "\n");
	}
}

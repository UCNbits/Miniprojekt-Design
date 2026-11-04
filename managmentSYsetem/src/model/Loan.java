package model;

public class Loan {
	
	private int loanNumber;
	private String borrowDate;
	private String returnDate;
	private boolean status;
	private String name;
	private String phone;
	private String address;
	private int postalCode;
	private String city;


	public Loan(int loanNumber, String borrowDate, String returnDate, boolean status, String name,
			String phone, String address, int postalCode, String city) {
		this.loanNumber = loanNumber;
		this.borrowDate = borrowDate;
		this.returnDate = returnDate;
		this.status = status;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.postalCode = postalCode;
		this.city = city;
	}

	public int getLoanNumber() {
		return loanNumber;
	}

	public void setLoanNumber(int loanNumber) {
		this.loanNumber = loanNumber;
	}

	public String getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(String borrowDate) {
		this.borrowDate = borrowDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
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

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	
	
}
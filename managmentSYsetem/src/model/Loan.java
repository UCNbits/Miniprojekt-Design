package model;

public class Loan {
	private int loanNumber;
	private String borrowDate;
	private String returnDate;
	private boolean status;
	
	public Loan(int loanNumber, String borrowDate, String returnDate, boolean status) {
		super();
		this.loanNumber = loanNumber;
		this.borrowDate = borrowDate;
		this.returnDate = returnDate;
		this.status = status;
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

}

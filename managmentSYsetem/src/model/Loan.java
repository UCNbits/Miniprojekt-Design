package model;

public class Loan {

	private int loanNumber;
	private String borrowDate;
	private String returnDate;
	private String status;

	private Friend friend;
	private LP lp;
	private Copy copy;

	public Loan(int loanNumber, String borrowDate, String returnDate, String status, Friend friend, LP lp, Copy copy) {
		this.loanNumber = loanNumber;
		this.borrowDate = borrowDate;
		this.returnDate = returnDate;
		this.status = status;
		this.friend = friend;
		this.lp = lp;
		this.copy = copy;

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

	public String isStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Friend getFriend() {
		return friend;
	}

	public LP getLp() {
		return lp;
	}

	public Copy getCopy() {
		return copy;
	}
}
package model;

import java.util.ArrayList;

import controller.LPController;

public class LoanContainer {

	private static LoanContainer instance;
	private ArrayList<Loan> loanList;
	private int nextLoanNumber = 1;

	// Create a singleton
	public static LoanContainer getInstance() {
		if (instance == null) {
			instance = new LoanContainer();
		}
		return instance;
	}

	// Creates the friend container
	public LoanContainer() {
		this.loanList = new ArrayList<>();
	}

	public Loan addLoan(String borrowDate, String returnDate, String status, Friend friend, LP lp, Copy copy) {
		int loannumber = nextLoanNumber++;
		Loan loan = new Loan(loannumber, borrowDate, returnDate, status, friend, lp, copy);
		loanList.add(loan);
		return loan;
	}

	public Loan findByLoanNumber(int loanNumber) {
		for (Loan loan : loanList) {
			if (loan.getLoanNumber() == loanNumber) {
				return loan;
			}
		}
		return null;
	}

	public boolean removeLoan(int loanNumber) {
		Loan loan = findByLoanNumber(loanNumber);
		if (loan != null) {
			loanList.remove(loan);
			return true;
		}
		return false;
	}

	public ArrayList<Loan> getAllLoans() {
		return loanList;
	}

}

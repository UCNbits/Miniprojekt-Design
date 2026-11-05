package controller;

import java.util.ArrayList;

import model.Copy;
import model.Friend;
import model.LP;
import model.Loan;
import model.LoanContainer;

public class LoanController {
	public Loan addLoan(String borrowDate, String returnDate, String status, Friend friend, LP lp, Copy copy) {
		return LoanContainer.getInstance().addLoan(borrowDate, returnDate, status, friend, lp, copy);
	}

	public Loan findLoan(int loanNumber) {
		return LoanContainer.getInstance().findByLoanNumber(loanNumber);
	}

	public boolean removeLoan(int loanNumber) {
		return LoanContainer.getInstance().removeLoan(loanNumber);
	}

	public ArrayList<Loan> getAllLoans() {
		return LoanContainer.getInstance().getAllLoans();
	}
}
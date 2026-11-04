package model;

import java.util.ArrayList;

public class LoanContainer {

	private ArrayList<Loan> loans;
	
	public LoanContainer() {
		this.loans = new ArrayList<>();
	}
	
	public ArrayList<Loan> getLoan(){
		return loans;
	}
	
	public boolean addLoan(Loan l) {
		boolean res = false;
		Loan confilc = findByPhone(l.getLoanNumbe());
		
		return res;
	}

	private Loan findByPhone(int loanNumbe) {
		return null;
	}

}

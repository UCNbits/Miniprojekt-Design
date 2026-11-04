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
		Loan confilc = findByLoanNumber(l.getLoanNumber());
		if(confilc == null) {
			this.loans.add(l);
			res = true;
		}
		return res;
	}

	private Loan findByLoanNumber(int loanNumber) {
		Loan res = null;
		int i = 0;
		while(i<this.loans.size() && res == null) {
			if(loans.get(i).getLoanNumber.IgnoreCase(loanNumber)) {
				res = loans.get(i);
			}
		}
		return null;
	}

}

package model;

public class TryMeLoan {
	public static void main(String[] args){
		
		Loan lp1 = new Loan(12324, "12/12/12", "12/12/13",true, "name", "215132414", "vejvej", 2313, "miv");
		Loan lp2 = new Loan(12324, "12/12/12", "12/12/13",true, "name2", "215132414", "vejvej", 2313, "miv");
		Loan lp3 = new Loan(12222, "12/12/12", "12/12/13",true, "name3", "343356344", "vejvej", 2312, "miv2");
		
		LoanContainer container = new LoanContainer();
		
		container.addLoan(lp1);
		container.addLoan(lp2);
		container.addLoan(lp3);
		
		
		
		for(Loan l : container.getLoan()) {
			l.describe();
		}
				
	}
}

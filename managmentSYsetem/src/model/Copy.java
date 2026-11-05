package model;

public class Copy {
	private int copyNumber;
	private String purhcaseDate;
	private double purchasePrice;


	public Copy(int copyNumber, String purhcaseDate, double purchasePrice) {
		
		this.copyNumber = copyNumber;
		this.purhcaseDate = purhcaseDate;
		this.purchasePrice = purchasePrice;
	}
	
	
	public int getCopyNumber() {
		return copyNumber;
	}
	
	public void setCopyNumber(int copyNumber) {
		this.copyNumber = copyNumber;
	}
	
	
	
	public String getPurhcaseDate() {
		return purhcaseDate;
	}
	
	public void setPurhcaseDate(String purhcaseDate) {
		this.purhcaseDate = purhcaseDate;
	}
	
	
	
	public double getPurchasePrice() {
		return purchasePrice;
	}
	
	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
}

package model;

import java.util.ArrayList;


public class LP {
	private ArrayList<Copy> copies;
	
	private int barcode;
	private String title;
	private String artist;
	private String publicationDate;
	
	public LP(int barcode, String title, String artist, String publicationDate) {
		copies = new ArrayList<>();
		
		this.barcode = barcode;
		this.title = title;
		this.artist = artist;
		this.publicationDate = publicationDate;	
	}
	
	
	public int getBarcode() {
		return barcode;
	}
	public void setBarcode(int barcode) {
		this.barcode = barcode;
	}
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	
	public String getPublicationDate() {
		return publicationDate;
	}
	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}
	
	
	public Copy addCopy(int copyNumber, String purchaseDate, double purchasePrice) {
		/*System.out.println("Enter copy number: ");
		int copyNumber= scanner.nextInt();
		System.out.println("Enter purchase date: ");
		String purchaseDate = scanner.nextLine();
		System.out.println("Enter purchase price: ");
		double purchasePrice = scanner.nextDouble();*/
		Copy newCopy = new Copy(copyNumber, purchaseDate, purchasePrice);
		copies.add(newCopy);
		return newCopy;
	}
	
	public boolean removeCopy(int copyNumber) {
		Copy c = getCopy(copyNumber);
		if (c != null) {
			copies.remove(c);
			return true;
		}
		return false;
	}
	
	
	public Copy getCopy(int copyNumber) {
		for (Copy c: copies) {
			if (c.getCopyNumber() == copyNumber) {
				return c;	
			}
		}
		return null;
	}
	
	public ArrayList<Copy> getAllCopies() {
		return copies;
	}
	
	public Copy updateCopy(int CurrentCopyNumber, int newCopyNumber, String newPurchaseDate, double newPurchasePrice) {
		Copy c = getCopy(CurrentCopyNumber);
		if (c != null) {
			c.setCopyNumber(newCopyNumber);
			c.setPurhcaseDate(newPurchaseDate);
			c.setPurchasePrice(newPurchasePrice);
		}
		return c;
	}
	
}

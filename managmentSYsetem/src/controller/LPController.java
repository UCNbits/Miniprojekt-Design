package controller;

import model.LP;

import java.util.ArrayList;

import model.Copy;
import model.LPContainer;

public class LPController {
	/* 	
 	System.out.println("1 - Add LP");
	System.out.println("2 - Remove LP");
	System.out.println("3 - Find LP");
	System.out.println("4 - View all Lp's");
	System.out.println("5 - Update LP");
	*/
	
	public boolean addLp(LP lp, int copyNumber, String purchaseDate, Double purchasePrice) {
		return LPContainer.getInstance().addLp(lp, copyNumber, purchaseDate, purchasePrice);
	}
	
	public boolean removeLp(int barCode) {
		return LPContainer.getInstance().removeLp(barCode);
	}
	
	public LP findLpByBarcode(int barcode) {
		return LPContainer.getInstance().findLpByBarcode(barcode);
	}
	
	public ArrayList<LP> getAllLps(){
		return LPContainer.getInstance().getAllLps();
	}
	
	public LP updateLp(int CurrentBarcode, int newBarcode, String title, String artist, String publicationDate) {
		return LPContainer.getInstance().updateLp(CurrentBarcode, newBarcode, title, artist, publicationDate);
	}

	public Copy updateLpCopy(int barcode, int CurrentCopyNumber, int newCopyNumber, String newPurchaseDate, double newPurchasePrice) {
		return LPContainer.getInstance().updateLpCopy(barcode, CurrentCopyNumber, newCopyNumber, newPurchaseDate, newPurchasePrice);

	}
	
	
	
}

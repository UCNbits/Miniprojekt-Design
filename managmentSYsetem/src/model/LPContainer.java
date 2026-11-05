package model;

import java.util.ArrayList;
import model.LP;

public class LPContainer {

	private static LPContainer instance;
	private ArrayList<LP> lpList;

	// Create a singleton object
	public static LPContainer getInstance() {
		if (instance == null) {
			instance = new LPContainer();
		}
		return instance;
	}

	// Creates the lp container
	private LPContainer() {
		this.lpList = new ArrayList<>();
	}

	public ArrayList<LP> getLPS() {
		return new ArrayList<>(lpList);
	}

	public boolean addLp(LP lp, int copyNumber, String purchaseDate, Double purchasePrice) {
		LP conflict = findLpByBarcode(lp.getBarcode());
		if (conflict == null) {
			lpList.add(lp);
			lp.addCopy(copyNumber, purchaseDate, purchasePrice);
			return true;
		} else {
			if (conflict.getCopy(copyNumber) == null) {
				conflict.addCopy(copyNumber, purchaseDate, purchasePrice);
				return true;
			}
		}
		return false;
	}

	public boolean removeLp(int barCode) {
		LP conflict = findLpByBarcode(barCode);
		if (conflict != null) {
			return lpList.remove(conflict);
		}
		return false;
	}

	public boolean removeLpCopy(int barCode, int copyNumber) {
		LP conflict = findLpByBarcode(barCode);
		if (conflict != null) {
			return conflict.removeCopy(copyNumber);
		}
		return false;
	}

	public LP findLpByBarcode(int barcode) {
		for (int i = 0; i < lpList.size(); i++) {
			if (lpList.get(i).getBarcode() == barcode) {
				return lpList.get(i);
			}
		}
		return null;
	}

	public ArrayList<LP> getAllLps() {
		return lpList;
	}

	public LP updateLp(int CurrentBarcode, int newBarcode, String title, String artist, String publicationDate) {
		LP lp = findLpByBarcode(CurrentBarcode);
		LP newLp = findLpByBarcode(newBarcode);
		if (lp != null) {
			if (newLp == null) {
				lp.setBarcode(newBarcode);
				lp.setArtist(artist);
				lp.setTitle(title);
				lp.setPublicationDate(publicationDate);
				return lp;
			}
		}
		return null;
	}

	public Copy updateLpCopy(int barcode, int currentCopyNumber, int newCopyNumber, String newPurchaseDate,
			Double newPurchasePrice) {
		LP lp = findLpByBarcode(barcode);

		if (lp != null) {
			Copy copy = lp.getCopy(currentCopyNumber);

			if (copy != null) {
				return lp.updateCopy(currentCopyNumber, newCopyNumber, newPurchaseDate, newPurchasePrice);
			}
		}
		return null;
	}

}

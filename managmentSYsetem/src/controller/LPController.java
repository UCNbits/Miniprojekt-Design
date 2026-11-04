package controller;

import model.LP;
import model.LPContainer;

public class LPController {
	public LP findByBarcode(int barcode) {
		LP res = LPContainer.getInstance();
		return res;
	}
}

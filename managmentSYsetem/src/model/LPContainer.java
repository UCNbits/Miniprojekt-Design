package model;
import java.util.ArrayList;
import model.LP;
public class LPContainer {
	private ArrayList<LP> lps;
	
	
	public ArrayList<LP> getLPS(){
		return new ArrayList<>(lps);
	}
	
	public boolean addLPS(LP lp) {
		boolean res = false;
		if(lp != null && findLPByBarcode(lp.getBarcode()) == null) {
			res = lps.add(lp);
		}
		return res;
	}
	
	public LP findLPByBarcode(int barcode){
		LP res = null;
		for(int i = 0; i < lps.size() && res == null; i++) {
			if(lps.get(i).getBarcode() == barcode) {
				res = lps.get(i);
			}
		}
		return res;
	}

}

package model;
import java.util.ArrayList;

public class CopyContainer {
	private ArrayList<Copy> copies;
	
	public ArrayList<Copy> getCopies(){
		return new ArrayList<>(copies);
	}
	
	public boolean addCopy(Copy copy) {
		boolean res = false;
		if(copy != null && findCopyByNumber(copy.getCopyNumber())== null) {
			res = copies.add(copy);
		}
		return res;
	}
	
	public Copy findCopyByNumber(int copyNumber) {
		Copy res = null;
		for(int i = 0; i < copies.size() && res == null; i++) {
			if(copies.get(i).getCopyNumber() == copyNumber) {
				res = copies.get(i);
			}
		}
		return res;
	}
}

package controller;
import model.Copy;

public class CopyController {

public Copy findByNumber(int copyNumber) {
	Copy res = CopyContainer.getInstance();
	return res;
}
}

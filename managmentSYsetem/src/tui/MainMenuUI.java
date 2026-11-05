package tui;

import java.util.ArrayList;
import java.util.Scanner;

import model.Copy;
import model.Friend;
import model.LP;
import controller.FriendController;
import controller.LPController;


public class MainMenuUI {
	private static Scanner scanner;
	FriendController fc = new FriendController();
	LPController lpc = new LPController();
	
	public static void main(String[] args) {
		new MainMenuUI();
		
		
		
	}	
	
	public MainMenuUI() {

		Friend friend = new Friend("Malthe", "12345678", "Sofiendalvej", "9000", "Aalborg");
		fc.addFriend(friend);
		
		Friend friend1 = new Friend("A", "123", "coolAddress", "9999", "coolCity");
		fc.addFriend(friend1);
		
		createLpTest(123, "Santas comming for us", "Sia", "24-12-2099", 1, "12-25-2099", 123.456);
		createLpTest(123, "Santas comming for us", "Sia", "24-12-2099", 2, "12-25-2099", 999.99);
		createLpTest(1234, "Thunder Struck", "ADDC", "24-12-1999", 1, "01-01-2000", 12.34);


		
			
		
		scanner = new Scanner(System.in);	
		
		System.out.println("LP borrowing system");
		
		boolean toggle = true; // Toggles the tui loop on and of
		
		while(toggle) {
			
			System.out.println("\n--- Main menu ---");
			System.out.println("1 - Friends Menu");
			System.out.println("2 - LP Menu");
			System.out.println("3 - Loan Menu");
			System.out.println("4 - Generate test data");
			System.out.println("0 - Exit");
			
			String choice = getChoice();
			System.out.println(choice);
			
			switch(choice) {
			case "1": friendsMenu();
			break;
			case "2": lpMenu(); //TODO
			break;
			case "3": loanMenu(); //TODO
			break;
			case "4": testMenu(); //TODO
			break;
			case "0": toggle = false;
			break;
			default:
				System.out.println("Some error");
				
			}	
		
		}
	}
	
	private void friendsMenu() {
		boolean friendToggle = true;
		while (friendToggle) {
			System.out.println("\n--- Friends Menu ---");
			System.out.println("1 - Add Friend");
			System.out.println("2 - Remove Friend");
			System.out.println("3 - Find Friend");
			System.out.println("4 - View all Friends");
			System.out.println("5 - Update Friend");
			System.out.println("0 - Return to main menu");
			
			String choice = getChoice();
			
			switch(choice){
			case "1": 
				createFriend();
			break;
			
			case "2":
				String rPhone = getInput("Enter friends phone number:");
				String rName = getInput("Enter friends name:");
				fc.removeFriend(rPhone, rName);
			break;
			
			case "3":
				String fPhone = getInput("Enter friends phone number:");
				Friend fFriend = fc.findFriend(fPhone);
				printFriendData(fFriend);
				
			break;
			
			case "4": 
				ArrayList<Friend> friends = fc.viewAllFriends(); //// TODOOOOOOOOO
				for (Friend f: friends) {
					printFriendData(f);
				}
			break;
			
			case "5": updateMenu(); //// TODOOOOOOOOO
			break;
			
			case "0": return;
			default:
				System.out.println("Some error - friends menu");
			}
		}
	}
	
	private void updateMenu() {		
		String currPhone = getInput("Enter friends current number:");
		String newName = getInput("Enter new name:");
		String newPhone = getInput("Enter new phone number:");
		String newAddress = getInput("Enter new address:");
		String newPostal = getInput("Enter new postal code:");
		String newCity = getInput("Enter new city:");
		
		Friend updateFriend = fc.updateInfo(currPhone, newName, newPhone, newAddress, newPostal, newCity);
		printFriendData(updateFriend);
	}

	
	
	
	private void lpMenu() {
		
		boolean lpToggle = true;
		while (lpToggle) {
			System.out.println("\n--- Lp Menu --- ");
			System.out.println("1 - Add LP");
			System.out.println("2 - Remove LP");
			System.out.println("3 - Find LP");
			System.out.println("4 - View all Lp's");
			System.out.println("5 - Update LP");
			System.out.println("6 - Update LP copy");
			System.out.println("0 - Return to main menu");
			
			String choice = getChoice();
			System.out.println(choice);
			
			switch(choice){
			case "1": //addLp();
				int barcode = getInputInt("Enter lp barcoode:");
					String title = getInput("Enter lp title:");
					String artist = getInput("Enter lp artist:");
					String pubDate = getInput("Enter lp publication date:");
					int copyNumber = getInputInt("Enter copy number:");
					String purchaseDate = getInput("Enter purchase date:");
					double purchasePrice = getInputDouble("Enter purchase price:");
					
					LP lp = new LP(barcode, title, artist, pubDate);
					
					if (lpc.addLp(lp, copyNumber, purchaseDate, purchasePrice)) {
						System.out.println("Added lp to collection");

						} else {
							System.out.println("Barcode already exists");
				}
			break;
			
			
			case "2": //removeLp();
				int rBarcode = getInputInt("Enter lp barcode");
				lpc.removeLp(rBarcode);
			break;
			
			
			case "3": //findLp();
				int fBarcode = getInputInt("Enter a lp barcode:");
				LP foundLp = lpc.findLpByBarcode(fBarcode);
				if (foundLp != null) {
					System.out.println("LP" + ", Title: " + foundLp.getTitle() + ", Artist: " + foundLp.getArtist() + ", Publication Date: " + foundLp.getPublicationDate());
					for (Copy c : foundLp.getAllCopies()) {
						System.out.println("	Copy Number: " + c.getCopyNumber() + ", purchase Date: " + c.getPurhcaseDate() + ", Purchase Price: " + c.getPurchasePrice());	
					}
				}
				System.out.println();
				lpc.findLpByBarcode(fBarcode);
				break;
				
			
			case "4": // print all Lp's
				for (LP l : lpc.getAllLps()) {
					System.out.println("Barcode: " + l.getBarcode() + ", Title: " + l.getTitle() + ", Artist: " + l.getArtist() + ", Publication Date: " + l.getPublicationDate());
					for (Copy c : l.getAllCopies()){
						System.out.println("	Copy Number: " + c.getCopyNumber() + ", purchase Date: " + c.getPurhcaseDate() + ", Purchase Price: " + c.getPurchasePrice());
					}
				}
			break;
			
			
			case "5": //updateLp();
				int cBarcode = getInputInt("Enter current lp barcode");
				int uBarcode = getInputInt("Enter new lp barcode");
				String uTitle = getInput("Enter new title:");
				String uArtist = getInput("Enter new artist name:");
				String uPublicationDate = getInput("Enter new publication date:");
					
				lpc.updateLp(cBarcode, uBarcode, uTitle, uArtist, uPublicationDate);
			break;
			
			case "6": //updateLpCopy();
				int gBarcode = getInputInt("Enter lp barcode");
				
				int CurrentCopyNumber = getInputInt("Enter current lp copy number");
				int newCopyNumber = getInputInt("Enter new copy number:");
				String newPurchaseDate = getInput("Enter new purchase date:");
				Double newPurchasePrice = getInputDouble("Enter new purchase price:");
									
				
				
				Copy updatedCopy = lpc.updateLpCopy(gBarcode ,CurrentCopyNumber, newCopyNumber, newPurchaseDate, newPurchasePrice);
				
				if (updatedCopy != null) {
					System.out.println("copy updated");
				} else {
					System.out.println("copy not updared, check barcode or copy number");
				}
				
				
			break;
			
			case "0": return;
			default:
				System.out.println("Some error - LP menu");
			}
		}
	}

	private void loanMenu() {
		System.out.println("\n--- Loan Menu ---");
		System.out.println("1 - Add loan");
		System.out.println("2 - Remove loan");
		System.out.println("3 - Find loan");
		System.out.println("4 - Show all loans");
		System.out.println("5 - Return loan");
		System.out.println("0 - Return to main menu");
		
		String choice = getChoice();
		System.out.println(choice);

		
		boolean lpToggle = true;
		while (lpToggle) {
			switch(choice){
			case "1": //addLoan();
			break;
			
			case "2": //removeLoan();
			break;
			
			case "3": //findLoan();
			break;
			
			case "4": //showAllLoans();
			break;
			
			case "5": //returnLoan();
			break;
			
			case "0": return;
			default:
				System.out.println("Some error - LP menu");
			}
		}
	}
	
	private void testMenu() {
		
		boolean lpToggle = true;
		while (lpToggle) {
			System.out.println("\n--- Test Menu ---");
			System.out.println("1 - Add test");
			System.out.println("2 - Remove test");
			System.out.println("0 - Return to main menu");
			
			String choice = getChoice();
			System.out.println(choice);
			
			switch(choice){
			case "1": //addTest();
				String tName = "Malthe";
				String tPhone = "12345678";
				String tAddress = "Sofiendalvej";
				String tPostal = "9000";
				String tCity = "Aalborg";
				Friend friend = new Friend(tName, tPhone, tAddress, tPostal, tCity);
				fc.addFriend(friend);
				
				String tName1 = "A";
				String tPhone1 = "123";
				String tAddress1 = "B";
				String tPostal1 = "1";
				String tCity1 = "C";
				Friend friend1 = new Friend(tName1, tPhone1, tAddress1, tPostal1, tCity1);
				fc.addFriend(friend1);
			break;
			case "2": //removeTest();
			break;
			case "0": return;
			default:
				System.out.println("Some error - LP menu");
			}
		}
	}	
	
	
	
	
	private void RegisterLoan() {
		System.out.println("Please enter the friends phone number: ");
		String phoneNumber = scanner.nextLine();
		
		System.out.println(fc.findFriend(phoneNumber));
		
		//selectFriend();
		//selectLpCopy();
		//loan();
		//addLoan();
	}
	
	private String getChoice() {
		String input = scanner.nextLine();
		return input;
	}
	
	
	private String getInput(String msg) {
		System.out.println(msg);
		return scanner.nextLine();
	}
	
	private int getInputInt(String msg) {
		System.out.println(msg);
		int input = scanner.nextInt();
		scanner.nextLine();
		return input;
	}
	
	private double getInputDouble(String msg) {
		System.out.println(msg);
		double input = scanner.nextDouble();
		scanner.nextLine();
		return input;
	}
	
	
	private void createFriend() {
		String aName = getInput("Enter name:");
		String aPhone = getInput("Enter phone number:");
		String aAddress = getInput("Enter address:");
		String aPostal = getInput("Enter postal code:");
		String aCity = getInput("Enter city:");
		Friend friend = new Friend(aName, aPhone, aAddress, aPostal, aCity);
		fc.addFriend(friend);
	}
	
	public void printFriendData(Friend f) {
		System.out.println("User Info -> "+ 
				"Name: " + f.getName() + 
				", Phone: " + f.getPhone() + 
				", Address: " + f.getAddress() + 
				", Postal Code: " + f.getPostalCode() + 
				", City: " + f.getCity());
	}
		
	
	public void createLpTest(int barcode, String title, String artist, String pubDate, int copyNumber, String purchaseDate, double purchasePrice) {
		LP lp = new LP(barcode, title, artist, pubDate);
		
		if (lpc.addLp(lp, copyNumber, purchaseDate, purchasePrice)) {
			System.out.println("Added lp to collection");

			} else {
				System.out.println("Barcode already exists");	
			}
	}
	
	
}
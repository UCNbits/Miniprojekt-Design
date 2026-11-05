package tui;

import java.util.ArrayList;
import java.util.Scanner;

import model.Copy;
import model.Friend;
import model.LP;
import model.Loan;
import model.LoanContainer;
import controller.FriendController;
import controller.LPController;
import controller.LoanController;

public class MainMenuUI {
	private static Scanner scanner;
	FriendController fc = new FriendController();
	LPController lpc = new LPController();
	LoanController lc = new LoanController();

	// main loop running the program
	public static void main(String[] args) {
		new MainMenuUI();
	}

	// prints all items in the main menu and what options do
	public MainMenuUI() {
		scanner = new Scanner(System.in);
		System.out.println("LP borrowing system");

		boolean toggle = true;

		while (toggle) {

			System.out.println("\n--- Main menu ---");
			System.out.println("1 - Friends Menu");
			System.out.println("2 - LP Menu");
			System.out.println("3 - Loan Menu");
			System.out.println("4 - Generate test data");
			System.out.println("0 - Exit");

			String choice = getChoice();
			// System.out.println(choice);

			switch (choice) {
			case "1":
				friendsMenu();
				break;
			case "2":
				lpMenu();
				break;
			case "3":
				loanMenu();
				break;
			case "4":
				testData();
				break;
			case "0":
				return;
			default:
				System.out.println("Some error - main menu");
			}
		}
	}

	// prints all items in the friends menu and what options do
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

			switch (choice) {
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
				for (Friend f : friends) {
					printFriendData(f);
				}
				break;

			case "5":
				updateMenu();
				break;

			case "0":
				return;
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

	// prints all items in the lp menu and what options do
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
			// System.out.println(choice);

			switch (choice) {
			// add LP
			case "1":
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

			// Remove LP
			case "2":
				int rBarcode = getInputInt("Enter lp barcode");
				lpc.removeLp(rBarcode);
				break;

			// Find Lp
			case "3":
				int fBarcode = getInputInt("Enter a lp barcode:");
				LP foundLp = lpc.findLpByBarcode(fBarcode);
				if (foundLp != null) {
					System.out.println("LP" + ", Title: " + foundLp.getTitle() + ", Artist: " + foundLp.getArtist()
							+ ", Publication Date: " + foundLp.getPublicationDate());
					for (Copy c : foundLp.getAllCopies()) {
						System.out.println("	Copy Number: " + c.getCopyNumber() + ", purchase Date: "
								+ c.getPurhcaseDate() + ", Purchase Price: " + c.getPurchasePrice());
					}
				}
				System.out.println();
				lpc.findLpByBarcode(fBarcode);
				break;

			// print all Lp's
			case "4":
				for (LP l : lpc.getAllLps()) {
					System.out.println("Barcode: " + l.getBarcode() + ", Title: " + l.getTitle() + ", Artist: "
							+ l.getArtist() + ", Publication Date: " + l.getPublicationDate());
					for (Copy c : l.getAllCopies()) {
						System.out.println("	Copy Number: " + c.getCopyNumber() + ", purchase Date: "
								+ c.getPurhcaseDate() + ", Purchase Price: " + c.getPurchasePrice());
					}
				}
				break;

			// update LP
			case "5":
				int cBarcode = getInputInt("Enter current lp barcode");
				int uBarcode = getInputInt("Enter new lp barcode");
				String uTitle = getInput("Enter new title:");
				String uArtist = getInput("Enter new artist name:");
				String uPublicationDate = getInput("Enter new publication date:");

				lpc.updateLp(cBarcode, uBarcode, uTitle, uArtist, uPublicationDate);
				break;

			// update LP copy
			case "6":
				int gBarcode = getInputInt("Enter lp barcode:");
				int CurrentCopyNumber = getInputInt("Enter current lp copy number:");
				int newCopyNumber = getInputInt("Enter new copy number:");
				String newPurchaseDate = getInput("Enter new purchase date:");
				Double newPurchasePrice = getInputDouble("Enter new purchase price:");

				Copy updatedCopy = lpc.updateLpCopy(gBarcode, CurrentCopyNumber, newCopyNumber, newPurchaseDate,
						newPurchasePrice);

				if (updatedCopy != null) {
					System.out.println("copy updated");
				} else {
					System.out.println("copy not updated, check barcode or copy number");
				}
				break;

			case "0":
				lpToggle = false;

			default:
				System.out.println("Some error - LP menu");
			}
		}
	}

	// prints all items in the loan menu and what options do
	private void loanMenu() {
		boolean loanToggle = true;

		while (loanToggle) {
			System.out.println("\n--- Loan Menu ---");
			System.out.println("1 - Add loan");
			System.out.println("2 - Remove loan");
			System.out.println("3 - Find loan");
			System.out.println("4 - Show all loans");
			System.out.println("0 - Return to main menu");

			String choice = getChoice();
			// System.out.println(choice);

			switch (choice) {

			// add loan
			case "1":
				String phone = getInput("Enter friends phone number:");
				Friend friend = fc.findFriend(phone);
				int barcode = getInputInt("Enter LP barcode:");
				LP lp = lpc.findLpByBarcode(barcode);
				int copyNumber = getInputInt("Enter copy number:");
				Copy copy = lp.getCopy(copyNumber);

				String borrowDate = getInput("Enter borrow date:");
				String returnDate = getInput("Enter return date:");

				if (friend != null && lp != null && copy != null) {
					Loan loan = lc.addLoan(borrowDate, returnDate, "active", friend, lp, copy);

					if (loan != null) {
						System.out.println("Loan added");
						System.out.println("Loan number: " + loan.getLoanNumber());
					} else {
						System.out.println("Error trying to add loan");
					}
				}
				break;

			// remove Loan
			case "2":
				int getLoanNumber = getInputInt("Enter loan number:");
				if (lc.removeLoan(getLoanNumber)) {
					System.out.println("Loan removed.");
				} else {
					System.out.println("Loan not found.");
				}
				break;

			// find Loan
			case "3":
				int loanNumber = getInputInt("Enter loan number:");
				Loan loanFound = lc.findLoan(loanNumber);

				if (loanFound != null) {
					printLoanData(loanFound);
				} else {
					System.out.println("Loan not found");
				}
				break;

			// print all Loans
			case "4":
				ArrayList<Loan> loans = lc.getAllLoans();
				if (loans.isEmpty()) {
					System.out.println("Could not find any loans");
				} else {
					for (Loan loan : loans) {
						printLoanData(loan);
					}
				}
				break;

			case "0":
				return;
			default:
				System.out.println("Some error - loan menu");
			}
		}
	}

	private void testData() {
		// creates and adds 2 friends
		Friend friend = new Friend("CoolFriend1", "11111111", "coolAddress 1", "9000", "Aalborg");
		Friend friend1 = new Friend("CoolFriend2", "12121212", "coolAddress 2", "9000", "Aalborg");

		fc.addFriend(friend);
		fc.addFriend(friend1);

		// creates 2 different LP's, one of which has 2 copies.
		createLp(123, "Santas comming for us", "Sia", "2017", 1, "2020", 9.99);
		createLp(123, "Santas comming for us", "Sia", "2017", 2, "2025", 19.95);
		createLp(1234, "Thunderstruck", "AC/DC", "1990", 1, "2000", 10.0);

		// Find the friend by phonenumber
		Friend loanFriend = fc.findFriend("11111111");

		// find the lp and find the lp copy
		LP loanLp = lpc.findLpByBarcode(123);
		Copy loanCopy = loanLp.getCopy(1);

		// if none are null they can be added as a entry
		if (loanFriend != null && loanLp != null && loanCopy != null) {
			Loan loan = lc.addLoan("01-01-2026", "01-01-2027", "active", loanFriend, loanLp, loanCopy);
		} else {
			System.out.println("Could not create loan");
		}
	}

	// prints data from loan when called with a loan object.
	private void printLoanData(Loan loan) {
		System.out.println("Loan number: " + loan.getLoanNumber());
		System.out.println("Name: " + loan.getFriend().getName());
		System.out.println("Phone: " + loan.getFriend().getPhone());
		System.out.println("Title: " + loan.getLp().getTitle());
		System.out.println("Artist: " + loan.getLp().getArtist());
		System.out.println("Barcode: " + loan.getLp().getBarcode());
		System.out.println("Copy number: " + loan.getCopy().getCopyNumber());
		System.out.println("Borrow date: " + loan.getBorrowDate());
		System.out.println("Return date: " + loan.getReturnDate());
		System.out.println("Status: " + loan.isStatus());
	}

	// to get choice from main menu
	private String getChoice() {
		String input = scanner.nextLine();
		return input;
	}

	// get next string input
	private String getInput(String msg) {
		System.out.println(msg);
		return scanner.nextLine();
	}

	// get int input
	private int getInputInt(String msg) {
		System.out.println(msg);
		int input = scanner.nextInt();
		scanner.nextLine();
		return input;
	}

	// get double input
	private double getInputDouble(String msg) {
		System.out.println(msg);
		double input = scanner.nextDouble();
		scanner.nextLine();
		return input;
	}

	// method to create a friend by method call
	private void createFriend() {
		String aName = getInput("Enter name:");
		String aPhone = getInput("Enter phone number:");
		String aAddress = getInput("Enter address:");
		String aPostal = getInput("Enter postal code:");
		String aCity = getInput("Enter city:");
		Friend friend = new Friend(aName, aPhone, aAddress, aPostal, aCity);
		fc.addFriend(friend);
	}

	// print the date from a friend
	public void printFriendData(Friend f) {
		System.out.println("User Info: " + "Name: " + f.getName() + ", Phone: " + f.getPhone() + ", Address: "
				+ f.getAddress() + ", Postal Code: " + f.getPostalCode() + ", City: " + f.getCity());
	}

	// create lp with method call
	public void createLp(int barcode, String title, String artist, String pubDate, int copyNumber, String purchaseDate,
			double purchasePrice) {
		LP lp = new LP(barcode, title, artist, pubDate);

		if (lpc.addLp(lp, copyNumber, purchaseDate, purchasePrice)) {
			System.out.println("Added lp to collection");

		} else {
			System.out.println("Barcode already exists");
		}
	}

}
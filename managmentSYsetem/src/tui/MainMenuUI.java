package tui;

import java.util.ArrayList;
import java.util.Scanner;

import model.Friend;
import controller.FriendController;


public class MainMenuUI {
	private static Scanner scanner;
	FriendController fc = new FriendController();
	
	public static void main(String[] args) {
		new MainMenuUI();
		
		
		
	}	
	
	public MainMenuUI() {
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
	
	
	// update logic missing
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
			System.out.println("4 - Update LP");
			System.out.println("0 - Return to main menu");
			
			String choice = getChoice();
			System.out.println(choice);
			
			switch(choice){
			case "1": //addLp();
			break;
			case "2": //removeLp();
			break;
			case "3": //findLp();
			break;
			case "4": //updateLp();
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
	
	private String getChoice() {
		String input = scanner.nextLine();
		return input;
	}
	
	private String getInput(String msg) {
		System.out.println(msg);
		return scanner.nextLine();
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
	
	

	private void RegisterLoan() {
		System.out.println("Please enter the friends phone number: ");
		String phoneNumber = scanner.nextLine();
		
		System.out.println(fc.findFriend(phoneNumber));
		
		//selectFriend();
		//selectLpCopy();
		//loan();
		//addLoan();
	}
	
	
	private void tester() {
		Friend f1 = new Friend("Name", "12121212", "address", 1234, "aalborg");
		Friend f2 = new Friend("Name2", "34343434", "coolAddress", 6789, "aalborg");
		fc.addFriend(f1);
		fc.addFriend(f2);
	}
}
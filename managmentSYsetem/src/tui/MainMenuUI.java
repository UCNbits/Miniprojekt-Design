package tui;

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
			case "1": friendsMenu(); //TODO
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
		System.out.println("\n--- Friends Menu ---");
		System.out.println("1 - Add Friend");
		System.out.println("2 - Remove Friend");
		System.out.println("3 - Find Friend");
		System.out.println("4 - Update Friend");
		System.out.println("0 - Return to main menu");
		
		String choice = getChoice();
		System.out.println(choice);

		
		boolean friendToggle = true;
		while (friendToggle) {
			switch(choice){
			case "1": //addFriend();
			break;
			case "2": //removeFriend();
			break;
			case "3": //findFriend();
			break;
			case "4": //updateFriend();
			break;
			case "0": return;
			default:
				System.out.println("Some error - friends menu");
			}
		}
	}

	private void lpMenu() {
		System.out.println("\n--- Lp Menu --- ");
		System.out.println("1 - Add LP");
		System.out.println("2 - Remove LP");
		System.out.println("3 - Find LP");
		System.out.println("4 - Update LP");
		System.out.println("0 - Return to main menu");
		
		String choice = getChoice();
		System.out.println(choice);

		
		boolean lpToggle = true;
		while (lpToggle) {
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
		System.out.println("4 - Return loan");
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
			case "4": //returnLoan();
			break;
			case "0": return;
			default:
				System.out.println("Some error - LP menu");
			}
		}
	}
	
	private void testMenu() {
		System.out.println("\n--- Test Menu ---");
		System.out.println("1 - Add test");
		System.out.println("2 - Remove test");
		System.out.println("0 - Return to main menu");
		
		String choice = getChoice();
		System.out.println(choice);

		
		boolean lpToggle = true;
		while (lpToggle) {
			switch(choice){
			case "1": //addTest();
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
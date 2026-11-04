package tui;

import java.util.Scanner;

import model.Friend;
import controller.FriendController;


public class MainMenuUI {
	private static Scanner scanner;

	
	public MainMenuUI() {
		super();
		scanner = new Scanner(System.in);	
		
		System.out.println("LP borrowing system");
		
		boolean loopToggle = true; // Toggles the tui loop on and of
		
		while(loopToggle) {
			System.out.println("0 - Exit");
			System.out.println("1 - Register Loan");
			
			System.out.println("Please chose an option: ");
			getChoice();
		
			
			switch(getChoice()) {
			case "0": loopToggle = false;
			case "1": RegisterLoan();
			break;
			default:
				break;
				
			
			
			}	
		}
	}

	
	private String getChoice() {
		String input = scanner.nextLine();
		return input;
	}
	

	private void RegisterLoan() {
		FriendController.findFriend(String phone);
		
		//selectFriend();
		//selectLpCopy();
		//loan();
		//addLoan();
		
	}
	
	

}
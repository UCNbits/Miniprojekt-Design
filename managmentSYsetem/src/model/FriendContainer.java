package model;

import java.util.ArrayList;


public class FriendContainer {
	private ArrayList<Friend> friends;
	private FriendContainer controller;
	
	public FriendContainer(ArrayList<Friend> friends, FriendContainer controller) {
		
		this.friends = new ArrayList<>();
		this.setController(controller);
	}

	public ArrayList<Friend> getFriends() {
		return friends;
	}

	public boolean addFriend(Friend f) {
		boolean res = false;
		
		
		return res;
	}

	public FriendContainer getController() {
		return controller;
	}

	public void setController(FriendContainer controller) {
		this.controller = controller;
	}


	
	
	

}

package model;

import java.util.ArrayList;


public class FriendContainer {
	private ArrayList<Friend> friends;
	private FriendContainer container;
	
	public FriendContainer(ArrayList<Friend> friends, FriendContainer container) {
		
		this.friends = new ArrayList<>();
		this.setContainer(container);
	}

	public ArrayList<Friend> getFriends() {
		return friends;
	}

	public boolean addFriend(Friend f) {
		boolean res = false;
		
		
		return res;
	}

	public FriendContainer getContainer() {
		return container;
	}

	public void setContainer(FriendContainer container) {
		this.container = container;
	}


	
	
	

}

package controller;

import model.Friend;
import model.FriendContainer;

public class FriendController {
	
	public Friend findFriend(String phone) {
		return FriendContainer.getInstance().findByPhone(phone);	
	}
	
	public void addFriend(Friend f) {
		FriendContainer.getInstance().addFriend(f);
	}
	
	public void removeFriend(String phone, String name) {
		FriendContainer.getInstance().removeFriend(phone, name);
	}
	
	
	

}

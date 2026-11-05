package controller;

import java.util.ArrayList;
import model.Friend;
import model.FriendContainer;

public class FriendController {

	public Friend findFriend(String phone) {
		return FriendContainer.getInstance().findByPhone(phone);
	}

	public boolean addFriend(Friend f) {
		return FriendContainer.getInstance().addFriend(f);
	}

	public Friend removeFriend(String phone, String name) {
		return FriendContainer.getInstance().removeFriend(phone, name);
	}

	public ArrayList<Friend> viewAllFriends() {
		return FriendContainer.getInstance().getFriends();
	}

	public Friend updateInfo(String currPhone, String newName, String newPhone, String newAddress, String newPostal,
			String newCity) {
		return FriendContainer.getInstance().updateInfo(currPhone, newName, newPhone, newAddress, newPostal, newCity);
	}

}
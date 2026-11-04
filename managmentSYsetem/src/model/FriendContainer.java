package model;

import java.util.ArrayList;


public class FriendContainer {

	private static FriendContainer instance;
	private ArrayList<Friend> friendList = new ArrayList<>();
	
	
	public static FriendContainer getInstance() {
		if(instance == null) {
			instance = new FriendContainer();
		}
		return instance;
	}
	
	
	public FriendContainer() {
		this.friendList = new ArrayList<>();
	}

	public ArrayList<Friend> getFriends() {
		return friendList;
	}

	public boolean addFriend(Friend f) {
		boolean res = false;
        Friend conflic = findByPhone(f.getPhone());
        if(conflic == null){
            friendList.add(f);
            res = true;
        }
        return res;
	}
	
	
	public boolean removeFriend(String phone, String name) {
		boolean res = false;

		for(int i = 0; i < friendList.size(); i++) {
			Friend user = friendList.get(i);
			if(friendList.get(i).getName() == name && friendList.get(i).getPhone() == phone) {
				friendList.remove(i);
				System.out.println("Removed: " + user.getName() + "from the list." +
				"\n    Name: " + user.getName() +
				"\n    Phone: " + user.getPhone() + 
				"\n    Address: " + user.getAddress() +
				"\n    postalCode: " + user.getPostalCode() +
				"\n    City: " + user.getCity());
				break;
				
			} else {
				System.out.println("Could not find user. Please recheck the details and try again.");
				res = false;
			}	
		}
		
		return res;
	}
	
    
    public Friend findByPhone(String phone){
        Friend res = null;
        int i = 0;
        while(i < this.friendList.size() && res == null){
            if(friendList.get(i).getPhone().equalsIgnoreCase(phone)){
                res = friendList.get(i);
            }
            i++;
        }
        return res;
    }
	
}

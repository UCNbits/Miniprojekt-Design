package model;

import java.util.ArrayList;


public class FriendContainer {

	private static FriendContainer instance;
	private ArrayList<Friend> friendList;
	
	
	// Creates a singleton so that we only have one
	public static FriendContainer getInstance() {
		if(instance == null) {
			instance = new FriendContainer();
		}
		return instance;
	}
	
	// Creates the friend container
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
	
	
	public Friend removeFriend(String phone, String name) {
		Friend res = null;
		for(int i = 0; i < friendList.size(); i++) {
			Friend user = friendList.get(i);
			if(user.getName().equals(name) && user.getPhone().equals(phone)) {
				friendList.remove(i);
				res = user;
				break;
			} 
		}
		return res;
	}
	
    
    public Friend findByPhone(String phone){
    	Friend res = null;
    	for(int i = 0; i < friendList.size(); i++) {
    		if (friendList.get(i).getPhone().equals(phone)) {
    			res = friendList.get(i);
    			break;
    		} else {
    			res = null;
    		}	
    	}
    	return res;
    }
    		
    
    public Friend updateInfo(String currPhone, String newName, String newPhone, String newAddress, String newPostal, String newCity) {
    	Friend f = findByPhone(currPhone);
    	if (f != null) {
    		f.setName(newName);
    		f.setPhone(newPhone);
    		f.setAddress(newAddress);
    		f.setPostalCode(newPostal);
    		f.setCity(newCity);
    	}
    	return f;
    }
    
    
    
    
    
}

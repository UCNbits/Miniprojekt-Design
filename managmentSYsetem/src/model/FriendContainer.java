package model;

import java.util.ArrayList;


public class FriendContainer {
	
	private ArrayList<Friend> friends;
	
	
	public FriendContainer() {
		this.friends = new ArrayList<>();
	}

	public ArrayList<Friend> getFriends() {
		return friends;
	}

	public boolean addFriend(Friend f) {
		boolean res = false;
        Friend conflic = findByPhone(f.getPhone());
        if(conflic == null){
            this.friends.add(f);
            res = true;
        }
        return res;
	}
	
    
    public Friend findByPhone(String phone){
        Friend res = null;
        int i = 0;
        while(i < this.friends.size() && res == null){
            if(friends.get(i).getPhone().equalsIgnoreCase(phone)){
                res = friends.get(i);
            }
            i++;
        }
        return res;
    }
	
}

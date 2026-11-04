package model;

public class Tryme {
	public static void main(String[] args){
		Friend joe = new Friend("Joe", "34543234", "dafsafas", 1124, "asfasfaf");
		Friend jose = new Friend("Jose", "12362136", "dafsafas", 2345, "asfasfaf");
		
		FriendContainer container = new FriendContainer();
		
		container.addFriend(jose);
		container.addFriend(joe);
		
		
		for(Friend f : container.getFriends()) {
			f.describe();
		}
				
	}
}

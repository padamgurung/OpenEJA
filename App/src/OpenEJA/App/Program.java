package OpenEJA.App;

import OpenEJA.BO.User;



public class Program {

	public static void main(String[] args) {

			
		//BO and ORM Testing
		
		User user = new User("User");
		user.id = 34;	
		user.load();
		System.out.println(user.email + ";" + user.name + ";" + user.mobileNumber + ";" + user.id);
		
		System.out.println("ORM Testing Done!!");
		
		
	}

}

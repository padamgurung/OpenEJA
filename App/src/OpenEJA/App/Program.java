package OpenEJA.App;

import OpenEJA.BO.User;



public class Program {

	public static void main(String[] args) {

			
		//BO and ORM Testing
		
		User user = new User("User");
		user.id = 37;
		user.email = "padamg.urung@outlook.com";
		user.name = "padam gurung";
		user.mobileNumber = "9851126422";	
		//user.add();
		//user.update();
		user.remove();
		
		
		System.out.println("ORM Testing Done!!");
		
		
	}

}

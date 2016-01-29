package OpenEJA.App;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import OpenEJA.BO.User;
import OpenEJA.DAL.DBAdapter;
import OpenEJA.DAL.DBFactoryAdapter;


public class Program {

	public static void main(String[] args) {

		//DAL Testing	
		DBAdapter dbAdapter = DBFactoryAdapter.getDBAdapter();	
		HashMap<String, String> newData = new HashMap<String, String>();
		newData.put("name", "Padam Raj Gurung");
		newData.put("email", "padam.gurung@outlook.com");
		newData.put("mobile_number", "9851126422");
		dbAdapter.insert("user", newData);
		HashMap<String, String> modifiedData = new HashMap<String, String>();
		modifiedData.put("name", "Mr. Padam Raj Gurung");
		HashMap<String, String> whereCondition = new HashMap<String, String>();
		whereCondition.put("mobile_number", "9851126422");
		dbAdapter.update("user", modifiedData, whereCondition);
		HashMap<String, String> whereDeleteCondition = new HashMap<String, String>();
		whereDeleteCondition.put("id", "3");
		dbAdapter.delete("user", whereDeleteCondition);
		
		List<String> columns = new ArrayList<String>();
	
		ResultSet myRs = dbAdapter.retrieve("user", whereCondition, columns, "id ASC", 0, 5);
		try {
			while (myRs.next()) {
				System.out.println(myRs.getString("id") + ", " + myRs.getString("name") + ", "
						+ myRs.getString("email") + ", " + myRs.getString("mobile_number"));
			System.out.println("Main Application Testing Done!!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//BO and ORM Testing
		
		User user = new User("User");
		user.setEmail("padam.gurung@outlook.com");
		user.setName("Padam Raj Gurung");
		user.setMobileNumber("9851126422");		
		user.add();
		
		
		System.out.println("ORM Testing Done!!");
		
		
	}

}

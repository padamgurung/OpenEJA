package OpenEJA.DAL;

import OpenEJA.DAL.MySQLAdapter;

public class DBFactoryAdapter {
	
	private static String adapterType;
	private static DBAdapter dba;
	
	private static String connectionString = "jdbc:mysql://localhost:3306/javadb";
	private static String username = "javadb";
	private static String password = "Password123";
	
	public static void setAdapterType()
	{
		adapterType = MySQLAdapter.class.getName();
	}
	public static DBAdapter getDBAdapter(){
		
		DBFactoryAdapter.setAdapterType(); // later replace this function with value from resources config properties or xml
			
		if(!(dba instanceof DBAdapter)){
			try {
				dba = (DBAdapter)Class.forName(adapterType).newInstance();	
				dba.connect(connectionString, username, password);
				return dba;
			} catch (Throwable ex) {
				System.err.println(ex);
			}			
		}
		
		return null;
	}
}

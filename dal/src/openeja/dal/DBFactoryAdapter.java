package openeja.dal;

import openeja.dal.MySQLAdapter;

public class DBFactoryAdapter {

	private static String adapterType;
	private static DBAdapter dba = null;

	private static String connectionString = "jdbc:mysql://localhost:3306/javadb";
	private static String username = "javadb";
	private static String password = "Password123";

	public static void setAdapterType() {
		adapterType = MySQLAdapter.class.getName();
	}

	public static DBAdapter getDBAdapter() {

		DBFactoryAdapter.setAdapterType(); // later replace this function with
											// value from resources config
											// properties or xml

		if (dba == null) {
			try {
				dba = (DBAdapter) Class.forName(adapterType).newInstance();
			} catch (Throwable e) {
				System.err.println("DBFactoryAdapter Instantiation Failed");
			}
			dba.connect(connectionString, username, password);
		}
		return dba;

	}
}

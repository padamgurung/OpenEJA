package openeja.utils;

public class Convert {
	
	public static String toUpperCamelCase(String s) {
		String[] parts = s.split("_");
		String camelCaseString = "";
		for (String part : parts) {
			camelCaseString = camelCaseString + part.substring(0, 1).toUpperCase() + part.substring(1).toLowerCase();
		}
		return camelCaseString;
	}

	public static String toLowerCamelCase(String s) {
		String[] parts = s.split("_");
		String camelCaseString = "";
		for (String part : parts) {
			camelCaseString = camelCaseString + part.substring(0, 1).toUpperCase() + part.substring(1).toLowerCase();
		}
		return camelCaseString.substring(0, 1).toLowerCase() + camelCaseString.substring(1);
	}

	

}

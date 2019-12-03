package Util;

public class Utilities {
	public static boolean isInteger(String s) {
	    try { 
	        Integer.parseInt(s); 
	    }
	    catch(Exception e) { 
	        return false; 
	    }
	    return true;
	}
	
	public static boolean isDouble(String s) {
		try {
			Double.parseDouble(s);
		}
	    catch(Exception e) { 
	        return false; 
	    }
		return true;
	}
}

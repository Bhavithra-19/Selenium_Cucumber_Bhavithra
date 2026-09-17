package utils;

import java.util.Date;

public class ComonUtils {
	public static String getEmailWithTimestamp() {
		//Date date= new Date();
		//return "bhavi"+date.toGMTString().replace(" ","_").replace(":","_")+"@gmail.com";
		//public static String getEmailWithTimestamp() {
		    return "bhavi"+ System.currentTimeMillis()+ "@gmail.com";
		}

	}




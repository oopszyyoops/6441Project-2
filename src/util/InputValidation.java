package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidation {
	public static boolean isNumeric(String str){
		String regEx = "^[1-9]\\d*$";
		Pattern pat = Pattern.compile(regEx);
		Matcher mat = pat.matcher(str);
		if (mat.find()) {
			return true;
		}
		else {
			return false;
		}
	}
	public static boolean isDate(String str){
		String regEx = "(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})\\/(((0[13578]|1[02])\\/(0[1-9]|[12][0-9]|3[01]))|"+
				"((0[469]|11)\\/(0[1-9]|[12][0-9]|30))|(02\\/(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|"+
				"((0[48]|[2468][048]|[3579][26])00))\\/02\\/29)$";
		Pattern pat = Pattern.compile(regEx);
		Matcher mat = pat.matcher(str);
		if (mat.find()) {
			return true;
		}
		else {
			return false;
		}
	}
	public static boolean isEmail(String str){
		String regEx = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
		Pattern pat = Pattern.compile(regEx);
		Matcher mat = pat.matcher(str);
		if (mat.find()) {
			return true;
		}
		else {
			return false;
		}
	}
	public static boolean isString(String str){
		String regEx = "[a-zA-Z]+";
		Pattern pat = Pattern.compile(regEx);
		Matcher mat = pat.matcher(str);
		if (mat.matches()) {
			return true;
		}
		else {
			return false;
		}
	}

	public static boolean isDecimalNumeric (String str){
		String regEx = "^(\\+)?\\d+(\\.\\d+)?$";
		Pattern pat = Pattern.compile(regEx);
		Matcher mat = pat.matcher(str);
		if (mat.matches()) {
			return true;
		}
		else {
			return false;
		}
	}


}



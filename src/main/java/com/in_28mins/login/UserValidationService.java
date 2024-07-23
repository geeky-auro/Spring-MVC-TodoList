package com.in_28mins.login;

public class UserValidationService {
	public static boolean checkCredentials(String uname, String pwd) {
		if("Auro".equals(uname) && "auro".equals(pwd)) {
			return true;
		}
		return false;
	}
}

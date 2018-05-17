package org.study.login;

public class LoginService {

	public boolean isUserValid(String user, String password) {
		if (user.equals("java") && password.equals("spring")) {
			return true;
		}
		
		return false;
	}
}

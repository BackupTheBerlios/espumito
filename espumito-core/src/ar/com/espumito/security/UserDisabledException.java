package ar.com.espumito.security;

public class UserDisabledException extends AuthenticationException {

	public UserDisabledException(String user) {
		super("User " + user + " is disabled");
	}
	
}

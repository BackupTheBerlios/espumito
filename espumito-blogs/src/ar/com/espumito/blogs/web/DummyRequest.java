package ar.com.espumito.blogs.web;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

public class DummyRequest extends BlogSpecificRequest {

	public DummyRequest(HttpServletRequest request) {
		super(request);
	}

	public Principal getUserPrincipal() {
		return new Principal() 
		{

			public String getName() {
				return "guybrush";
			}
			
		};
		
	}

}

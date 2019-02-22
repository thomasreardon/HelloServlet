package controllers;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import models.ErsUser;
import services.LoginService;


public class LoginController implements Controller {

	//static Map<Long, ErsUser> userSessions = new HashMap<>();
	static ErsUser user = new ErsUser();
	public void handleGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
	}

	public void handlePost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		// String newSalt = BCrypt.gensalt();
		 //System.out.println(newSalt);
		
		user = new ErsUser();
	
		ObjectMapper om = new ObjectMapper();
		user = om.readValue(request.getReader(), ErsUser.class);
		LoginService login = new LoginService();
		System.out.println(user.getUsername());
		login.getSalt(user, user.getUsername());
		login.signIn(user, user.getUsername(), user.getPassword());
		//Long randomLong = (long)(Math.random() * Long.MAX_VALUE);
		//userSessions.put(randomLong, user);
		//String token = randomLong.toString();
	//	om.writeValue(response.getWriter(), token);
		om.writeValue(response.getWriter(), user);
}
}

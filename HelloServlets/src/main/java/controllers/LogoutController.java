package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutController implements Controller {
	
	@Override
	public void handlePost(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().invalidate(); //clear the session of the current user
		response.setStatus(204); //no content
		return;
	}

	@Override
	public void handleGet(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}
}

package controllers;


import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.ErsReimbursement;
import services.LoginService;
import services.ReimbursementService;

public class AddReimbursement implements Controller{
    
	public void handleGet(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("get actor");
	}

	public void handlePost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("get actor");
		ObjectMapper om = new ObjectMapper();
		ReimbursementService addReimb = new ReimbursementService();
		ErsReimbursement reimb = om.readValue(request.getReader(), ErsReimbursement.class);
		addReimb.addReimbursement(reimb);
		
	}

}

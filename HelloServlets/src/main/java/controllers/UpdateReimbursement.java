package controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import models.ErsReimbursement;
import services.ReimbursementService;

public class UpdateReimbursement implements Controller {
	public void handleGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("get update");

	}

	public void handlePost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("get actor");
		ObjectMapper om = new ObjectMapper();
		ReimbursementService updateReimb = new ReimbursementService();
		ErsReimbursement reimb = om.readValue(request.getReader(), ErsReimbursement.class);
		updateReimb.updateReimbursement(reimb);
		
	}
}

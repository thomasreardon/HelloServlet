package controllers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import models.ErsReimbursement;
import services.ReimbursementService;

public class AllReimbursements implements Controller {
	public void handleGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<ErsReimbursement> rList = new ArrayList<>();
		ReimbursementService viewRiemb = new ReimbursementService();
		viewRiemb.allReimbursements(rList);
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		ObjectMapper om = new ObjectMapper();
		om.writeValue(output, rList);
		byte[] reimbByte = output.toByteArray();
		System.out.println(new String(reimbByte));
		Writer w = response.getWriter();
		w.write(new String(reimbByte));
	}

	public void handlePost(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("post actor");
	}
}

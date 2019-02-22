package controllers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import models.ErsReimbursement;
import models.ErsUser;
import services.ReimbursementService;

public class ViewReimbursements extends LoginController implements Controller {
	
	public void handleGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
	}

	@Override
	public void handlePost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
	//	ErsUser user = new ErsUser();
		System.out.println(user.getId());
		ObjectMapper om = new ObjectMapper();
		//user = om.readValue(request.getInputStream(), ErsUser.class);
		List<ErsReimbursement> rList = new ArrayList<>();
		ReimbursementService viewRiemb = new ReimbursementService();
		viewRiemb.getReimbursements(rList, user.getId());
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		System.out.println(user.getUsername());
		om.writeValue(output, rList);
		byte[] reimbByte = output.toByteArray();
		System.out.println(new String(reimbByte));
		Writer w = response.getWriter();
		w.write(new String(reimbByte));
		
	}

}

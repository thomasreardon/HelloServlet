package com.revature.servlets;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllers.AcceptedReimbursements;
import controllers.AddReimbursement;
import controllers.AllReimbursements;
import controllers.Controller;
import controllers.DeniedReimbursements;
import controllers.LoginController;
import controllers.PendingReimbursements;
import controllers.UpdateReimbursement;
import controllers.ViewReimbursements;
import enums.Delegate;

public class DispatcherServlet extends HttpServlet {
	
	Map<Delegate, Controller> controllerRegistry = new HashMap<>();
	
	public void init() {
		Controller addReimbController = new AddReimbursement();
		Controller loginController = new LoginController();
		Controller updateReimbController = new UpdateReimbursement();
		Controller viewAllReimbController = new ViewReimbursements();
		Controller deniedReimbController = new DeniedReimbursements();
		Controller acceptedReimbController = new AcceptedReimbursements();
		Controller pendingReimbController = new PendingReimbursements();
		Controller allReimbController = new AllReimbursements();
		
		controllerRegistry.put(Delegate.LOGIN, loginController);
		controllerRegistry.put(Delegate.ADDREIMBURSEMENT, addReimbController);
		controllerRegistry.put(Delegate.UPDATEREIMBURSEMENT, updateReimbController);
		controllerRegistry.put(Delegate.VIEWREIMBURSEMENT, viewAllReimbController);
		controllerRegistry.put(Delegate.DENIEDREIMBURSEMENT, deniedReimbController);
		controllerRegistry.put(Delegate.ACCEPTEDREIMBURSEMENT, acceptedReimbController);
		controllerRegistry.put(Delegate.PENDINGREIMBURSEMENT, pendingReimbController);
		controllerRegistry.put(Delegate.ALLREIMBURSEMENT, allReimbController);
	}

	public Controller getController(HttpServletRequest request) {
		// parsing string to get resource part
		String uri = request.getRequestURI();
		String[] strings = uri.split("/");
		String resource = null;
		
		if(strings.length > 1) {
			// get resource if available
			
			resource = strings[2];
			//System.out.println(resource);
		}
		
		// Get an enumerated value from the enum
		Delegate delegate = Delegate.getDelegate(resource);
		
		//return null;
		return controllerRegistry.get(delegate);
	}
	
	
	public void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.addHeader("Access-Control-Allow-Origin", "http://localhost:4200");
		response.addHeader("Access-Control-Allow-Headers", "content-type");
		Controller controller = getController(request);
		if (controller == null) {
			response.sendError(404);
			return;
		}
		request.setAttribute("controller", controller);
		super.service(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Controller controller = (Controller) request.getAttribute("controller");
		controller.handleGet(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Controller controller = (Controller) request.getAttribute("controller");
		controller.handlePost(request, response);
	}
	
}

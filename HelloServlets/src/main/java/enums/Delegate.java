package enums;

import controllers.AcceptedReimbursements;
import controllers.AddReimbursement;
import controllers.Controller;
import controllers.DeniedReimbursements;
import controllers.LoginController;
import controllers.ViewReimbursements;
import controllers.UpdateReimbursement;
import controllers.PendingReimbursements;
import controllers.AllReimbursements;

public enum Delegate {
	LOGIN(new LoginController()),
	ADDREIMBURSEMENT(new AddReimbursement()),
	VIEWREIMBURSEMENT(new ViewReimbursements()),
	UPDATEREIMBURSEMENT(new UpdateReimbursement()),
	ACCEPTEDREIMBURSEMENT(new AcceptedReimbursements()),
	DENIEDREIMBURSEMENT(new DeniedReimbursements()),
	PENDINGREIMBURSEMENT(new PendingReimbursements()),
	ALLREIMBURSEMENT(new AllReimbursements()),
	NOT_FOUND(null);
	
	public Controller controller;
	
	private Delegate(Controller controller) {
			this.controller = controller;
		}
	
	public static Delegate getDelegate(String str) {
		if (str == null) return NOT_FOUND;
		
		// compare str to each delegate
		// return that delegate if the string
		// matches
		//String upper = str.toUpperCase();
		for(Delegate delegate : Delegate.values()) {
			if(str.toUpperCase().equals(delegate.name())) {
				return delegate;
			}
		}
		return NOT_FOUND;
	}
}

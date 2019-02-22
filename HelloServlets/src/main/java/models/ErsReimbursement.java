package models;

import java.sql.Date;
import java.sql.Timestamp;

public class ErsReimbursement {

	double erAmount;
	String erDescription;
	String erReceipt;
	private Timestamp erSubmitted;
	private Timestamp erResolved;
	private int reimbStatusId;
	private int reimbTypeId;
	private int authorId;
	private int resolverId;
	public int getResolverId() {
		return resolverId;
	}
	public void setResolverId(int resolverId) {
		this.resolverId = resolverId;
	}
	private int reimbId;
	
	public int getReimbId() {
		return reimbId;
	}
	public void setReimbId(int reimbId) {
		this.reimbId = reimbId;
	}
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public ErsReimbursement() {
		
	}
	public ErsReimbursement(double erAmount, Timestamp erSubmitted, Timestamp erResolved, String erDescription, int reimbStatusId, int reimbTypeId, int reimbId, int resolverId, int authorId) {
		
		this.erAmount = erAmount;
		this.erSubmitted = erSubmitted;
		this.erResolved = erResolved;
		this.erDescription = erDescription;
		//this.erReceipt = erReceipt;
		this.erSubmitted = erSubmitted;
		this.erSubmitted = erSubmitted;
		this.reimbStatusId = reimbStatusId;
		this.reimbTypeId = reimbTypeId;
		this.reimbId = reimbId;
		this.resolverId = resolverId;
		this.authorId = authorId;
	} 
	
	public int getReimbStatusId() {
		return reimbStatusId;
	}
	public void setReimbStatusId(int reimbStatusId) {
		this.reimbStatusId = reimbStatusId;
	}
	public int getReimbTypeId() {
		return reimbTypeId;
	}
	public void setReimbTypeId(int reimbTypeId) {
		this.reimbTypeId = reimbTypeId;
	}
	public double getErAmount() {
		return erAmount;
	}
	public void setErAmount(double erAmount) {
		this.erAmount = erAmount;
	}
	public Timestamp getErSubmitted() {
		return erSubmitted;
	}
	public void setErSubmitted(Timestamp erSubmitted) {
		this.erSubmitted = erSubmitted;
	}
	public Timestamp getErResolved() {
		return erResolved;
	}
	public void setErResolved(Timestamp erResolved) {
		this.erResolved = erResolved;
	}
	public String getErDescription() {
		return erDescription;
	}
	public void setErDescription(String erDescription) {
		this.erDescription = erDescription;
	}
	public String getErReceipt() {
		return erReceipt;
	}
	public void setErReceipt(String erReceipt) {
		this.erReceipt = erReceipt;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(erAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((erDescription == null) ? 0 : erDescription.hashCode());
		result = prime * result + ((erReceipt == null) ? 0 : erReceipt.hashCode());
		result = prime * result + ((erResolved == null) ? 0 : erResolved.hashCode());
		result = prime * result + ((erSubmitted == null) ? 0 : erSubmitted.hashCode());
		result = prime * result + reimbStatusId;
		result = prime * result + reimbTypeId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ErsReimbursement other = (ErsReimbursement) obj;
		if (Double.doubleToLongBits(erAmount) != Double.doubleToLongBits(other.erAmount))
			return false;
		if (erDescription == null) {
			if (other.erDescription != null)
				return false;
		} else if (!erDescription.equals(other.erDescription))
			return false;
		if (erReceipt == null) {
			if (other.erReceipt != null)
				return false;
		} else if (!erReceipt.equals(other.erReceipt))
			return false;
		if (erResolved == null) {
			if (other.erResolved != null)
				return false;
		} else if (!erResolved.equals(other.erResolved))
			return false;
		if (erSubmitted == null) {
			if (other.erSubmitted != null)
				return false;
		} else if (!erSubmitted.equals(other.erSubmitted))
			return false;
		if (reimbStatusId != other.reimbStatusId)
			return false;
		if (reimbTypeId != other.reimbTypeId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ErsReimbursement [erAmount=" + erAmount + ", erDescription=" + erDescription + ", erReceipt="
				+ erReceipt + ", erSubmitted=" + erSubmitted + ", erResolved=" + erResolved + ", reimbStatusId="
				+ reimbStatusId + ", reimbTypeId=" + reimbTypeId + "]";
	}
	

}


package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import models.ErsReimbursement;
import models.ErsUser;

public class ReimbursementService {

	private double reimbAmount;
	private Timestamp reimbSubmitted;
	private Timestamp reimbResolved;
	private String reimbDescription;
	private int reimbAuthor;
	private int resolverId;
	private int reimbStatusId;
	private int reimbTypeId;
	private int reimbId;
	
	public void updateReimbursement(ErsReimbursement reimb) {
		 PostgreConnection conn = new PostgreConnection();
		 Date date = new Date();
	     long time = date.getTime();
	     Timestamp ts = new Timestamp(time);
	     
		  try {
			  conn.dbConnection();
	    		PreparedStatement pstmt = conn.connection.prepareStatement("UPDATE ers_reimbursement SET reimb_resolved = ?, reimb_resolver_id = ?, reimb_status_id=? WHERE reimb_id = ?");
	            pstmt.setTimestamp(1, ts);
	            pstmt.setInt(2, reimb.getResolverId());
	            pstmt.setInt(3, reimb.getReimbStatusId());
	            pstmt.setInt(4, reimb.getReimbId());
	            System.out.println(reimb.getReimbId());
	    		pstmt.executeUpdate();
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
		  	catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	        
	}
	
	public void filterReimbursements(List<ErsReimbursement> rList, int id) {
		 PostgreConnection conn = new PostgreConnection();
		  try {
			  conn.dbConnection();
	    		PreparedStatement pstmt = conn.connection.prepareStatement("SELECT * FROM ers_reimbursement WHERE reimb_status_id =?");
	    		pstmt.setInt(1, id);
	            ResultSet rs = pstmt.executeQuery();
	            while(rs.next()) {
	            	reimbAmount = rs.getInt("reimb_amount");
	            	//System.out.println(reimbAmount);
	            	reimbSubmitted = rs.getTimestamp("reimb_submitted");
	            	//System.out.println(reimbSubmitted);
	            	reimbResolved = rs.getTimestamp("reimb_resolved");
	            	//System.out.println(reimbResolved);
	            	reimbDescription = rs.getString("reimb_description");
	            	//System.out.println(reimbDescription);
	            	//reimbReceipt = rs.getByte("");
	            	reimbStatusId = rs.getInt("reimb_status_id");
	            	//System.out.println(reimbStatusId);
	            	reimbTypeId = rs.getInt("reimb_type_id");
	            	reimbId = rs.getInt("reimb_id");
	            	resolverId = rs.getInt("reimb_resolver_id");
	            	reimbAuthor = rs.getInt("reimb_author_id");
	            	//System.out.println(reimbTypeId);
	            	ErsReimbursement reimb = new ErsReimbursement(reimbAmount, reimbSubmitted, reimbResolved, reimbDescription, reimbStatusId, reimbTypeId, reimbId, resolverId, reimbAuthor);
	            	rList.add(reimb);
	            	
	            	            	
	            }
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
		  	catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	}
	
	public void allReimbursements(List<ErsReimbursement> rList) {
		 PostgreConnection conn = new PostgreConnection();
		  try {
			  conn.dbConnection();
	    		PreparedStatement pstmt = conn.connection.prepareStatement("SELECT * FROM ers_reimbursement");
	            ResultSet rs = pstmt.executeQuery();
	            while(rs.next()) {
	            	reimbAmount = rs.getInt("reimb_amount");
	            	//System.out.println(reimbAmount);
	            	reimbSubmitted = rs.getTimestamp("reimb_submitted");
	            	//System.out.println(reimbSubmitted);
	            	reimbResolved = rs.getTimestamp("reimb_resolved");
	            	//System.out.println(reimbResolved);
	            	reimbDescription = rs.getString("reimb_description");
	            	//System.out.println(reimbDescription);
	            	//reimbReceipt = rs.getByte("");
	            	reimbStatusId = rs.getInt("reimb_status_id");
	            	//System.out.println(reimbStatusId);
	            	reimbTypeId = rs.getInt("reimb_type_id");
	            	reimbId = rs.getInt("reimb_id");
	            	//System.out.println(reimbTypeId);
	            	resolverId = rs.getInt("reimb_resolver_id");
	            	reimbAuthor = rs.getInt("reimb_author_id");
	            	ErsReimbursement reimb = new ErsReimbursement(reimbAmount, reimbSubmitted, reimbResolved, reimbDescription, reimbStatusId, reimbTypeId, reimbId, resolverId, reimbAuthor);
	            	rList.add(reimb);
	            	
	            	            	
	            }
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
		  	catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	}
	
	public void addReimbursement(ErsReimbursement reimb) {
		 PostgreConnection conn = new PostgreConnection();
		 
		 Date date = new Date();
	     long time = date.getTime();
	     Timestamp ts = new Timestamp(time);
	
		  try {
			  conn.dbConnection();
	    		PreparedStatement pstmt = conn.connection.prepareStatement("INSERT INTO ers_reimbursement(reimb_amount, reimb_submitted, reimb_description, reimb_author_id, reimb_status_id, reimb_type_id) VALUES (?,?,?,?,?,?)");
	            
	    		  pstmt.setDouble(1, reimb.getErAmount());
	              pstmt.setTimestamp(2, ts);
	              pstmt.setString(3, reimb.getErDescription());
	              pstmt.setInt(4, reimb.getAuthorId());
	              pstmt.setInt(5, 0);
	              pstmt.setInt(6, reimb.getReimbTypeId());
	              
	    		pstmt.executeUpdate();
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
		  	catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	        
	}
	
	public void getReimbursements(List<ErsReimbursement> rList, int id) {
		 PostgreConnection conn = new PostgreConnection();
		  try {
			  conn.dbConnection();
	    		PreparedStatement pstmt = conn.connection.prepareStatement("SELECT * FROM ers_reimbursement WHERE reimb_author_id=?");
	    		pstmt.setInt(1, id);
	            ResultSet rs = pstmt.executeQuery();
	            while(rs.next()) {
	            	reimbAmount = rs.getInt("reimb_amount");
	            	//System.out.println(reimbAmount);
	            	reimbSubmitted = rs.getTimestamp("reimb_submitted");
	            	//System.out.println(reimbSubmitted);
	            	reimbResolved = rs.getTimestamp("reimb_resolved");
	            	//System.out.println(reimbResolved);
	            	reimbDescription = rs.getString("reimb_description");
	            	//System.out.println(reimbDescription);
	            	//reimbReceipt = rs.getByte("");
	            	reimbStatusId = rs.getInt("reimb_status_id");
	            	//System.out.println(reimbStatusId);
	            	reimbTypeId = rs.getInt("reimb_type_id");
	            	reimbId = rs.getInt("reimb_id");
	            	resolverId = rs.getInt("reimb_resolver_id");
	            	reimbAuthor = rs.getInt("reimb_author_id");
	            	//System.out.println(reimbTypeId);
	            	ErsReimbursement reimb = new ErsReimbursement(reimbAmount, reimbSubmitted, reimbResolved, reimbDescription, reimbStatusId, reimbTypeId, reimbId, resolverId, reimbAuthor);
	            	rList.add(reimb);
	            	
	            }
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
		  	catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	}
}
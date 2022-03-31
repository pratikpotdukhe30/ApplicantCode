package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sprint1db.entities.Applicant;
import com.sprint1db.exception.EntityNotFoundException;


import DAO.ConnectionManager;


public class ApplicantDAOImpl implements ApplicantDAO {
 private static Connection con = ConnectionManager.getConnection();
 	public ApplicantDAOImpl() {
		try {
			con.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public Applicant addApplicant(Applicant applicant) {
		// TODO Auto-generated method stub
		String sql = "insert into applicant values(?,?,?,?)";
		
		try(Connection con =  ConnectionManager.getConnection();
				PreparedStatement ps =  con.prepareStatement(sql);){
			
			ps.setLong(1, applicant.getId());
			ps.setString(2, applicant.getName());
			ps.setString(3, applicant.getPhoneNumber());
			ps.setString(4, applicant.getEmailId());
			
			int retVal =  ps.executeUpdate();
			if(retVal == 1) {
				return applicant;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Applicant updateApplicant(Applicant applicant) {
    String sql =  "update applicant set phone=? , email=? where id = ?";
    
    try(PreparedStatement ps= con.prepareStatement(sql);){
    	
    	 ps.setString(1, applicant.getPhoneNumber());
    	 ps.setString(2, applicant.getEmailId());
    	 ps.setLong(3, applicant.getId());
    	 int retVal = ps.executeUpdate();
    	 if(retVal == 1) {
    		 
    		 System.out.println("applicant phoneNumber and email updated");
    	 }
    } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}
	try {
		return listApplicantById(applicant.getId());
	} catch (EntityNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
	

	return null;	
		
	}

	@Override
	public Applicant deleteApplicant(long id) throws EntityNotFoundException {
		// TODO Auto-generated method stub
		String sql = "delete from applicant where id = ?";
		try(Connection con =  ConnectionManager.getConnection();
				PreparedStatement ps =  con.prepareStatement(sql);)
		{
			     ps.setLong(1, id);
		     
				int retVal = ps.executeUpdate(); 
		
		       if(retVal ==1 )System.out.println("deleted");
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return null;
	}

	@Override
	public Applicant listApplicantById(long id) throws EntityNotFoundException {
		String sql = "select * from applicant where id = ?";
		try(
				PreparedStatement ps =  con.prepareStatement(sql);){
			     ps.setLong(1, id);
		     
				ResultSet rs = ps.executeQuery(); 
		while(rs.next()) {
			long idd = rs.getLong(1);
			String  name = rs.getString(2);
			String phNum = rs.getString(3);
			String em = rs.getString(4);
			
			Applicant a =  new Applicant(idd,name,phNum,em);
		return a;
		}
		throw new EntityNotFoundException("no such applicant id");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Applicant> listAllApplicants() {
		// TODO Auto-generated method stub
		List <Applicant> list = new ArrayList<Applicant>();
		String sql = "select * from applicant";
		try(Connection con =  ConnectionManager.getConnection();
				Statement stat =  con.createStatement();
				ResultSet rs =  stat.executeQuery(sql);){
		
		while (rs.next()) {
				long id = rs.getLong(1);
				String name =  rs.getString(2);
				String phone = rs.getString(3);
				String email =  rs.getString(4);
				
				Applicant a = new Applicant(id, name, phone, email);
				list.add(a);
		}
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	return list;
	
	
	}

	}



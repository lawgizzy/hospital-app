package com.neptune.springhospitalsystem.service;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.neptune.springhospitalsystem.model.ShareModel;
public class RegisterPatientService {
private JdbcTemplate jdbcTemplate;
	@Autowired
	DataSource dataSource;
	
	@Autowired
	ShareModel shareModel;
	public boolean registerPatient(int adminId, String fname, String midName, String lName, String phoneOffice, 
			String phoneHome, String email, String username, String address){
		boolean result; String sql; int res;
		try{
			jdbcTemplate = new JdbcTemplate(dataSource);
			 sql = "SELECT count(*) FROM patient WHERE phone_office=? OR phone_home=? OR email=? OR username = ?";
			 res = jdbcTemplate.queryForObject(sql, new Object[]{phoneOffice,phoneHome,email,username}, Integer.class);
			if(res>0){
				shareModel.setShortMessage("User already exists.");
				result = false;
			}
			else{
				sql ="INSERT INTO patient(admin_id,fname,mid_name,lname,phone_office,phone_home,email,username,address)"
						+ "VALUES(?,?,?,?,?,?,?,?,?)";
				res = jdbcTemplate.update(sql, new Object[]{adminId,fname, midName, lName, phoneOffice, phoneHome,email,username,address});
				 if(res>0){
					 shareModel.setShortMessage("Registration Successful");
					result = true;
				 }
				 else{
					 shareModel.setShortMessage("Network error occurred.");
					 result = false;
				 }
				
			}	
		}
		catch(Exception e){
			result = false;
			shareModel.setShortMessage(e.toString());
		}
		
		return result;
	}
}

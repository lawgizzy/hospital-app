package com.neptune.springhospitalsystem.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.neptune.springhospitalsystem.model.ShareModel;

public class PostPaymentService {
private JdbcTemplate jdbcTemplate;

@Autowired
DataSource dataSource;

@Autowired 
ShareModel shareModel;
public boolean registerPayment(int adminId, String patientId, int amount, String description){
	boolean result; String sql;
	try{
		jdbcTemplate = new JdbcTemplate(dataSource);
		  sql = "SELECT * FROM patient WHERE patient_id=? || username=?";
		  List<ShareModel> list = jdbcTemplate.query(sql, new Object[]{patientId, patientId}, new Mapper());
		  if(!list.isEmpty()){
			sql = "INSERT INTO payment(admin_id,patient_id,amount,description) VALUES(?,?,?,?)"; 
			int resNum = jdbcTemplate.update(sql, new Object[]{adminId, shareModel.getPatientId(), amount, description});
			if(resNum>0){
				shareModel.setShortMessage("Registration Complete");
				result = true;
			}
			else{
				shareModel.setShortMessage("Network error occurred.");
				result = false;
			}
		  }
		  else{
			  shareModel.setShortMessage("User record does not exist.");
			  result = false;
		  }
	}
	catch(Exception e){
		shareModel.setShortMessage(e.toString());
		result = false;
	}
	
	return result;
}

//retrieve the patient id using spring Jdbc RowMapper interface
private class Mapper implements RowMapper<ShareModel>{

	@Override
	public ShareModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		shareModel.setPatientId(rs.getInt("patient_id"));
		return shareModel;
	}
	
}
}

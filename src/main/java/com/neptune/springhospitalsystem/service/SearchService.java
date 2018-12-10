package com.neptune.springhospitalsystem.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.neptune.springhospitalsystem.model.ShareModel;

public class SearchService {
	JdbcTemplate jdbcTemplate;
@Autowired
DataSource dataSource;

@Autowired
ShareModel shareModel;
	
	public boolean getSearchRecord(String criteria){
		boolean done;
		try{
		   jdbcTemplate = new JdbcTemplate(dataSource);	
		   String sql = "SELECT payment.payment_id, patient.patient_id, patient.fname, patient.lname,"
		   		+ " payment.amount FROM payment INNER JOIN patient ON payment.patient_id = patient.patient_id "
		   		+ "WHERE patient.fname LIKE ? OR patient.lname LIKE ? OR patient.phone_home LIKE ? OR "
		   		+ "patient.phone_office LIKE ?";
		   
		      List<ShareModel> searchList = jdbcTemplate.query(sql, new Object[]{"%"+criteria+"%", "%"+criteria+"%", "%"+criteria+"%", "%"+criteria+"%"}, new ResultMapper());
		   if(!searchList.isEmpty()){
			   shareModel.setPatientData(searchList);
			  done = true;
		   }
		   else{
			   done = false;
			   shareModel.setShortMessage("No record found.");
		   }
		}catch(Exception e){
			done = false;
			shareModel.setShortMessage(e.toString());		
		}
		
		
		return done;
	}
	
	private class ResultMapper implements RowMapper<ShareModel>{
     int serial = 0;
		@Override
		public ShareModel mapRow(ResultSet rs, int rowNum) throws SQLException {
			ShareModel searchModel = new ShareModel();
			searchModel.setSerial(++serial);
			searchModel.setPaymentId(rs.getInt("payment_id"));
			searchModel.setPatientId(rs.getInt("patient_id"));
			searchModel.setPatientFname(rs.getString("fname"));
			searchModel.setPatientLname(rs.getString("lname"));
			searchModel.setAmountPaid(rs.getInt("amount"));
			return searchModel;
		}
		
	}
}

package com.neptune.springhospitalsystem.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.neptune.springhospitalsystem.model.ShareModel;

public class SingleReportService {
   JdbcTemplate jdbcTemplate;
   @Autowired
   ShareModel shareModel;
   
	@Autowired 
	DataSource dataSource;
	public boolean getSingleReport(int regId){
		boolean result;
		try{
			jdbcTemplate = new JdbcTemplate(dataSource);
			String sql = "SELECT * FROM payment INNER JOIN patient ON payment.patient_id = patient.patient_id WHERE payment.payment_id=?";
			List<ShareModel> singleList = jdbcTemplate.query(sql, new Object[]{regId}, new ResultMapper());
			if(!singleList.isEmpty()){
				result = true;
				shareModel.setPatientData(singleList);
			}
			else{
				result = false;
				shareModel.setShortMessage("No record found");
			}
		}
		catch(Exception e){
			result = false;
			shareModel.setShortMessage(e.toString());
		}
	
		return result;
	}
	
	private class ResultMapper implements RowMapper<ShareModel>{
		@Override
		public ShareModel mapRow(ResultSet rs, int rowNum) throws SQLException {
			ShareModel resultModel = new ShareModel();
		     resultModel.setPatientId(rs.getInt("patient_id"));
		     resultModel.setPatientFname(rs.getString("fname"));
		     resultModel.setPatientMidName(rs.getString("mid_name"));
		     resultModel.setPatientLname(rs.getString("lname"));
		     resultModel.setPatientEmail(rs.getString("email"));
		     resultModel.setPatientFullName(rs.getString("fname"),rs.getString("mid_name"),rs.getString("lname"));
		     resultModel.setPatientPhoneOffice(rs.getString("phone_office"));
		     resultModel.setPatientPhoneHome(rs.getString("phone_home"));
		     resultModel.setPatientAddress(rs.getString("address"));
		     resultModel.setPaymentDate(rs.getString("date_reg"));
		     resultModel.setAmountPaid(rs.getInt("amount"));
		     resultModel.setPaymentDescription(rs.getString("description"));
		     return resultModel;
		   
		}
		
	}
}

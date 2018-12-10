package com.neptune.springhospitalsystem.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.neptune.springhospitalsystem.model.ShareModel;

public class ReportService {
private JdbcTemplate jdbcTemplate;
private String sql;
	@Autowired
	DataSource dataSource;
	
	@Autowired
	ShareModel shareModel;
	public boolean getPatientDetails(){
		boolean result;
		try{
			jdbcTemplate = new JdbcTemplate(dataSource);
		sql = "SELECT payment.payment_id, patient.patient_id, patient.fname, patient.lname, payment.amount FROM payment INNER JOIN patient ON payment.patient_id = patient.patient_id";	
		List<ShareModel> list = jdbcTemplate.query(sql,new Mapper());
		if(!list.isEmpty()){
			shareModel.setPatientData(list);
			result = true;
		}
		else{
			result = false;
			shareModel.setShortMessage("No record(s) found.");
		}
		}
		catch(Exception e){
			result = false;
			shareModel.setShortMessage(e.toString());
		}
		
		return result;
	}
	private class Mapper implements RowMapper<ShareModel>{
		int serial = 0;
		@Override
		public ShareModel mapRow(ResultSet rs, int rowNum) throws SQLException {
			ShareModel reportModel = new ShareModel();
			reportModel.setSerial(++serial);
			reportModel.setPaymentId(rs.getInt("payment_id"));
			reportModel.setPatientId(rs.getInt("patient_id"));
			reportModel.setPatientFname(rs.getString("fname"));
			reportModel.setPatientLname(rs.getString("lname"));
		    reportModel.setAmountPaid(rs.getInt("amount"));
			return reportModel;	
		}
		
	}
}

package com.neptune.springhospitalsystem.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.neptune.springhospitalsystem.controllers.HomeController;
import com.neptune.springhospitalsystem.model.ShareModel;

public class LoginService {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	 private JdbcTemplate jdbcTemplate;
	@Autowired
	DataSource dataSource;
	
	@Autowired
	ShareModel shareModel;
	
	//process the request login credentials
	public boolean processLogin(String loginId, String password){
		boolean result;
				try{
					 jdbcTemplate = new JdbcTemplate(dataSource);
					String sql = "Select * from admin where (email=? AND password=?) OR (username=? AND password=?)";
					List<ShareModel> list = jdbcTemplate.query(sql, new Object[]{loginId,password,loginId,password}, new Mapper());
					if(!list.isEmpty()){
						result = true;
					}
					else{
						shareModel.setShortMessage("Invalid login details");
						result = false;
					}
					
				}
				catch(Exception e){
					shareModel.setShortMessage(e.toString());
					result = false;
				}  

		return result;
	}
	
	private class Mapper implements RowMapper<ShareModel>{
		@Override
		public ShareModel mapRow(ResultSet rs, int rowNum) throws SQLException {
			shareModel.setAdminId(rs.getInt("admin_id"));
			shareModel.setFirstName(rs.getString("fname"));
			return shareModel;
		}
			
	}
}
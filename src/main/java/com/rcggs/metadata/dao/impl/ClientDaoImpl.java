package com.rcggs.metadata.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.rcggs.metadata.dao.IClientDao;
import com.rcggs.metadata.model.Client;
import com.rcggs.metadata.util.ApplicationConstants;

public class ClientDaoImpl implements IClientDao {

	
	JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Client> getAllClients() {
		// TODO Auto-generated method stub
		try {
			  List<Client> list = jdbcTemplate.query(ApplicationConstants.GET_ALL_CLIENT_DETAILS,
					new Object[] {}, new RowMapper<Client>() {

						@Override
						public Client mapRow(ResultSet rs, int size) throws SQLException {
							Client client = new Client();
							client.setClientId((rs.getInt("Client_Id") != 0) ? rs.getInt("Client_Id") : 0);
							client.setClientNumber(
									(rs.getString("client_number") != null) ? rs.getString("client_number") : "");
							client.setClientName(
									(rs.getString("client_name") != null) ? rs.getString("client_name") : "");
							client.setClientDesc(
									(rs.getString("client_desc") != null) ? rs.getString("client_desc") : "");
							client.setActiveFlag((rs.getInt("Active_Flag") != 0) ? rs.getInt("Active_Flag") : 0);
							return client;
						}
					});
			
		} catch (Exception e) {
			 e.printStackTrace();
		}
		return null;
	}

	@Override
	public  List<Client> getClientDetails(String clientNumber) {
		// TODO Auto-generated method stub
		try {
			String sql = "";
			Object params[] = null;
			if(clientNumber != null && !clientNumber.equalsIgnoreCase("")){
				sql = ApplicationConstants.GET_CLIENT_DETAILS_BY_ID;
				params = new Object[] {clientNumber};
			}else{
				sql = ApplicationConstants.GET_ALL_CLIENT_DETAILS;
				params = new Object[]{};
			}

			  List<Client> list = jdbcTemplate.query(sql,
					  params, new RowMapper<Client>() {

						@Override
						public Client mapRow(ResultSet rs, int size) throws SQLException {
							Client client = new Client();
							client.setClientId((rs.getInt("Client_Id") != 0) ? rs.getInt("Client_Id") : 0);
							client.setClientNumber(
									(rs.getString("client_number") != null) ? rs.getString("client_number") : "");
							client.setClientName(
									(rs.getString("client_name") != null) ? rs.getString("client_name") : "");
							client.setClientDesc(
									(rs.getString("client_desc") != null) ? rs.getString("client_desc") : "");
							client.setActiveFlag((rs.getInt("Active_Flag") != 0) ? rs.getInt("Active_Flag") : 0);
							return client;
						}
					});				
			if (list != null && !list.isEmpty())
				return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public int addClient(Client client) {
		// TODO Auto-generated method stub
		int status = 0;
		try{
			String sql = ApplicationConstants.ADD_CLIENT_DETAILS_BY_ID;
			List<Integer> maxRow = jdbcTemplate.query("select max(client_id) as maxValue from Meta_Client",
					               new RowMapper<Integer>(){

				@Override
				public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
					return (rs.getInt("maxValue") != 0) ? rs.getInt("maxValue") : 0;
				}
			});
			if(maxRow != null && !maxRow.isEmpty()){
			 status = jdbcTemplate.update(sql, new Object[]{maxRow.get(0) + 1,
					 client.getClientNumber(), client.getClientName(), client.getClientDesc(),
					 client.getActiveFlag()});
			}
			} catch (Exception e) {
			      e.printStackTrace();
		  }
		return status;
	}

	@Override
	public void updateClient(Client client) {
		// TODO Auto-generated method stub
		try{
			jdbcTemplate.update(ApplicationConstants.UPDATE_CLIENT_DETAILS_BY_ID,
					new Object[] {client.getClientNumber(), client.getClientName(), client.getClientDesc(),
							 client.getActiveFlag(),client.getClientId()} );
			
		} catch (Exception e) {
			e.printStackTrace();
		  }
	}

	@Override
	public void deleteClient(String clientNumber) {
		// TODO Auto-generated method stub
		try{
				jdbcTemplate.update(ApplicationConstants.DELETE_CLIENT_DETAILS_BY_ID,new Object[]{clientNumber});				
		} catch (Exception e) {
				e.printStackTrace();
	     }
	}

}

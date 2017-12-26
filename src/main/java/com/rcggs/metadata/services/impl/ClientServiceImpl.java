package com.rcggs.metadata.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.rcggs.metadata.dao.IClientDao;
import com.rcggs.metadata.model.Client;
import com.rcggs.metadata.services.ClientService;

public class ClientServiceImpl implements ClientService{
	
	private IClientDao iclientDao;

	public IClientDao getIclientDao() {
		return iclientDao;
	}
	@Autowired
	public void setIclientDao(IClientDao iclientDao) {
		this.iclientDao = iclientDao;
	}

	@Override
	public List<Client> getAllClients() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Client> getClientById(String clientNumber) {
		// TODO Auto-generated method stub
		return iclientDao.getClientDetails(clientNumber);
	}
	
	@Override
	public int addClient(Client client) {
		// TODO Auto-generated method stub
		return iclientDao.addClient(client);
	}

	@Override
	public void updateClient(Client client) {
		// TODO Auto-generated method stub
		iclientDao.updateClient(client);
	}

	@Override
	public void deleteClient(String clientNumber) {
		// TODO Auto-generated method stub
		iclientDao.deleteClient(clientNumber);
	}

}

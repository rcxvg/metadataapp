package com.rcggs.metadata.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.rcggs.metadata.model.Client;

@Component
public interface ClientService {

	List<Client> getAllClients();

	public List<Client> getClientById(String clientNumber);
	
	public int addClient(Client client);

	void updateClient(Client client);

	void deleteClient(String clientNumber);

}

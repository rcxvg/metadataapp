package com.rcggs.metadata.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.rcggs.metadata.model.Client;

@Component
public interface IClientDao {
	
    public int addClient(Client client);
    
    List<Client> getAllClients();
    
    public List<Client> getClientDetails(String clientNumber);
    
    void updateClient(Client client);
    
    void deleteClient(String clientNumber);

}

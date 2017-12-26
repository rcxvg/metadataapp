package com.rcggs.metadata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rcggs.metadata.model.Client;
import com.rcggs.metadata.services.ClientService;

@RestController
public class ClientController {

	private ClientService clientService;

	public ClientService getClientService() {
		return clientService;
	}

	@Autowired
	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}

	@RequestMapping(value = "/clientDetails", method = RequestMethod.GET)
	public ResponseEntity<List<Client>> getClientDetails() {
		return new ResponseEntity<List<Client>>(clientService.getClientById(""), HttpStatus.OK);
	}
		
	@RequestMapping(value = "/clientDetails/{clientNumber}", method = RequestMethod.GET)
	public ResponseEntity<List<Client>> getClientDetail(@PathVariable("clientNumber") String clientNumber ) {
		return new ResponseEntity<List<Client>>(clientService.getClientById(clientNumber), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/clientDetails/", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<Integer> createUser(@RequestBody Client client) {
		 List clientlist =  clientService.getClientById(client.getClientNumber());
	       if (clientlist != null && clientlist.size() > 0 ) {
	            System.out.println("A Client with name " + client.getClientName() + " already exist");
	            return new ResponseEntity<Integer>(0,HttpStatus.CONFLICT);
	        }
		  int status = clientService.addClient(client);
	  
	       /* HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/clientDetails/{clientNumber}").buildAndExpand(client.getClientId()).toUri());*/
	        return new ResponseEntity<Integer>(status, HttpStatus.OK);
	    }
	
	@RequestMapping(value="/clientDetails/update", method = RequestMethod.POST )
	public ResponseEntity<Client> updateClient(@RequestBody Client client) {
		clientService.updateClient(client);
		return new ResponseEntity<Client>(client, HttpStatus.OK);
	}
	
	@RequestMapping(value= "/clientDetails/delete/{clientNumber}", method = RequestMethod.GET )
	public ResponseEntity<Void> deleteClient(@PathVariable("clientNumber") String clientNumber) {
		clientService.deleteClient(clientNumber);
		return new ResponseEntity<Void>(HttpStatus.OK);
	} 
	
	
}

package com.challenge.springboot.controller;

import com.challenge.springboot.exception.ResourceNotFoundException;
import com.challenge.springboot.model.Client;
import com.challenge.springboot.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = { "http://localhost:3000", "https://viacep.com.br"})
@RestController
@RequestMapping("/api/v1/")
public class ClientController {

	@Autowired
	private ClientRepository clientRepository;
	
	
	//get all Clients

	@GetMapping("/clients")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public List<Client> getAllClients(){
		return clientRepository.findAll();
	}
	
	//Create client
	@PostMapping("/clients")
	public Client newClient(@RequestBody Client client) {
		return clientRepository.save(client);
	}
	
	
	@GetMapping("/clients/{id}")
	public ResponseEntity<Client> getClientById(@PathVariable Long id) {
		 Client client =  clientRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não existe usuário com esse id"));
		 
		 return ResponseEntity.ok(client);
	}

	@PutMapping("/clients/{id}")
	public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client clientDetails){
		Client client =  clientRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não existe usuário com esse id"));

		client.setName(clientDetails.getName());
		client.setCpf(clientDetails.getCpf());
		client.setEmail(clientDetails.getEmail());
		client.setEmail2(clientDetails.getEmail2());
		client.setPhone(clientDetails.getPhone());
		client.setPhone2(clientDetails.getPhone2());
		client.setZipcode(clientDetails.getZipcode());
		client.setAddress(clientDetails.getAddress());
		client.setComplement(clientDetails.getComplement());
		client.setNumber(clientDetails.getNumber());
		client.setDistrict(clientDetails.getDistrict());
		client.setCity(clientDetails.getCity());
		client.setState(clientDetails.getState());

		Client updatedClient = clientRepository.save(client);
		return ResponseEntity.ok(updatedClient);
	}


	@DeleteMapping("/clients/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteClient(@PathVariable Long id){
		Client client =  clientRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não existe usuário com esse id"));
		clientRepository.delete(client);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}

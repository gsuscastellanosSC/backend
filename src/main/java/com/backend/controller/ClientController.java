package com.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.model.Client;
import com.backend.service.ClientService;
import com.backend.util.Constant;

@RestController
@CrossOrigin(origins = { Constant.ASTERISK })
@RequestMapping(Constant.SLASH_API)
public class ClientController {

	@Autowired
	private ClientService clientService;

	@PostMapping(Constant.SLASH_CLIENTS)
	public Client save(@RequestBody Client cliet) {
		return clientService.save(cliet);
	}

	@GetMapping(Constant.SLASH_CLIENTS)
	public List<Client> findAll() {
		return clientService.findAll();
	}

	@GetMapping(Constant.SLASH_CLIENTS_SLASH_BRACKET_ID_BRACKET)
	public Client findById(@PathVariable Integer id) {
		return clientService.findById(id);
	}

	@PutMapping(Constant.SLASH_CLIENTS_SLASH_BRACKET_ID_BRACKET)
	public Client update(@RequestBody Client client, @PathVariable Integer id) {

		Client clientUpdated = clientService.findById(id);

		clientUpdated.setDocument(client.getDocument());

		clientUpdated.setName(client.getName());

		return clientService.save(clientUpdated);
	}

	@DeleteMapping(Constant.SLASH_CLIENTS_SLASH_BRACKET_ID_BRACKET)
	public void delete(@PathVariable Integer id) {
		clientService.delete(id);
	}

}

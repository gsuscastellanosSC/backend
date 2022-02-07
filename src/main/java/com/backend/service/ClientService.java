package com.backend.service;

import java.util.List;

import com.backend.model.Client;

public interface ClientService {

	public Client save(Client client);

	public void delete(Integer id);

	public Client findById(Integer id);

	public List<Client> findAll();
}

package com.backend.poll.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.poll.dao.ClientDAO;
import com.backend.poll.model.Client;
import com.backend.poll.service.ClientService;
import com.backend.poll.util.Constant;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientDAO clientDAO;

	@Override
	@Transactional(readOnly = Constant.FALSE)
	public Client save(Client client) {
		return clientDAO.save(client);
	}

	@Override
	@Transactional(readOnly = Constant.FALSE)
	public void delete(Integer id) {
		clientDAO.deleteById(id);
	}

	@Override
	@Transactional(readOnly = Constant.FALSE)
	public Client findById(Integer id) {
		return clientDAO.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = Constant.FALSE)
	public List<Client> findAll() {
		return (List<Client>) clientDAO.findAll();
	}

}

package com.example.youbookingbackend.service;

import com.example.youbookingbackend.entity.Client;
import com.example.youbookingbackend.entity.User;

import java.util.List;

public interface ClientService {

    Client addClient(Client client);
    Client updateClient(Client client);
    Client DesactiveClient(Long id);
    Client getClient(Long id);
    List<Client> findAllClients();

}

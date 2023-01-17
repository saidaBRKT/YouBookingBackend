package com.example.youbookingbackend.service.Imp;

import com.example.youbookingbackend.entity.Client;
import com.example.youbookingbackend.entity.Status;
import com.example.youbookingbackend.entity.User;
import com.example.youbookingbackend.repository.ClientRespository;
import com.example.youbookingbackend.repository.UserRespository;
import com.example.youbookingbackend.service.ClientService;
import com.example.youbookingbackend.service.UserService;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ClientServiceImp implements ClientService {
    @Autowired
    private ClientRespository clientRespository;

    @Override
    public Client addClient(Client client) {
        if(client == null || client == new User()){
            throw new IllegalStateException("Tout les données sont obligatoire");
        }else if (clientRespository.getClientByEmail(client.getEmail())!=null) {
            throw new IllegalStateException("Le client existe deja");
        }else{
            return clientRespository.save(client);
        }
    }

    @Override
    public Client updateClient(Client client) {
        Client clientToUpdate=clientRespository.findById(client.getId()).get();
        if(clientToUpdate == null)
            throw new IllegalStateException("Tout les données sont obligatoire");
        else{
            clientToUpdate=client;
            return clientRespository.save(clientToUpdate);
        }
    }

    @Override
    public Client DesactiveClient(Long id) {
        Client client=clientRespository.findById(id).get();
        if(client!=null)
            throw new IllegalStateException("Le client n'existe pas");
        else{
            client.setStatus(Status.Desactive);
            return client;
        }
    }

    @Override
    public Client getClient(Long id) {
        Client client=clientRespository.findById(id).get();
        if(client == null)
            throw new IllegalStateException("le client n'existe pas");
        else{
            return client;
        }
    }

    @Override
    public List<Client> findAllClients() {
        return clientRespository.findAll();
    }
}

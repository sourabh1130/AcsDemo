package com.Advatix.LoginApi.service.ClientService;

import com.Advatix.LoginApi.dao.ClientDao.CityRepo;
import com.Advatix.LoginApi.dao.ClientDao.ClientRepo;
import com.Advatix.LoginApi.dao.ClientDao.StateRepo;
import com.Advatix.LoginApi.entity.Client.ClientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepo clientRepo;

    @Autowired
    private CityRepo cityRepo;

    @Autowired
    private StateRepo stateRepo;



    public List<ClientEntity> findAllClient(){
        return clientRepo.findAll();
    }
    public Optional<ClientEntity>findAllByClientId(Long clientId){
        return clientRepo.findAllByClientId(clientId);
    }

    public ClientEntity createClient(ClientEntity clientEntity){
        ClientEntity client= new ClientEntity();
        client.setClientName(client.getClientName());
        client.setClientId(clientEntity.getClientId());
        client.setClientPhno(clientEntity.getClientPhno());
        client.setClientMail(clientEntity.getClientMail());
        client.setAddress1(clientEntity.getAddress1());
        client.setCity(clientEntity.getCity());
        client.setState(clientEntity.getState());
        client.setCountry(clientEntity.getCountry());
        client.setCityId(clientEntity.getCityId());
        ClientEntity savedClient = clientRepo.save(client);
        return savedClient;
    }

}

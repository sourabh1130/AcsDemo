package com.Advatix.LoginApi.service.ClientService;

import com.Advatix.LoginApi.dao.ClientDao.StateRepo;
import com.Advatix.LoginApi.entity.Client.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StateService {
    @Autowired
    private StateRepo stateRepo;

    public Optional<State> findByStateId(Long stateId){
        return stateRepo.findByStateId(stateId);
    }
}

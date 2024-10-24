package com.Advatix.LoginApi.service.ClientService;

import com.Advatix.LoginApi.dao.ClientDao.CityRepo;
import com.Advatix.LoginApi.entity.Client.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityService {
    @Autowired
    private CityRepo cityRepo;

    public Optional<City> findByCityId(Long cityId){
        return cityRepo.findByCityId(cityId);
    }
}

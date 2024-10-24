package com.Advatix.LoginApi.service.ClientService;

import com.Advatix.LoginApi.dao.ClientDao.CountryRepo;
import com.Advatix.LoginApi.entity.Client.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryService {
    @Autowired
    private CountryRepo countryRepo;

    public Optional<Country> findByCountryId(Long countryId){
        return countryRepo.findByCountryId(countryId);
    }
}

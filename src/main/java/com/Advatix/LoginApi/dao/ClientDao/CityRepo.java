package com.Advatix.LoginApi.dao.ClientDao;

import com.Advatix.LoginApi.entity.Client.City;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.security.authentication.jaas.JaasPasswordCallbackHandler;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityRepo extends JpaRepository<City, Long > {
    Optional<City> findByCityId(Long cityId);
}

package com.Advatix.LoginApi.dao.ClientDao;

import com.Advatix.LoginApi.entity.Client.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryRepo extends JpaRepository<Country, Long> {
    Optional<Country> findByCountryId(Long countryId);
}

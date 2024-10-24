package com.Advatix.LoginApi.dao.ClientDao;

import com.Advatix.LoginApi.entity.Client.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepo extends JpaRepository<ClientEntity, Long> {
    Optional<ClientEntity> findAllByClientId(Long clientId);


}

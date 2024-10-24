package com.Advatix.LoginApi.dao.ClientDao;

import com.Advatix.LoginApi.entity.Client.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StateRepo  extends JpaRepository<State, Long> {
    Optional<State> findByStateId(Long stateId);
}

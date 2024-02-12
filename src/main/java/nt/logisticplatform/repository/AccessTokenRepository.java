package nt.logisticplatform.repository;

import nt.logisticplatform.model.AccessToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessTokenRepository extends JpaRepository<AccessToken, Long> {
    AccessToken findByToken(String token);
}

package nt.logisticplatform.service;

import nt.logisticplatform.model.AccessToken;

public interface AccessTokenService {
    AccessToken findToken(String token);

    AccessToken createToken(Long userId);
}

package nt.logisticplatform.service;

import nt.logisticplatform.model.AuthDTO;
import nt.logisticplatform.model.AuthInfo;
import nt.logisticplatform.model.RegisterDTO;

public interface AuthService {
    AuthInfo register(RegisterDTO registerDTO);

    AuthInfo login(AuthDTO authDTO);
}

package nt.logisticplatform.controller.impl;

import nt.logisticplatform.controller.AuthController;
import nt.logisticplatform.model.AuthDTO;
import nt.logisticplatform.model.AuthInfo;
import nt.logisticplatform.model.RegisterDTO;
import nt.logisticplatform.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthControllerImpl implements AuthController {
    @Autowired
    private AuthService authService;

    @Override
    public AuthInfo register(RegisterDTO registerDTO) {
        return authService.register(registerDTO);
    }

    @Override
    public AuthInfo login(AuthDTO authDTO) {
        return authService.login(authDTO);
    }
}

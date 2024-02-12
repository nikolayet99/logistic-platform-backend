package nt.logisticplatform.service.impl;

import nt.logisticplatform.model.AccessToken;
import nt.logisticplatform.model.User;
import nt.logisticplatform.repository.AccessTokenRepository;
import nt.logisticplatform.service.AccessTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;

@Service
public class AccessTokenServiceImpl implements AccessTokenService {
    @Autowired
    AccessTokenRepository accessTokenRepository;

    @Override
    public AccessToken findToken(String token) {
        return accessTokenRepository.findByToken(token);
    }

    @Override
    public AccessToken createToken(Long userId) {
        AccessToken accessToken = new AccessToken(
                generateSHA256(LocalDateTime.now().toString() + Math.random()),
                LocalDateTime.now().plusHours(1),
                new User(userId));
        accessTokenRepository.save(accessToken);
        return accessToken;
    }

    private String generateSHA256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes());
            StringBuilder hexString = new StringBuilder();

            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return "Bearer " + hexString;
        } catch (NoSuchAlgorithmException ignored) {
            return "";
        }
    }
}

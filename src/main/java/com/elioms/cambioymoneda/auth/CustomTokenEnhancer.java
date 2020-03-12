package com.elioms.cambioymoneda.auth;

import com.elioms.cambioymoneda.services.UserServiceImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

public class CustomTokenEnhancer implements TokenEnhancer {

    private UserServiceImpl userService;

    public CustomTokenEnhancer(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {

        User user = (User) authentication.getPrincipal();
        final Map<String, Object> additionalInfo = new HashMap<>();

        com.elioms.cambioymoneda.models.entity.User authenticatedUser = userService.findByEmail(user.getUsername());

        Map<String, String> map = new HashMap<>();
        map.put("id", authenticatedUser.getId().toString());
        map.put("email", authenticatedUser.getEmail());
        map.put("name", authenticatedUser.getName());
        map.put("surname", authenticatedUser.getSurname());


        additionalInfo.put("info", map);
        additionalInfo.put("authorities", user.getAuthorities());

        ((DefaultOAuth2AccessToken) accessToken)
                .setAdditionalInformation(additionalInfo);

        return accessToken;
    }
}
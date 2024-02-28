package com.wishlist.config;

import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.JWTParser;
import com.wishlist.exception.WishlistException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.server.resource.web.BearerTokenResolver;
import org.springframework.security.oauth2.server.resource.web.DefaultBearerTokenResolver;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class AuthenticationInterceptor {

    private final HttpServletRequest httpServletRequest;

    public String retrieveUsername() {
        BearerTokenResolver bearerTokenResolver = new DefaultBearerTokenResolver();
        String token = bearerTokenResolver.resolve(httpServletRequest);
        try {
            JWT jwt = JWTParser.parse(token);
            Date expirationTime = jwt.getJWTClaimsSet().getExpirationTime();
            if (isTokenExpired(expirationTime)) return (String) jwt.getJWTClaimsSet().getClaim("sub");
            throw new WishlistException("Bearer Token is expired at :" + expirationTime);
        } catch (ParseException e) {
            throw new WishlistException("Bearer Token is invalid " + e.getMessage());
        }
    }

    private boolean isTokenExpired(Date expirationTime) {
        return new Date().before(expirationTime);
    }

}

package com.teletext.ecommerce.shared.authentication.infrastructure.primary;


import com.teletext.ecommerce.shared.authentication.application.AuthenticatedUser;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class KindeJwtAuthenticationConverter implements Converter<Jwt, AbstractAuthenticationToken> {

    @Override
    public AbstractAuthenticationToken convert(@NonNull Jwt jwtSource) {
        return new JwtAuthenticationToken(jwtSource,
                Stream.concat(new JwtGrantedAuthoritiesConverter().convert(jwtSource).stream(),
                        extractResourceRole(jwtSource).stream()).collect(Collectors.toSet()));
    }

    private Collection<? extends GrantedAuthority> extractResourceRole(Jwt jwt) {
        return AuthenticatedUser.extractRolesFromToken(jwt).stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toSet());
    }

}

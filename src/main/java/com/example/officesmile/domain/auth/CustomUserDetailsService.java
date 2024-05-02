package com.example.officesmile.domain.auth;

import com.example.officesmile.domain.entity.auth.AuthEntity;
import com.example.officesmile.mapper.auth.AuthMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final AuthMapper authMapper;

    @Override
    public UserDetails loadUserByUsername(String authId) throws UsernameNotFoundException {
        return Optional.ofNullable(authMapper.findByAuthId(authId))
                .map(
                    auth ->
//                            new CustomUserDetails(
//                                auth.getAuthId(),
//                                auth.getPassword(),
//                                toGrantedAuthority(auth.getAuthority())
//                            )
                            CustomUserDetails
                                    .withUsername(auth.getAuthId())
                                    .password("{noop}" + auth.getPassword())
                                    .authorities(auth.getAuthority().name())
                                    .build()
                    ).orElseThrow(() -> new IllegalArgumentException("ユーザーがいない")
                );
    }

    private List<GrantedAuthority> toGrantedAuthority(AuthEntity.Authority authority) {
        return Collections.singletonList(new SimpleGrantedAuthority(authority.name()));
    }

    public class CustomUserDetails extends User {

        public CustomUserDetails(String authId, String password, Collection<? extends GrantedAuthority> authorities) {
            super(authId, password, authorities);
        }
    }
}

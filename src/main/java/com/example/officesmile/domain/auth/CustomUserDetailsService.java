package com.example.officesmile.domain.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final AuthRepository authRepository;

    @Override
    public UserDetails loadUserByUsername(String authId) throws UsernameNotFoundException {
        return authRepository.findByAuthId(authId)
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

    private List<GrantedAuthority> toGrantedAuthority(Auth.Authority authority) {
        return Collections.singletonList(new SimpleGrantedAuthority(authority.name()));
    }
}

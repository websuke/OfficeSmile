package com.example.officesmile.domain.auth;

import com.example.officesmile.Repository.dao.AuthDao;
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
    private final AuthDao authDao;

    @Override
    public UserDetails loadUserByUsername(String authId) throws UsernameNotFoundException {

        return Optional.ofNullable(authDao.userSearchByAuthId(Long.parseLong(authId)))
                .map(
                        user ->
                            new CustomUserDetails(
                                user.authId(),
                                user.password(),
                                toGrantedAuthority(user.authority()),
                                user.userId(),
                                user.userName(),
                                user.roleName()
                            )
                    ).orElseThrow(() -> new UsernameNotFoundException("ログインIDが誤っています。")
                );
    }

    private List<GrantedAuthority> toGrantedAuthority(String authority) {
        return Collections.singletonList(new SimpleGrantedAuthority(authority));
    }

    public class CustomUserDetails extends User {

        private final String userId;
        private final String userName;
        private final String roleName;


        public CustomUserDetails(String authId,
                                 String password,
                                 Collection<? extends GrantedAuthority> authorities,
                                 String userId,
                                 String userName,
                                 String roleName
        ) {
            super(authId, password, authorities);
            this.userId = userId;
            this.userName = userName;
            this.roleName = roleName;
        }
    }
}

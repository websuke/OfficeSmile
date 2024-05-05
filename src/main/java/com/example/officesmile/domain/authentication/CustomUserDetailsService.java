package com.example.officesmile.domain.authentication;

import com.example.officesmile.infrastructure.dao.AuthDao;
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

    /**
     * ログイン処理時にSpringSecurityによって実行されるメソッド
     *
     * 当該メソッドで取得したUserを基にログインの可否が判定される。
     *
     * @param authId
     * @return
     * @throws UsernameNotFoundException
     */
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

    /**
     * 権限型変換
     *
     * @param authority
     * @return
     */
    private List<GrantedAuthority> toGrantedAuthority(String authority) {
        return Collections.singletonList(new SimpleGrantedAuthority(authority));
    }

    /**
     * 自作UserDetailsクラス
     *
     * UserDetailsを実現しているUserを継承しているためカスタムした情報を持たせたうえでUserDetailsとして使用可能となる。
     */
    public class CustomUserDetails extends User {

        private final String userId;
        private final String userName;

        /**
         * 役職名
         *
         * 練習のため追加したが現在未使用。
         */
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

        public String getUserId() {
            return userId;
        }

        /**
         * ユーザー名取得
         *
         * 本メソッドはバックエンドでは使ってないがThymeleaf側で使用しているため削除する際は注意
         *
         * @return
         */
        public String getUserName() {
            return userName;
        }

        public String getRoleName() {
            return roleName;
        }
    }
}

package com.example.officesmile.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final CustomSuccessHandler successHandler;

    /**
     * セキュリティ設定
     *
     * @param http
     * @return
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .formLogin((form) -> form                                             // フォーム認証設定を開始する
                        .loginPage("/login")                                          // ログインページ表示のためのハンドラーメソッドは GET /login
                        .successHandler(successHandler)                               // ログイン後のハンドラーメソッドは強制的に GET /
                        .usernameParameter("authId")                                  // username -> authId に変更
                        .permitAll()                                                  // 認証無しでアクセス可能
                )
                .logout((logout) -> logout
                        .logoutUrl("/logout")                                         // ログアウト処理のURLはPOST /logout
                        .logoutSuccessUrl("/login?logout")                            // ログアウト後のURLは /login?logout
                        .permitAll())                                                 // 認証無しでアクセス可能
                .authorizeHttpRequests((requests) -> requests                         // URL毎の認可設定を開始する
                        .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).hasAuthority("SUPER_USER") // "/h2-console**" へはスーパーユーザー権限のみがアクセス可能
                        .requestMatchers("css/**").permitAll()               // CSSへの認証も不要
                        .requestMatchers("js/**").permitAll()                // JSへの認証も不要
                        .requestMatchers("users/**").hasAnyAuthority("ADMIN", "SUPER_USER") // ユーザー関連の操作は管理者権限以上のみが可能
                        .requestMatchers("returning-to-works").hasAuthority("GENERAL") // 帰社登録は一般ユーザーのみ可能
                        .requestMatchers("going-homes/**").hasAuthority("GENERAL") // 帰宅登録は一般ユーザーのみ可能
                        .anyRequest().authenticated()                                 // その他のURLへはログイン後アクセス可能
                )
                .csrf(csrf -> csrf.ignoringRequestMatchers(
                        AntPathRequestMatcher.antMatcher("/h2-console/**")    // H2コンソールではCSRFを利用しない
                ))
                .headers(header -> header.frameOptions(
                        frame -> frame.sameOrigin()                                   // 自サイトからであればframeの読み込み可能
                ));


        return http.build();
    }

    /**
     * 使用するパスワード暗号化技術をBean登録
     *
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return SCryptPasswordEncoder.defaultsForSpringSecurity_v5_8();
    }
}


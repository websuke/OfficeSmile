package com.example.officesmile.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .formLogin((form) -> form                                             // フォーム認証設定を開始する
                        .loginPage("/login")                                          // ログインページ表示のためのハンドラーメソッドは GET /login
                        .defaultSuccessUrl("/")                                       // ログイン後のハンドラーメソッドは GET /
                        .permitAll()                                                  // 認証無しでアクセス可能
                )
                .logout((logout) -> logout.permitAll())                               // ログアウト処理のPOST /logout は認証無しでアクセス可能
                .authorizeHttpRequests((requests) -> requests                         // URL毎の認可設定を開始する
                        .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll() // "/h2-console**" へはログインなしでもアクセス可能 ※開発環境のみとする必要あり
                        .requestMatchers("css/**").permitAll()               // CSSへの認証も不要
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
}


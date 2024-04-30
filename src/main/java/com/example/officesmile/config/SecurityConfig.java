package com.example.officesmile.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .logout((logout) -> logout.permitAll())                      // ログアウト処理のPOST /logout は認証無しでアクセス可能
                .formLogin((form) -> form                                    // フォーム認証設定を開始する
//                        .loginPage("/login")                               // SpringSecurityが用意しているデフォルトのログインページを使用するためコメントアウト
                        .permitAll()                                         // 認証無しでアクセス可能
                )
                .authorizeHttpRequests((requests) -> requests                // URL毎の認可設定を開始する
                        .requestMatchers("/").permitAll()                    // "/" へはログインなしでもアクセス可能
                        .requestMatchers("/returning-to-works").permitAll()  // "/returning-to-works" へはログインなしでもアクセス可能
                        .anyRequest().authenticated()                        // その他のURLへはログイン後アクセス可能
                );


        return http.build();
    }
}


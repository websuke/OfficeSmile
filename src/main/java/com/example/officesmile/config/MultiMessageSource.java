package com.example.officesmile.config;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Locale;

/**
 * 多言語メッセージソースクラス
 */
@Configuration
public class MultiMessageSource extends ResourceBundleMessageSource {

    @Autowired
    HttpServletRequest request;

    /**
     * MultiMessageSourceをBean登録
     *
     * 初期設定を実施した後にBean登録を実施する。
     *
     * @return
     */
    @Bean
    public MultiMessageSource messageSource() {
        MultiMessageSource messageSource = new MultiMessageSource();
        messageSource.setBasenames("messages");
        messageSource.setDefaultEncoding(StandardCharsets.UTF_8.name());

        return messageSource;
    }

    /**
     * メッセージ取得
     *
     * @param key
     * @param params
     * @return
     */
    public String getMessage(String key, Object... params) {

        AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
        localeResolver.setDefaultLocale(Locale.JAPANESE);
        localeResolver.setSupportedLocales(List.of(Locale.JAPANESE, Locale.ENGLISH));

        return super.getMessage(key, params, localeResolver.resolveLocale(request));
    }
}

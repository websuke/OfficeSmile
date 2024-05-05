package com.example.officesmile.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyCommandLineRunner implements CommandLineRunner {

    /**
     * tailwind.exec.sh 実行
     *
     * 本番環境では不要かもしれない。少なくとも開発時には当該クラスにより、
     * アプリケーション起動と同時にrunメソッドが実行されるため、新規クラスを利用した際に再生成されtailwindCSSが反映される。
     *
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        Runtime.getRuntime().exec("src/main/resources/scripts/tailwind.exec.sh");
    }
}

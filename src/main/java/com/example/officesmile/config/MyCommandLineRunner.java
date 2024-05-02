package com.example.officesmile.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyCommandLineRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        // シェルスクリプトを実行するコードをここに記述する
        Runtime.getRuntime().exec("src/main/resources/scripts/tailwind.exec.sh");
    }
}

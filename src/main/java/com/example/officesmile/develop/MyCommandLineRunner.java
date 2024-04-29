package com.example.officesmile.develop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyCommandLineRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        // シェルスクリプトを実行するコードをここに記述する
        Runtime.getRuntime().exec("/home/yt/idea/App/officesmile/tailwind.exec.sh");
    }
}

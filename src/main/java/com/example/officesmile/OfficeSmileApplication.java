package com.example.officesmile;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.officesmile.mapper.*")
public class OfficeSmileApplication {

	public static void main(String[] args) {
		SpringApplication.run(OfficeSmileApplication.class, args);
	}

}

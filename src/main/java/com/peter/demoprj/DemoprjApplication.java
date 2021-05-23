package com.peter.demoprj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value={"com.peter.demoprj.mapper"})
public class DemoprjApplication {

	public static void main(String[] args)
	{
		//System.setProperty("spring.profiles.default", "local");
		SpringApplication.run(DemoprjApplication.class, args);
	}

}

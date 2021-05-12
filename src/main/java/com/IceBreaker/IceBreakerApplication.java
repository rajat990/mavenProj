package com.IceBreaker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.IceBreaker.Config.FileStorageProperties;



@SpringBootApplication
@EnableConfigurationProperties({
	FileStorageProperties.class
})
public class IceBreakerApplication {

	public static void main(String[] args) {
		SpringApplication.run(IceBreakerApplication.class, args);
	}

}

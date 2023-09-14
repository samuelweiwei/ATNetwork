package com.atnetwork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


/**
 * Add DataSourceAutoConfiguration.class, or the start up may failed
 * @author weiwei
 *
 */
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class AtNetworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtNetworkApplication.class, args);
	}
}
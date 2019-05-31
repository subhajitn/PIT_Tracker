package com.tcs.PIT;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
/*@ComponentScan("com.tcs.PIT.repository,com.tcs.PIT.controller")
@EntityScan("com.tcs.PIT.model")*/

public class PitTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PitTrackerApplication.class, args);
	}

}

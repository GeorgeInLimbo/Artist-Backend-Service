package com.georgeclam.limbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/****************************************************************************
 * <b>Title</b>: LimboApplication.java
 * <b>Project</b>: Limbo Gallery - Backend
 * <b>Description: </b> Entry for the Limbo Gallery Backend Application.
 * <b>Copyright:</b> Copyright (c) 2023
 * <b>Company:</b> Silicon Mountain Technologies
 *
 * @author George Clam
 * @version 1.0
 * @since Apr 17, 2023
 * @updates:
 ****************************************************************************/

@SpringBootApplication
public class LimboApplication {

	/**
	 * Main method to run the backend application.
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(LimboApplication.class, args);
	}
}

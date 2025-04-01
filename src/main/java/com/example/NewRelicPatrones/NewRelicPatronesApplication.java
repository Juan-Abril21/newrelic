package com.example.NewRelicPatrones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NewRelicPatronesApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewRelicPatronesApplication.class, args);

		// Mantener la aplicación viva
		synchronized (NewRelicPatronesApplication.class) {
			try {
				NewRelicPatronesApplication.class.wait(); // La app no se cierra
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
	}
}

package com.mindhub.homebanking;

import com.mindhub.homebanking.models.Account;
import com.mindhub.homebanking.models.Client;
import com.mindhub.homebanking.repositories.AccountRepository;
import com.mindhub.homebanking.repositories.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class HomebankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomebankingApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(ClientRepository clientRepository, AccountRepository accountRepository){
		return (args -> {
			Client cliente1 = new Client("Melba", "Morel", "melba@mindhub.com");
			Client cliente2 = new Client("Marcelo", "Bruzzone", "bruzzone1804@gmail.com");
			clientRepository.save(cliente1);
			clientRepository.save(cliente2);

			Account cuenta1 = new Account("VIN001", LocalDate.now(), 5000.0);
			Account cuenta2 = new Account("VIN002", LocalDate.now().plusDays(1), 7500.0);

			cliente1.addAAccount(cuenta1);
			cliente2.addAAccount(cuenta2);

			accountRepository.save(cuenta1);
			accountRepository.save(cuenta2);
		});
	}

}

package com.mimaraslan;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mimaraslan.model.Address;
import com.mimaraslan.model.User;
import com.mimaraslan.repository.AddressRepository;
import com.mimaraslan.repository.UserRepository;

@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

	@Bean
	public CommandLineRunner mappingDemo(UserRepository userRepository, AddressRepository addressRepository) {
		return args -> {

			// create a user instance
			User user = new User("Katerina Lena", "katerina.lena@example.com", "1234abcd");

			// create an address instance
			Address address = new Address("Ulitsa Anna 321", "Ukraine", "Kiev", "95781", "UA");

			// set child reference
			address.setUser(user);

			// set parent reference
			user.setAddress(address);

			// save the parent
			// which will save the child (address) as well
			userRepository.save(user);
		};
	}
}
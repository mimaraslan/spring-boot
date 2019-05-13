package com.mimaraslan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mimaraslan.model.Person;

@SpringBootApplication
public class MainApplication implements CommandLineRunner {

	    @Autowired
	    @Qualifier("student")
	    Person p1;
	    
//	    @Autowired
//	    @Qualifier("manager")
//	    Person p2;    
	    
	    @Override
	    public void run(String... args) throws Exception {
	        System.out.println(p1.info());        
//	        System.out.println(p2.info());
	    }

		public static void main(String[] args) {
			SpringApplication.run(MainApplication.class, args);
		}

}
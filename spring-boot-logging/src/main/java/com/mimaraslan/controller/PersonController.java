package com.mimaraslan.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mimaraslan.model.Person;
import com.mimaraslan.service.PersonService;

@RestController
public class PersonController {

	private static final Logger logger = LoggerFactory.getLogger(PersonController.class);

	@Autowired
	private PersonService personService;

	@GetMapping("/person")
	public List<Person> getPersons() {

		String className = this.getClass().getSimpleName();
		logger.trace("A TRACE Message: " + className);
		logger.debug("A DEBUG Message: " + className);
		logger.info("An INFO Message: " + className);
		logger.warn("A WARN Message: " + className);
		logger.error("An ERROR Message: " + className);

		return personService.getPersons();
	}
}
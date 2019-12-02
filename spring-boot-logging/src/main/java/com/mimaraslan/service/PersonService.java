package com.mimaraslan.service;

import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.mimaraslan.model.Person;

@Service
public class PersonService {

	private static final Logger logger = LoggerFactory.getLogger(PersonService.class);

	public List<Person> getPersons() {

		String className = this.getClass().getSimpleName();
		logger.trace("A TRACE Message: " + className);
		logger.debug("A DEBUG Message: " + className);
		logger.info("An INFO Message: " + className);
		logger.warn("A WARN Message: " + className);
		logger.error("An ERROR Message: " + className);

		return Arrays.asList(new Person(1, "person1"), new Person(2, "person2"));
	}
}
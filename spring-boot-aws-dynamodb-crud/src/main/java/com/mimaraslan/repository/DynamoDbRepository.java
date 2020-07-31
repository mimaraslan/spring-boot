package com.mimaraslan.repository;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ComparisonOperator;
import com.amazonaws.services.dynamodbv2.model.ConditionalCheckFailedException;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.mimaraslan.model.Student;

@Repository
public class DynamoDbRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(DynamoDbRepository.class);

	@Autowired
	private DynamoDBMapper mapper;

	public Student insertIntoDynamoDB(Student student) {
		mapper.save(student);
		return mapper.load(Student.class, student.getStudentId());
	}

	public Student getOneStudentDetails(String studentId) {
		return mapper.load(Student.class, studentId);
	}
	
	public Student updateStudentDetails(Student student) {
		try {
			mapper.save(student, buildDynamoDBSaveExpression(student));
			return mapper.load(Student.class, student.getStudentId());
		} catch (ConditionalCheckFailedException exception) {
			LOGGER.error("invalid data - " + exception.getMessage());
			return null;
		}
	}

	public void deleteStudentDetails(Student student) {
		mapper.delete(student);
	}

	public DynamoDBSaveExpression buildDynamoDBSaveExpression(Student student) {
		DynamoDBSaveExpression saveExpression = new DynamoDBSaveExpression();
		Map<String, ExpectedAttributeValue> expected = new HashMap<>();
		expected.put("studentId", new ExpectedAttributeValue(new AttributeValue(student.getStudentId()))
				.withComparisonOperator(ComparisonOperator.EQ));
		saveExpression.setExpected(expected);
		return saveExpression;
	}
}
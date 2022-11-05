package com.mimaraslan;

import com.mimaraslan.model.Student;
import com.mimaraslan.model.Course;
import com.mimaraslan.repository.StudentRepository;
import com.mimaraslan.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.transaction.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class MainApplication implements CommandLineRunner {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseRepository courseRepository;

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }
    
    @Transactional
    @Override
    public void run(String... arg0) throws Exception {
       
    	Student student1 = new Student("Katerina");
        Student student2 = new Student("Lena");
        Student student3 = new Student("Anna");
        Student student4 = new Student("Dasha");
        Student student5 = new Student("Raya");

        Course course1 = new Course("Machine Learning");
        Course course2 = new Course("Database Systems");
        Course course3 = new Course("Java Technologies");

		/*
		courseRepository.save(course1);
		courseRepository.save(course2);
		*/

        Set<Course> courses = new HashSet<Course>();
        courses.add(course1);
        courses.add(course2);
        courses.add(course3);

        student1.setCourses(courses);
        student2.setCourses(courses);
        student3.setCourses(courses);
        student4.setCourses(courses);
        student5.setCourses(courses);

        studentRepository.save(student1);
        studentRepository.save(student2);
        studentRepository.save(student3);
        studentRepository.save(student4);
        studentRepository.save(student5);

        Set<Student> studentsGroup1 = new HashSet<Student>();
        studentsGroup1.add(student1);
        studentsGroup1.add(student2);
        
        Set<Student> studentsGroup2 = new HashSet<Student>();
        studentsGroup2.add(student3);
        studentsGroup2.add(student4);
        studentsGroup2.add(student5);

        course1.setStudents(studentsGroup1);
        course2.setStudents(studentsGroup1);
        course3.setStudents(studentsGroup2);

        courseRepository.save(course1);
        courseRepository.save(course2);
        courseRepository.save(course3);

        List<Student> studentLst = studentRepository.findAll();
        List<Course> subLst = courseRepository.findAll();

        System.out.println(studentLst.size());
        System.out.println(subLst.size());

        System.out.println("===================Students info:==================");
        studentLst.forEach(student->System.out.println(student.toString()));

        System.out.println("===================Students info:==================");
        subLst.forEach(course->System.out.println(course.toString()));
    }
    
    
    // TODO - I will do it
    /*
    @Bean
    public CommandLineRunner mappingDemo(StudentRepository studentRepository, CourseRepository courseRepository) {
        return args -> {

            // create a student
            Student student = new Student("Katerina", 15, "8th");

            // save the student
            studentRepository.save(student);

            // create three courses
            Course course1 = new Course("Machine Learning", "ML", 13, 900);
            Course course2 = new Course("Database Systems", "DS", 90, 600);
            Course course3 = new Course("Java Technologies", "JT", 11, 0);

            // save courses
            courseRepository.saveAll(Arrays.asList(course1, course2, course3));

            // add courses to the student
            student.getCourses().addAll(Arrays.asList(course1, course2, course3));

            // update the student
            studentRepository.save(student);
        };
    }
    */
    
    
}
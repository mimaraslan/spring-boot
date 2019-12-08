package com.mimaraslan;

import com.mimaraslan.model.Student;
import com.mimaraslan.model.Subject;
import com.mimaraslan.repository.StudentRepository;
import com.mimaraslan.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class MainApplication implements CommandLineRunner {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    SubjectRepository subjectRepository;

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Transactional
    @Override
    public void run(String... arg0) throws Exception {
        Student jack = new Student("Katerina");
        Student peter = new Student("Anya");

        Subject math = new Subject("Software");
        Subject computer = new Subject("Hardware");

		/*subjectRepository.save(math);
		subjectRepository.save(computer);*/

        Set<Subject> subjects = new HashSet<Subject>();
        subjects.add(math);
        subjects.add(computer);

        jack.setSubjects(subjects);
        peter.setSubjects(subjects);

        studentRepository.save(jack);
        studentRepository.save(peter);


        Set<Student> students = new HashSet<Student>();
        students.add(jack);
        students.add(peter);

        math.setStudents(students);
        computer.setStudents(students);

        subjectRepository.save(math);
        subjectRepository.save(computer);

        List<Student> studentLst = studentRepository.findAll();
        List<Subject> subLst = subjectRepository.findAll();

        System.out.println(studentLst.size());
        System.out.println(subLst.size());


        System.out.println("===================Students info:==================");
        studentLst.forEach(student->System.out.println(student.toString()));

        System.out.println("===================Students info:==================");
        subLst.forEach(subject->System.out.println(subject.toString()));
    }
}
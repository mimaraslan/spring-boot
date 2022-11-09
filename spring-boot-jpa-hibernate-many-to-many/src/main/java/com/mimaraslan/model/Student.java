package com.mimaraslan.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.json.JSONArray;
import org.json.JSONObject;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
    private int age;
    private String grade;
    
	@JsonIgnoreProperties("students") // for Hibernate N+1 Queries Problem
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "students_courses",
    		   joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
    		   inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"))
	private Set<Course> courses;
	
	public Student(){
	}
	
	public Student(String name){
		this.name = name;
	}
	
    public Student(String name, int age, String grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
	
	public Student(String name, Set<Course> courses){
		this.name = name;
		this.courses = courses;
	}
	
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
    
	public Set<Course> getCourses() {
		return courses;
	}
	
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	
	@Override
	public String toString(){
		String info = "";
		JSONObject jsonInfo = new JSONObject();
		jsonInfo.put("name",this.name);
		JSONArray subArray = new JSONArray();
		this.courses.forEach(sub->{
			JSONObject subJson = new JSONObject();
			subJson.put("title", sub.getTitle());
			subArray.put(subJson);
		});
		jsonInfo.put("courses", subArray);
		info = jsonInfo.toString();
		return info;
	}
}
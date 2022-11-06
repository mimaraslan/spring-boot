package com.mimaraslan.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.json.JSONArray;
import org.json.JSONObject;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "courses")
public class Course implements Serializable {

	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    private String title;
    private String abbreviation;
    private int modules;
    private double fee;
	
	@JsonIgnoreProperties("courses") // for Hibernate N+1 Queries Problem
	@ManyToMany(mappedBy = "courses", fetch = FetchType.LAZY)
	private Set<Student> students;
	
    public Course(){
    }
    
    public Course(String title){
    	this.title = title;
    }
    
    public Course(String title, String abbreviation, int modules, double fee) {
        this.title = title;
        this.abbreviation = abbreviation;
        this.modules = modules;
        this.fee = fee;
    }
    
    public Course(String title, Set<Student> students){
    	this.title = title;
    	this.students = students;
    }
	
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public int getModules() {
        return modules;
    }

    public void setModules(int modules) {
        this.modules = modules;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

	
	public Set<Student> getStudents() {
		return students;
	}
	
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	
	@Override
	public String toString(){
		String info = "";
		JSONObject jsonInfo = new JSONObject();
		jsonInfo.put("title",this.title);
		JSONArray studentArray = new JSONArray();
		if(this.students != null && students.size() > 0){
			this.students.forEach(student->{
				JSONObject subJson = new JSONObject();
				subJson.put("name", student.getName());
				studentArray.put(subJson);
			});
		}
		jsonInfo.put("students", studentArray);
		info = jsonInfo.toString();
		return info;
	}
}
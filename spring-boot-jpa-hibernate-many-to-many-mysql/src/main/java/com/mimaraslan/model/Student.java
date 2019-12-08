package com.mimaraslan.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Student {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;

	@JsonIgnoreProperties("students")
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "student_subject", joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "subject_id", referencedColumnName = "id"))
	private Set<Subject> subjects;
	
	public Student(){
	}
	
	public Student(String name){
		this.name = name;
	}

	public Student(String name, Set<Subject> subjects){
		this.name = name;
		this.subjects = subjects;
	}
	
	// name
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	// subjects
	public Set<Subject> getSubjects() {
		return subjects;
	}
	
	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}
	
	@Override
	public String toString(){
		String info = "";
		JSONObject jsonInfo = new JSONObject();
		jsonInfo.put("name",this.name);
		JSONArray subArray = new JSONArray();
		this.subjects.forEach(sub->{
			JSONObject subJson = new JSONObject();
			subJson.put("name", sub.getName());
			subArray.put(subJson);
		});
		jsonInfo.put("subjects", subArray);
		info = jsonInfo.toString();
		return info;
	}
}

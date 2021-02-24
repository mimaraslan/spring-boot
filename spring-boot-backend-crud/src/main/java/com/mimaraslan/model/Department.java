package com.mimaraslan.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

   // @ManyToOne(fetch = FetchType.LAZY)
   // @Column(name = "employee_id")
   // private Employee employee;

    @JsonIgnore
    @ManyToOne//(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @Size(min = 2, message = "Name should have at least 2 characters")
    @Column(name = "section_name")
    private String sectionName;

    @Column(name = "job")
    private String job;


    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", employee=" + employee +
                ", sectionName='" + sectionName + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}


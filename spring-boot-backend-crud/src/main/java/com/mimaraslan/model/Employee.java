package com.mimaraslan.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(min = 2, message = "Name should have at least 2 characters")
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email_id")
    private String emailId;

    @Past
    @Column(name = "birthday")
    private Date birthDay;

   // @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
   // private List<Department> departments;

    @JsonIgnoreProperties("employee") // for Hibernate N+1 Queries Problem
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Department> departments;

}
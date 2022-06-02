package com.mimaraslan.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String userName;
    String password;
}

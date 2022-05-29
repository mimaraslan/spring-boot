package com.mimaraslan.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table (name = "post")
@Data
public class Post {

    @Id
    Long Id;
    Long userId;
    String title;
    @Lob
    @Column(columnDefinition = "text")
    String text;
}

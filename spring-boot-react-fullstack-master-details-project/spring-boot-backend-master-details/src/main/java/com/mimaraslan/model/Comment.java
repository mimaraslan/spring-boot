package com.mimaraslan.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table (name = "comment")
@Data
public class Comment {

    @Id
    Long Id;
    Long postId;
    Long userId;
    @Lob
    @Column(columnDefinition = "text")
    String text;
}

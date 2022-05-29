package com.mimaraslan.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "p_like")
@Data
public class Like {
    @Id
    Long id;
    Long postId;
    Long userId;
}

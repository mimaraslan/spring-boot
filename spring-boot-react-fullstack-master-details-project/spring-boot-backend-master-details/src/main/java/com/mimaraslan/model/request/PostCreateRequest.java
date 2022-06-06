package com.mimaraslan.model.request;

import lombok.Data;

@Data
public class PostCreateRequest {

    Long id;
    String title;
    String text;
    Long userId;
}

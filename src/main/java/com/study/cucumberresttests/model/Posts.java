package com.study.cucumberresttests.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Posts {

    private int id;
    private String title;
    private String author;
}

package com.study.cucumberresttests.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class User {
    private List<Posts> posts;
    private List<Comments> comments;
    private Profile profile;
    private Address address;
}

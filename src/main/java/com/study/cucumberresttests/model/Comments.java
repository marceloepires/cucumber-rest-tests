package com.study.cucumberresttests.model;

import io.cucumber.messages.internal.com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Comments {
    private int id;
    private String body;
    @JsonProperty("postId")
    private int postid;
}

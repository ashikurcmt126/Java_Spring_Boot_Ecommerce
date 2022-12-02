package com.ashikur.spring.shoppingcartweb.forms;

import javax.validation.constraints.NotEmpty;

public class CommentForm {

    @NotEmpty
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

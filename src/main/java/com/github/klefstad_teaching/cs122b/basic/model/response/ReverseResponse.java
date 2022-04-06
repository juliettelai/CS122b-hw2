package com.github.klefstad_teaching.cs122b.basic.model.response;

import com.github.klefstad_teaching.cs122b.core.base.ResponseModel;

public class ReverseResponse extends ResponseModel<ReverseResponse>{
    private String message;

    public String getMessage() {
        return message;
    }

    public ReverseResponse setMessage(String message) {
        this.message = message;
        return this;
    }
}
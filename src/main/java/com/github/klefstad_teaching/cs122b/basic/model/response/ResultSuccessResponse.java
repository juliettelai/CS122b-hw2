package com.github.klefstad_teaching.cs122b.basic.model.response;

import com.github.klefstad_teaching.cs122b.core.base.ResponseModel;


public class ResultSuccessResponse extends ResponseModel<ResultSuccessResponse>
{
    private String greeting;

    public String getGreeting() {
        return greeting;
    }

    public ResultSuccessResponse setGreeting(String greeting) {
        this.greeting = greeting;
        return this;
    }
}
package com.github.klefstad_teaching.cs122b.basic.rest;

import com.github.klefstad_teaching.cs122b.basic.config.BasicServiceConfig;
import com.github.klefstad_teaching.cs122b.basic.model.response.ResultSuccessResponse;
import com.github.klefstad_teaching.cs122b.basic.model.response.ReverseResponse;
import com.github.klefstad_teaching.cs122b.basic.util.Validate;
import com.github.klefstad_teaching.cs122b.core.error.ResultError;
import com.github.klefstad_teaching.cs122b.core.result.BasicResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.transform.Result;

@RestController
public class BasicController
{
    private final BasicServiceConfig config;
    private final Validate validate;

    @Autowired
    public BasicController(BasicServiceConfig config,
                           Validate validate)
    {
        this.config = config;
        this.validate = validate;
    }

    @GetMapping("/hello")
    public ResponseEntity<ResultSuccessResponse> helloWorld()
    {
        ResultSuccessResponse response  = new ResultSuccessResponse()
                .setResult(BasicResults.HELLO)
                .setGreeting(config.greetingMessage());
        return response.toResponse();
    }

    @GetMapping("/reverse/{message}")
    public ResponseEntity<ReverseResponse> reverseMessage(@PathVariable String message)
    {
        //error check
        if (message.isEmpty())
        {
            throw new ResultError(BasicResults.STRING_IS_EMPTY);
        }

        ReverseResponse response  = new ReverseResponse()
                .setResult(BasicResults.STRING_SUCCESSFULLY_REVERSED)
                .setMessage("test");

        // need to actually reverse string
        return response.toResponse();
    }
}

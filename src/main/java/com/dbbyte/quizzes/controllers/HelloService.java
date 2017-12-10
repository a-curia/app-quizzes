package com.dbbyte.quizzes.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author adrian on 12/10/2017
 * @project app-quizzes
 */

@RestController
@RequestMapping(value = "/hello")
public class HelloService {

    @RequestMapping(value = {"/",""}, method = RequestMethod.GET)
    public String sayHello() {
        return "Hello World";
    }

}

package com.partha.service;


import com.partha.domain.User;
import com.sun.xml.internal.xsom.impl.Ref;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

/**
 * Created by pxl8108 on 2/10/17.
 * Simple rest controller service using spring application
 * There are
 */
@RestController
@RequestMapping("/sample")
public class SampleService {

    @RequestMapping("/greeting")
    public String greetings() {
        return "Welcome to the sample rest services!, System is up and running";
    }

    @RequestMapping("/param/{paramValue}")
    public String serviceWithParm(@PathVariable("paramValue") String paramValue) {
        return "Here is the path param which we have added ---> " + paramValue;

    }

    @RequestMapping("/queryParam")
    public String serviceWithQueryParm(@RequestParam(defaultValue = "default value") String queryValue) {
        return "Here is the path param which we have added ---> " + queryValue;
    }

    @RequestMapping("/pathParam/{paramValue}")
    public String serviceWithPathAndQueryParm(
            @PathVariable("paramValue") String paramValue,
            @RequestParam(defaultValue = "default value") String filter) {
        String value ="Default value";
        if(filter.startsWith("test")){
             value = filter;
        }
        return "Here is the path param and filter value as test ---> " + paramValue +value;
    }

    @RequestMapping(value = "/param/{paramValue}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String serviceWithRequestBody(
            @PathVariable("paramValue") String paramValue,
            @RequestBody User user) {
        return "Here is the path param which we have added ---> " + paramValue +user.getFirstName();

    }
}
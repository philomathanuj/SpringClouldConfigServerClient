package com.philomath.retail.retailconfigclient;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class SpringConfigClient {

    @Value("${message}")
    private String message;


    @RequestMapping(
            value = "/retail/{dummyPathVariable}",
            method = RequestMethod.GET,
            produces = MediaType.TEXT_PLAIN_VALUE)
    public String fetchMessage(@PathVariable("dummyPathVariable") String dummyPathVariable) {
        return dummyPathVariable+": value from config server is "+message;
    }
}

package com.jskool.controller;

import com.jskool.publisher.Publisher;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PublisherController {

    @Autowired
    private final Publisher publisher;

    @RequestMapping(value = "/publisher", method = RequestMethod.POST)
    public String streamPublisher(@RequestBody String message){
        publisher.streamPublisher(message);
        return "publisher";
    }
}

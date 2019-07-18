package com.liebig.demo.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.liebig.demo.dto.GreetingDto;

@RequestMapping("/api")
@RestController
public class GreetingApiController {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public GreetingDto greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new GreetingDto(counter.incrementAndGet(), "Hello, " + name);
        //String.format("Hello, %s!", name);
    }

}

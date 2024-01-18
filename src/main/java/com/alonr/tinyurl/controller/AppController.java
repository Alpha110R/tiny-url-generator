package com.alonr.tinyurl.controller;

import com.alonr.tinyurl.service.Redis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
public class AppController {
    @Autowired
    Redis redis;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public Boolean hello(@RequestParam String key) {
        if(Objects.nonNull(redis.get(key)))
            System.out.println(redis.get(key).toString());
        return redis.set(key,key);
    }

}

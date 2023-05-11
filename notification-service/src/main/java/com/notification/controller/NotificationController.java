package com.notification.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.IntStream;

@Slf4j
@RestController
public class NotificationController {

    @GetMapping("/ok")
    public String ok(){
        return "notification-service ok";
    }
}

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
        IntStream.range(0,10).forEach(index -> {
            log.info("notification-service  info log "+1);
        });
        return "notification-service ok";
    }
}

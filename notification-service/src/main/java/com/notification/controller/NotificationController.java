package com.notification.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

    @GetMapping("/ok")
    public String ok(){
        return "notification-service ok";
    }
}

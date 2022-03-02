package com.example.controller;

import com.example.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zetu
 */
@RestController
@RequestMapping("api/event")
public class EventDemoController {

    @Autowired
    private EventService eventService;

    @GetMapping("test1")
    public String eventTest1() {
        eventService.insertAndPublish();
        return "success";
    }
}

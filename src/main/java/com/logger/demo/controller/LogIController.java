package com.logger.demo.controller;

import com.logger.demo.service.LogServiceI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/log")
public class LogIController {

	@Autowired
    private LogServiceI logService;


    @PostMapping("/enable")
    public void enableLogLevel(@RequestParam String loggerName, @RequestParam String level) {
        logService.setLogLevel(loggerName, level);
    }

    @PostMapping("/disable")
    public void disableLogLevel(@RequestParam String loggerName) {
        logService.setLogLevel(loggerName, "OFF");
    }


}

package com.logger.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.logging.LogLevel;
import org.springframework.boot.logging.LoggingSystem;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class LoggingController {

    Logger logger = LoggerFactory.getLogger(LoggingController.class);


    @GetMapping
    public String  logss(){
        logger.info("[Info] Logging Controller Info");
        logger.trace("[TRACE] logging Controller Trace");
        logger.error("[Error] logging Controller Error");
        logger.debug("[Debug] Logging Controller Debug");
        logger.warn("[WARN] Logging Controller WARN");

        return "See the logs in Console";
    }

    @GetMapping("/change-to-logLevel")
    public String changeLogLevel(@RequestParam String Level) {
        LoggingSystem loggingSystem = LoggingSystem.get(LoggingController.class.getClassLoader());
        LogLevel logLevel = LogLevel.valueOf(Level.toUpperCase());
        loggingSystem.setLogLevel(LoggingController.class.getName(), logLevel);
        return "Changed loglevel to " + Level;
    }

}

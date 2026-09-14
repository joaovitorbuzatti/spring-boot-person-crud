package com.github.joaovitorbuzatti.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class TestLogController {

    private Logger logger = LoggerFactory.getLogger(TestLogController.class.getName());

    @GetMapping ("/teste")
    public String testLog(){
        logger.debug("This is an DEBUG log");
        logger.info("This is an INFO log");
        logger.warn("this is an WARN log");
        logger.error("this is an ERROR log");
        return "Logs generated successfully!";
    }

}

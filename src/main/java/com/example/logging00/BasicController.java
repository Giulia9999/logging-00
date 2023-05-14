package com.example.logging00;

import com.example.logging00.services.ServiceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class BasicController {
    @Autowired
    ServiceLog serviceLog;
    private final Logger logger = LoggerFactory.getLogger(BasicController.class);

    @GetMapping("/")
    public String welcome(){
        logger.info("Welcome message");
        return "Welcome to the app";
    }

    @GetMapping("/get-errors")
    public void getErrors(){
        Error error = new Error("Throw error");
        logger.error("Logging error", error);
    }

    @GetMapping("/exp")
    public double getExponent(){
        return serviceLog.exponent();
    }

}

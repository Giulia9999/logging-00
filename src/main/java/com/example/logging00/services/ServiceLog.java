package com.example.logging00.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
@Service
public class ServiceLog {
    private final Logger logger = LoggerFactory.getLogger(ServiceLog.class);
    @Value("${com.example.logging00.custom.variable.one}")
    private int customVariableOne;

    @Value("${com.example.logging00.custom.variable.two}")
    private int customVariableTwo;

    public double exponent(){
        logger.debug("Starting calculation...");
        int result = (int) Math.pow(customVariableOne, customVariableTwo);
        String message = String.format("%d to the power of %d is %d", customVariableOne, customVariableTwo, result);
        logger.debug(message);
        return result;
    }
}

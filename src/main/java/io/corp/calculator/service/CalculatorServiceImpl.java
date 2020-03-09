package io.corp.calculator.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import io.corp.calculator.utility.Operation;



@Service
public class CalculatorServiceImpl implements CalculatorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CalculatorServiceImpl.class);



    @Override
    public double calculator(double salary, int hours, String operation) {
    	
    	double hoursCalculation=0;

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Calculating result for : {} {} {}", salary, hours, operation);
        }

        Operation operacion = Operation.fromvalue(operation);

        if(operacion == null) {
            throw new RuntimeException("Operation impossible to process: " + operation);
        }

        switch (operacion) {
            case CALCULATOR:
            	
            	 if(hours>0){
            		 hoursCalculation=salary*hours;
                 }
                return hoursCalculation;
            default:        
                throw new RuntimeException("Operation not supported to be calculated: " + operacion.toString());

        }
    }
}

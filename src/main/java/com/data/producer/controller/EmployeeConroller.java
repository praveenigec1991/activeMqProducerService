package com.data.producer.controller;

import com.data.producer.entity.Employee;
import com.data.producer.services.EmployeeDataProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("employee")
public class EmployeeConroller {
    private static final Logger LOG = LoggerFactory.getLogger(EmployeeConroller.class);

    @Autowired
    private EmployeeDataProducerService producerService;

    @RequestMapping(value = "send",method = RequestMethod.POST)
    public String saveEmployee(@RequestBody Employee e)
    {
        LOG.info("Getting Request body {}",e);
        producerService.sendEmployeeObjectToMQ(e);
        return "Successfully send to mq";
    }



}

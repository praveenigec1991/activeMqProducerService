package com.data.producer.services;

import com.data.producer.entity.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.google.gson.Gson;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;


@Service
public class EmployeeDataProducerService {
    private static final Logger LOG = LoggerFactory.getLogger(EmployeeDataProducerService.class);

    @Autowired
    private JmsTemplate template ;
    @Autowired
    private Gson gson ;

    public void sendEmployeeObjectToMQ(Employee e)
    {
        String json = gson.toJson(e);
        LOG.info("Employee data parsed {} ",json);
        try {
            template.convertAndSend("employee", json);
        }
        catch (Exception e1)
        {
            e1.printStackTrace();
        }
    }
}

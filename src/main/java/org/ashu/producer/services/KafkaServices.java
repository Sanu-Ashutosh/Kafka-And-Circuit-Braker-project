package org.ashu.producer.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.ashu.producer.kafka.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;


import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Service
public class KafkaServices {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public boolean updateLocation(Map<String,Double> location){
        try {
            String json = objectMapper.writeValueAsString(location); // Convert map to JSON string
            CompletableFuture<SendResult<String, String>> send = kafkaTemplate.send(AppConstant.LOCATION_TOPIC_NAME, json);

            System.out.println("Sending location: " + json);
            return send != null ;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return false;
        }
    }
}

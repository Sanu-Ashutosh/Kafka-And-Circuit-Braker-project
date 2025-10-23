package org.ashu.producer.rest;

import org.ashu.producer.LocationGeenerate.LocationUtils;
import org.ashu.producer.services.KafkaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
//server.port=8081
@RequestMapping("/Location")
public class LocationController {

    @Autowired
    private KafkaServices kafkaServices;

    @GetMapping ("/update")
    public ResponseEntity<?> getLocation() {
        boolean response = kafkaServices.updateLocation(LocationUtils.generateRandomLocationGlobal());
        return  new ResponseEntity<>( Map.of("message","Location updated.","isUpdated",response
        ),HttpStatus.OK);
    }
}
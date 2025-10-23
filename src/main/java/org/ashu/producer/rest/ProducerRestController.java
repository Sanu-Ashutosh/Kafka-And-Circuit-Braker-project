package org.ashu.producer.rest;

import org.ashu.producer.services.ProducerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Producer")
public class ProducerRestController {

    @Autowired
    private ProducerServices  producerServices;

@GetMapping
    public ResponseEntity<?> getData() {
    System.out.println("Producer REST API GET");
       return  new ResponseEntity<>(producerServices.getProduct(), HttpStatus.OK);
    }


}

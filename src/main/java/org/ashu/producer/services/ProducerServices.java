package org.ashu.producer.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class ProducerServices {

    public Response getProduct() {
        return new Response("bdyu7-shdwj-dwsnja","Ashutosh Pradhan","sanu.ashutosh@Gamil.com","64467886473637");
    }
}







@Data
@AllArgsConstructor
@NoArgsConstructor
class Response{
    private String studentId;
    private String studentName;
    private String studentEmail;
    private String studentPhone;

}

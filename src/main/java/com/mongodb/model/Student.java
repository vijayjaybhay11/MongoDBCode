package com.mongodb.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.io.Serializable;

@Document(collection = "students")
@Data
public class Student implements Serializable {

    @Id
    private String id;
    private String name;
    private String city;
    private int pin;

}

package com.example.greeting;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

// this class is going to model what our greeting will look like
@Entity
public class Greeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String createdBy;
    private String greeting;
    private String originCountry;
    private LocalDateTime dateCreated;

    public Greeting() {
        this.dateCreated = LocalDateTime.now();
    }

    public Greeting(int id, String createdBy, String greeting, String originCountry) {
        this.createdBy = createdBy;
        this.greeting = greeting;
        this.originCountry = originCountry;
        //dateCreated should be the time NOW
        this.dateCreated = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public String getGreeting() {
        return greeting;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    @Override
    public String toString() {
        return "Greeting{" +
                "id=" + id +
                ", createdBy='" + createdBy + '\'' +
                ", greeting='" + greeting + '\'' +
                ", dateCreated=" + dateCreated +
                ", originCountry='" + originCountry + '\'' +
                '}';
    }
}

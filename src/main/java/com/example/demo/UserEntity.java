package com.example.demo;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import java.io.Serializable;

//@RedisHash("User")
@Entity
public class UserEntity implements Serializable {
    @Id
    private String id;
    private String name;
    private int orderId;
    private String timeStamp;
   

	public UserEntity setName(String name) {

        this.name = name;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserEntity setId(String id) {
        this.id = id;
        return this;
    }

    public String getId() {
        return id;
    }

    public UserEntity setOrderId(int orderId) {
        this.orderId = orderId;
        return this;
    }

    public int getOrderId() {
        return orderId;
    }


    public UserEntity setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
        return this;
    }

    public String getTimeStamp() {
        return timeStamp;
    }
    
}

	

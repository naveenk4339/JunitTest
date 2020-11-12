package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    public String createUser() {

        return "id";
    }

    UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;

    }

    public String create(UserRequest request) {

        UserEntity entity = repository.save(new UserEntity()
                .setId(createUser())
                .setName(request.getFirstName() + " " + request.getLastName())
                .setTimeStamp("")
                .setOrderId(0));
        return entity.getId();
    }
}

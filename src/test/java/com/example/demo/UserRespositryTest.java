package com.example.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.redis.DataRedisTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.Optional;

import static java.lang.System.currentTimeMillis;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@DataRedisTest
@RunWith(SpringRunner.class)
public class UserRespositryTest {

    @Autowired
    UserRepository repository;


    @Before
    public void setUp() {
        UserEntity userEntity = getUserEntity("Joe Produce", "xyz");
        repository.save(userEntity);
    }

    @Test
    public void saveUser() {
        UserEntity userEntity = getUserEntity("Joe Trader", "abc");
        UserEntity saved = repository.save(userEntity);

        assertThat(saved.getName(), is(equalTo(userEntity.getName())));
        assertThat(saved.getTimeStamp(), is(equalTo(userEntity.getTimeStamp())));
    }


    @Test
    public void getUser() {
        Optional<UserEntity> entity = repository.findById("xyz");
        assertThat(entity.isPresent(), is(true));
    }


    private UserEntity getUserEntity(String s, String id) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(s);
        userEntity.setId(id);
        userEntity.setOrderId(0);
        userEntity.setTimeStamp(new Timestamp(currentTimeMillis()).toString());
        return userEntity;
    }
}

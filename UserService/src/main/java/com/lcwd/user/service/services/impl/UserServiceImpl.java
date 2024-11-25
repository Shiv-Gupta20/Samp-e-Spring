package com.lcwd.user.service.services.impl;

import com.lcwd.user.service.entities.Rating;
import com.lcwd.user.service.entities.User;
import com.lcwd.user.service.exceptions.ResourceNotFoundException;
import com.lcwd.user.service.repositories.UserRespository;
import com.lcwd.user.service.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRespository userRespository;
    @Autowired
    private RestTemplate restTemplate;

    private Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {
        String randomUserId= UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRespository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRespository.findAll();
    }

    @Override
    public User getUser(String userId) {
        User user= userRespository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User with given id is not found"+userId));

        //fetch rating of the above user from RATING SERVICE
        //http://localhost:8083/ratings/users/5afeb5c5-90d9-466a-ab33-1c5e87571d3a


       // ArrayList<Rating> forObject=restTemplate.getForObject("http://localhost:8083/ratings/users/5afeb5c5-90d9-466a-ab33-1c5e87571d3a", ArrayList.class);
        ArrayList<Rating> forObject=restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserId(), ArrayList.class);
       logger.info("{}",forObject);
       user.setRatings(forObject);
        return user;
    }
}

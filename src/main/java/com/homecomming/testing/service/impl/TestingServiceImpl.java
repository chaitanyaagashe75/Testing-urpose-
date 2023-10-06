package com.homecomming.testing.service.impl;

import com.homecomming.testing.model.Testing;
import com.homecomming.testing.repository.TestingRepository;
import com.homecomming.testing.service.TestingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class TestingServiceImpl implements TestingService {

    @Autowired
    private TestingRepository testingRepository;


    @Override
    public Testing addTesting(Testing testing) {
        String testing_id  = UUID.randomUUID().toString();
        testing.setTesting_id(testing_id);
        return testingRepository.save(testing);
    }

    @Override
    public Testing getTesting(String testingId) {
       Optional<Testing> OptTesting = testingRepository.findById(testingId);
        if(OptTesting.isPresent()){
          return OptTesting.get();
        }else{
            log.info("Testing id {} not found",testingId);
            return null;
        }

    }

    @Override
    public Testing updateTesting(Testing testing) {
       Optional<Testing> presentTesting = testingRepository.findById(testing.getTesting_id());
       if(presentTesting.isPresent()){
          Testing testing1 = presentTesting.get();
          testing1.setTesting_time(testing.getTesting_time());
           return testingRepository.save(testing1);

       }else{
           log.info("testing id { } not found ",testing.getTesting_id());
           return null;
       }
    }

    @Override
    public String deleteTesting(String testing_id) {
        Optional<Testing> OptTesting = testingRepository.findById(testing_id);
        if(OptTesting.isPresent()){
           Testing DeletedTesting = OptTesting.get();
           testingRepository.deleteById(testing_id);
            String message = "Testing record with ID " + testing_id + " has been deleted successfully";
            log.info(message);
            return message;
        }else{
            log.info("id {} not found", testing_id);
            return "testing record not found";
        }
    }

}

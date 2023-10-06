package com.homecomming.testing.controller;

import com.homecomming.testing.model.Testing;
import com.homecomming.testing.service.TestingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/testing")
public class TestingController {

    @Autowired
    private TestingService testingService;

    @PostMapping("/add")
    public Testing addTesting(@RequestBody Testing testing){
        return testingService.addTesting(testing);
    }

    @GetMapping("/get/{testing_id}")
    public Testing getTesting(@PathVariable String testing_id){
        return testingService.getTesting(testing_id);
    }

    @PutMapping("/update")
    public Testing updateTesting(@RequestBody Testing testing){
        return testingService.updateTesting(testing);
    }

    @DeleteMapping("/delete/{testing_id}")
    public String deleteTesting(@PathVariable String testing_id){
        return testingService.deleteTesting(testing_id);
    }
}

package com.homecomming.testing.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
public class Testing {

    @Id
    String testing_id;
    String testing_time;

}

// This is the model for testing

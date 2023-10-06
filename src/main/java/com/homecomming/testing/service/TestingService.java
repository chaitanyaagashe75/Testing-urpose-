package com.homecomming.testing.service;

import com.homecomming.testing.model.Testing;

public interface TestingService {
   public Testing addTesting(Testing testing);

   public Testing getTesting(String testing_id);

   public Testing updateTesting(Testing testing);

  public String deleteTesting(String testing_id);
}

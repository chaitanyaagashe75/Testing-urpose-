package com.homecomming.testing.repository;

import com.homecomming.testing.model.Testing;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestingRepository extends MongoRepository<Testing, String> {

}

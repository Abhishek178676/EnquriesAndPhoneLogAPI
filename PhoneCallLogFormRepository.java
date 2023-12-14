package com.phonelog.apllication.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.phonelog.apllication.mongo.PhoneCallLogForm;
@Repository
public interface PhoneCallLogFormRepository extends MongoRepository<PhoneCallLogForm, String> {

}

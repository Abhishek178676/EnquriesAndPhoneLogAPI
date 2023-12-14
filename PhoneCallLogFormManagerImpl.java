package com.phonelog.apllication.mongo.manager.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phonelog.apllication.mongo.PhoneCallLogForm;
import com.phonelog.apllication.mongo.manager.PhoneCallLogFormManager;
import  com.phonelog.apllication.mongo.repository.PhoneCallLogFormRepository;
@Service
public class PhoneCallLogFormManagerImpl implements PhoneCallLogFormManager{
	
	@Autowired PhoneCallLogFormRepository PhoneCallLogFormRepository;

	@Override
	public PhoneCallLogForm findById(String id) {
		Optional<PhoneCallLogForm> u = PhoneCallLogFormRepository.findById(id);
		PhoneCallLogForm phone = null;
		if (u.isPresent()) {
			phone = u.get();
		}
		return phone;
	}

	@Override
	public PhoneCallLogForm save(PhoneCallLogForm phoneCallLogForm) {
		return PhoneCallLogFormRepository.save(phoneCallLogForm);
		
        
	}

	@Override
	public void delete(String id) {
		  if (PhoneCallLogFormRepository.existsById(id)) {
			  PhoneCallLogFormRepository.deleteById(id);
	        } else {
	            throw new NoSuchElementException("Product not found with ID: " + id);
	        }
		
	}

	@Override
	public List<PhoneCallLogForm> ListAll() {
		 List<PhoneCallLogForm> phoneCallLogForm=PhoneCallLogFormRepository.findAll();
		return phoneCallLogForm;
	}

}

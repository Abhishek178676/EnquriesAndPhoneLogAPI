package com.phonelog.apllication.ws;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phonelog.apllication.mongo.PhoneCallLogForm;
import com.phonelog.apllication.mongo.manager.PhoneCallLogFormManager;

@RestController
@RequestMapping("/phoneCall")
public class PhoneCallLogFormcontroller {

	@Autowired PhoneCallLogFormManager phoneCallLogFormManager;
	MongoTemplate mongoTemplate;
	
	@PostMapping("/save")
	public ResponseEntity<String> savePhoneCall(@RequestBody PhoneCallLogForm phoneCallLogForm){
		PhoneCallLogForm phoneCallLog = null;
		try {
			if(phoneCallLogForm.getId()!=null) {
			phoneCallLog=phoneCallLogFormManager.findById(phoneCallLogForm.getId());	
			}
			if(phoneCallLog==null) {	
				
				BeanUtils.copyProperties(phoneCallLogForm, phoneCallLog);
				phoneCallLogFormManager.save(phoneCallLogForm);	
				 return ResponseEntity.ok("Phone call Added successfully");	
			}
			else {
				
				BeanUtils.copyProperties(phoneCallLogForm, phoneCallLog,"id");
				phoneCallLogFormManager.save(phoneCallLogForm);	
				return ResponseEntity.ok("Phone call updated successfully");	
		
			}
		}
		catch(Exception e){
			return ResponseEntity.ok("Saving Fields Failed");	
		}	
	}
	
	
	 @DeleteMapping("/delete/{id}")
	    public ResponseEntity<String> deletePhoneCall(@PathVariable String id) {
	        try {
	        	phoneCallLogFormManager.delete(id);
	            return ResponseEntity.ok("Product deleted successfully");
	            
	        } catch (NoSuchElementException e) {
	        	 	return ResponseEntity.ok("Phone call deleted successfully");
	        }
	    }
	 
	 
	 @GetMapping("/list")
	 public List<PhoneCallLogForm> listEnquiryForm() { 
		 Query query = new Query();
		    query.with(Sort.by(Sort.Direction.ASC, "firstName")); 
		    List<PhoneCallLogForm> phoneCallLogs = mongoTemplate.find(query, PhoneCallLogForm.class);
		 return phoneCallLogs;
	 }
}

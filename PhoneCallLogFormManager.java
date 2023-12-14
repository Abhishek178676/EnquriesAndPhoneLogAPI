package com.phonelog.apllication.mongo.manager;

import java.util.List;

import com.phonelog.apllication.mongo.PhoneCallLogForm;

public interface PhoneCallLogFormManager {
	
	PhoneCallLogForm findById(String id);
	PhoneCallLogForm save(PhoneCallLogForm  phoneCallLogForm);
	void delete(String id);
	List<PhoneCallLogForm> ListAll();
}

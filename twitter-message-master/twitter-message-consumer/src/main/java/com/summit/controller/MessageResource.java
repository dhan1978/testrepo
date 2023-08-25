package com.summit.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.summit.consumer.MessageConsumer;





@RestController
@RequestMapping("/getMassage")
public class MessageResource {
	@Autowired
	private MessageConsumer messageConsumer;

	@PostMapping
	public String getMessage() {
		//messageProducer.send( message );
		
		String massage=messageConsumer.recived().toString();
		return massage;
	}
}

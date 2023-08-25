package com.summit.producer;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.azure.messaging.servicebus.ServiceBusMessage;
import com.azure.messaging.servicebus.ServiceBusSenderClient;

//import com.azure.messaging.servicebus.ServiceBusMessage;
//import com.azure.messaging.servicebus.ServiceBusSenderClient;



@Slf4j
@Component
@EnableJms
public class MessageProducer {

	@Autowired
	private JmsTemplate jmsTemplate;

	@Value("${activemq.queue.name}")
	private String queueName;
	
	
	 
	@Autowired
	private	ServiceBusSenderClient senderClient;
	
	public void send(String message) {
		//log.info( "Sending Twitter Message '{}' to destination '{}'", message, queueName );
		//jmsTemplate.convertAndSend(queueName, message);
		ServiceBusMessage serviceBusMessage=new ServiceBusMessage(message);
		senderClient.sendMessage( serviceBusMessage);
	}
	
	//public void send(String message) {
//		log.info( "Sending Twitter Message '{}' to destination '{}'", message, queueName );
		//jmsTemplate.convertAndSend(queueName, message);
		//senderClient.sendMessage( message);
	//}
	
}

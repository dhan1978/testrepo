package com.summit.consumer;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.azure.messaging.servicebus.ServiceBusReceivedMessage;
import com.azure.messaging.servicebus.ServiceBusReceiverAsyncClient;
import com.azure.messaging.servicebus.ServiceBusReceiverClient;

@Slf4j
@Component
@EnableJms
public class MessageConsumer {
	
	@Autowired
	private ServiceBusReceiverClient receiveClient;
	//@Autowired
	//public JmsTemplate jmsTemplate;
	/*
//Logger log=new Logger(MessageConsumer) ;
	@JmsListener(destination = "${activemq.queue.name}", containerFactory = "jmsListenerContainerFactory")		 
	public void receive(String message) {
		//log.info("Received Message '{}'", message);
		// message= 
    			//receiveClient.receiveMessages();
    	//jmsTemplate.receive();
		System.out.println("Received Message '{}'"+ message);
	}
*/
	//@JmsListener(destination = "${activemq.queue.name}")
    public Object recived(){
    	//Object message= 
    			//receiveClient.receiveMessages();
    	//jmsTemplate.receive();
    	ServiceBusReceivedMessage serviceBusReceivedMessage= receiveClient.peekMessage();
    	String message =serviceBusReceivedMessage.getBody().toString();
    		//	JmsTemplate.receive(this.queue);
    	System.out.println(" [x] recived '" + message + "'");
    	return message;
    }
    
}

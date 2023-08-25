package com.summit.config;

import org.apache.activemq.ActiveMQConnectionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

import com.azure.messaging.servicebus.ServiceBusClientBuilder;
import com.azure.messaging.servicebus.ServiceBusReceiverAsyncClient;
import com.azure.messaging.servicebus.ServiceBusReceiverClient;

//import com.azure.messaging.servicebus.ServiceBusClientBuilder;

//import com.azure.messaging.servicebus.ServiceBusClientBuilder;
//import com.azure.messaging.servicebus.ServiceBusReceiverAsyncClient;

@Configuration
public class JMSConfig {

	@Value("${activemq.broker.url}")
	private String brokerUrl;
	@Value("${activemq.broker.user}")
	private String brokerUser;
	@Value("${activemq.broker.password}")
	private String brokerPassword;
	@Value("${activemq.queue.name}")
	private String queueName;
	
/*
	@Bean
	public ActiveMQConnectionFactory activeMQConnectionFactory() {
		//return new ActiveMQConnectionFactory(brokerUser, brokerPassword, brokerUrl);
		return new  ActiveMQConnectionFactory();
	}

	@Bean
	public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		factory.setConnectionFactory(activeMQConnectionFactory());
		factory.setConcurrency("50");

		return factory;
	}
	
	@Bean
	public JmsTemplate jmsTemplate() {
		return new JmsTemplate();
		//return null;
	}
	*/
	@Bean
	public ServiceBusReceiverClient  receiveClient() {
		ServiceBusReceiverClient receiver = 
				new ServiceBusClientBuilder()
			    .connectionString(brokerUrl)
			    .receiver().queueName(queueName).buildClient();
			  //  .topicName("<< TOPIC NAME >>")
			    //.subscriptionName("<< SUBSCRIPTION NAME >>")
			    //.buildAsyncClient();
		return receiver;
	}
	
	
}

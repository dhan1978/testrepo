package com.summit.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

import com.azure.messaging.servicebus.ServiceBusClientBuilder;
import com.azure.messaging.servicebus.ServiceBusSenderClient;












@Configuration
@EnableJms
public class JMSConfig {

	@Value("${activemq.broker.url}")
	private String brokerUrl;
	@Value("${activemq.broker.user}")
	private String brokerUser;
	@Value("${activemq.broker.password}")
	private String brokerPassword;
	@Value("${activemq.broker.host")
	private String host;
	@Value("${activemq.queue.name}")
	private String queueName;
/*
	@Bean
	public CachingConnectionFactory cachingConnectionFactory() {
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory( brokerUser, brokerPassword, brokerUrl );
		return new CachingConnectionFactory(factory);
	}

	@Bean
	public JmsTemplate jmsTemplate() {
		return new JmsTemplate(cachingConnectionFactory());
	}
*/
	/*
	@Bean
	public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		factory.setConnectionFactory(cachingConnectionFactory());
		//factory.createListenerContainer(null)
		factory.setConcurrency("50");
		
		return factory;
	}
	*/
	/*
	@Bean
	public ServiceBusSenderClient senderClient() {
		//DefaultAzureCredential credential = new DefaultAzureCredentialBuilder()
	    //        .build();

	     ServiceBusSenderClient senderClient = new ServiceBusClientBuilder().fullyQualifiedNamespace(host.toString())
	    		 
	             .sender()
	             .queueName(queueName)
	             .buildClient();
	     return senderClient;
	}
	*/
	@Bean
	public ServiceBusSenderClient  senderClient() {
		//ServiceBusClientBuilder.ServiceBusSenderClientBuilder;
		ServiceBusSenderClient sender = new ServiceBusClientBuilder()
			    .connectionString(brokerUrl)
			    .sender()
			    .queueName(queueName)
			    .buildClient();
		return sender; 
	}
}

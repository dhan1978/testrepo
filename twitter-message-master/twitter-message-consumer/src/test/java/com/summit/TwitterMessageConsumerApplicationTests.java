package com.summit;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.summit.consumer.MessageConsumer;
import com.summit.controller.MessageResource;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TwitterMessageConsumerApplicationTests {

	@Test
	public void contextLoads() {
	}
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
	private MessageResource messageResource;

	@Before
	public void setUp() {
		this.mockMvc = webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void test() throws Exception {
		for (int i = 0; i < 100; i++) {
			mockMvc.perform( get( "/getMassage" ) ).andReturn();
		}
	}
	@Test
	public void test2() throws Exception {
		for (int i = 0; i < 100; i++) {
			messageResource.getMessage();
		}
	}
}

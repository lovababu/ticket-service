package org.ticketservice;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;
import org.ticketservice.api.JSeatHold;
import org.ticketservice.api.TicketServiceResponse;

import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TicketServiceApplication.class)
@WebIntegrationTest(value = "server.address=localhost", randomPort = true)
public class TicketServiceApplicationTests {

	private RestTemplate restTemplate = null;

	@Value("${local.server.port}")  //boot injects the port used for bootstart the application.
	private int port;

	private String baseURL = null;

	@Before
	public void setUp(){
		restTemplate = new TestRestTemplate();
		baseURL = "http://localhost:"+ port + "/ticket";
	}

	@Test
	public void checkAvailability() {
		TicketServiceResponse response = restTemplate.getForObject(baseURL+"/level/1/available", TicketServiceResponse.class);
		assertEquals(response.getStatusCode(), Response.Status.OK.getStatusCode());
		assertEquals(10, response.getAvailableSeats());
	}

	private JSeatHold jSeatHold(String email, int numSeats, int minLevel, int maxLevel) {

        return null;
    }
}

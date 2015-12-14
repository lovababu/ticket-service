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
import org.ticketservice.api.TicketServiceResponse;
import org.ticketservice.domain.BookTicket;
import org.ticketservice.domain.Ticket;

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
		TicketServiceResponse response = restTemplate.getForObject(baseURL+"/availability", TicketServiceResponse.class);
		assertEquals(response.getStatusCode(), Response.Status.OK.getStatusCode());
		assertEquals(10, response.getTickets().get("Balcony1").size());
		assertEquals(10, response.getTickets().get("Balcony2").size());
		assertEquals(10, response.getTickets().get("Main").size());
		assertEquals(10, response.getTickets().get("Orchestra").size());
	}

	@Test
	public void bookAndCheckAvailability() {
		TicketServiceResponse response = restTemplate.postForObject(baseURL + "/book?category=Balcony1", bookTicket("Mahesh k", "xyz", 5) , TicketServiceResponse.class);
		assertEquals(Response.Status.ACCEPTED.getStatusCode(), response.getStatusCode());

		response = restTemplate.getForObject(baseURL+"/availability", TicketServiceResponse.class);
		assertEquals(response.getStatusCode(), Response.Status.OK.getStatusCode());
		assertEquals(9, response.getTickets().get("Balcony1").size());
		assertEquals(10, response.getTickets().get("Balcony2").size());
		assertEquals(10, response.getTickets().get("Main").size());
		assertEquals(10, response.getTickets().get("Orchestra").size());
	}

	private BookTicket bookTicket(String name, String mobile, int seatNo) {
        BookTicket bookTicket = new BookTicket();
        bookTicket.setName(name);
        bookTicket.setContact(mobile);
        Ticket ticket = new Ticket();
        ticket.setSeatNo(seatNo);
        bookTicket.addTicket(ticket);
        return bookTicket;
    }
}

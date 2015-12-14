package org.ticketservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.ticketservice.api.TicketServiceResponse;
import org.ticketservice.domain.BookTicket;
import org.ticketservice.domain.Ticket;
import org.ticketservice.service.TicketService;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Map;

/**
 * Created by Durga on 12/14/2015.
 */
@Path(value = "/")
@Produces(MediaType.APPLICATION_JSON)
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GET
    @Path(value = "availability")
    public Response checkAvailability() {
        System.out.println("TicketController.checkAvailability");
        try {
            Map<String, List<Ticket>> availableTickets = ticketService.checkAvailability();
            TicketServiceResponse ticketServiceResponse = TicketServiceResponse.builder()
                    .withStatusCode(Response.Status.OK.getStatusCode()).withTickets(availableTickets).build();
            return Response.status(Response.Status.OK).entity(ticketServiceResponse).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path(value = "book")
    public Response book(BookTicket bookTicket, @QueryParam("category") String category) {
        try {
            BookTicket bookTicket1 = ticketService.bookTicket(bookTicket, category);
            TicketServiceResponse ticketServiceResponse = TicketServiceResponse.builder()
                    .withStatusCode(Response.Status.ACCEPTED.getStatusCode()).withBookTicket(bookTicket).build();
            return Response.status(Response.Status.ACCEPTED).entity(ticketServiceResponse).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GET
    @Path(value = "status")
    public Response bookingStatus() {
        try {
            Map<String, List<Ticket>> currentStatus = ticketService.currentStatus();
            TicketServiceResponse ticketServiceResponse = TicketServiceResponse.builder()
                    .withStatusCode(Response.Status.OK.getStatusCode()).withTickets(currentStatus).build();
            return Response.status(Response.Status.OK).entity(ticketServiceResponse).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}

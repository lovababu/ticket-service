package org.ticketservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
            return Response.status(Response.Status.OK).entity(availableTickets).build();
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
            return Response.status(Response.Status.ACCEPTED).entity(bookTicket).build();
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
            return Response.status(Response.Status.OK).entity(currentStatus).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}

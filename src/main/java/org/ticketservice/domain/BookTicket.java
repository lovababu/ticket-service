package org.ticketservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Durga on 12/14/2015.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookTicket {

    private String name;
    private String contact;

    private List<Ticket> tickets;

    public void addTicket(Ticket ticket) {
        if (this.tickets == null) {
            this.tickets = new ArrayList<>();
        }
        this.tickets.add(ticket);
    }

   /* public static void main(String[] args) throws IOException {
        BookTicket bookTicket = new BookTicket();
        bookTicket.setName("aaa");
        bookTicket.setContact("aaa");
        Ticket ticket = new Ticket();
        ticket.setId(1);
        ticket.setPrice(new BigDecimal(10));
        ticket.setSeatNo(2);
        ticket.setSold(false);
        bookTicket.addTicket(ticket);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(System.out, bookTicket);
    }*/
}

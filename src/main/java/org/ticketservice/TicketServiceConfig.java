package org.ticketservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.ticketservice.domain.Ticket;
import org.ticketservice.vo.Balcony1;
import org.ticketservice.vo.Balcony2;
import org.ticketservice.vo.Main;
import org.ticketservice.vo.Orchestra;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Durga on 12/14/2015.
 */

@Configuration
public class TicketServiceConfig {

    @Bean
     public Balcony1 balcony1() {
        // value '10' should be read from external.
        List<Ticket> tickets = new ArrayList<Ticket>();
        for (int i =0; i < 10; i++) {
            Ticket ticket = new Ticket();
            ticket.setId(i);
            ticket.setSeatNo(i);
            ticket.setPrice(new BigDecimal(50));
            tickets.add(ticket);
        }
        System.out.println("TicketServiceConfig.balcony1");
        return Balcony1.builder().withTickets(tickets).build();
    }

    @Bean
    public Balcony2 balcony2() {
        // value '10' should be read from external.
        List<Ticket> tickets = new ArrayList<Ticket>();
        for (int i =0; i < 10; i++) {
            Ticket ticket = new Ticket();
            ticket.setId(i);
            ticket.setSeatNo(i);
            ticket.setPrice(new BigDecimal(40));
            tickets.add(ticket);
        }
        System.out.println("TicketServiceConfig.balcony2");
        return Balcony2.builder().withTickets(tickets).build();
    }

    @Bean
    public Main main() {
        // value '10' should be read from external.
        List<Ticket> tickets = new ArrayList<Ticket>();
        for (int i =0; i < 10; i++) {
            Ticket ticket = new Ticket();
            ticket.setId(i);
            ticket.setSeatNo(i);
            ticket.setPrice(new BigDecimal(75));
            tickets.add(ticket);
        }
        System.out.println("TicketServiceConfig.main");;
        return Main.builder().withTickets(tickets).build();
    }

    @Bean
    public Orchestra orchestra() {
        // value '10' should be read from external.
        List<Ticket> tickets = new ArrayList<Ticket>();
        for (int i =0; i < 10; i++) {
            Ticket ticket = new Ticket();
            ticket.setId(i);
            ticket.setSeatNo(i);
            ticket.setPrice(new BigDecimal(100));
            tickets.add(ticket);
        }
        System.out.println("TicketServiceConfig.orchestra");
        return Orchestra.builder().withTickets(tickets).build();
    }
}

package org.ticketservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ticketservice.domain.BookTicket;
import org.ticketservice.domain.Ticket;
import org.ticketservice.vo.Balcony1;
import org.ticketservice.vo.Balcony2;
import org.ticketservice.vo.Main;
import org.ticketservice.vo.Orchestra;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Durga on 12/14/2015.
 */

@Service
public class TicketService {

    @Autowired
    private Balcony1 balcony1;

    @Autowired
    private Balcony2 balcony2;

    @Autowired
    private Main main;

    @Autowired
    private Orchestra orchestra;

    public Map<String, List<Ticket>> checkAvailability() {
        Map<String, List<Ticket>> availableTickets = new HashMap<String, List<Ticket>>();
        availableTickets.put("Balcony1", balcony1.getTickets());
        availableTickets.put("Balcony2", balcony2.getTickets());
        availableTickets.put("Main", main.getTickets());
        availableTickets.put("Orchestra", orchestra.getTickets());
        return availableTickets;
    }

    public BookTicket bookTicket(BookTicket bookTicket, String category){
        switch (category) {
            case "Balcony1" : {
                for (Ticket ticket: bookTicket.getTickets()) {
                    for (Ticket t: balcony1.getTickets()) {
                        if (ticket.getSeatNo() == t.getSeatNo() && !t.isSold()) {
                            t.setSold(true);
                        }
                    }
                }
                break;
            }

            case "Balcony2" : {
                for (Ticket ticket: bookTicket.getTickets()) {
                    for (Ticket t: balcony2.getTickets()) {
                        if (ticket.getSeatNo() == t.getSeatNo() && !t.isSold()) {
                            t.setSold(true);
                        }
                    }
                }
                break;
            }

            case "Main" : {
                for (Ticket ticket: bookTicket.getTickets()) {
                    for (Ticket t: main.getTickets()) {
                        if (ticket.getSeatNo() == t.getSeatNo() && !t.isSold()) {
                            t.setSold(true);
                        }
                    }
                }
                break;
            }

            case "Orchestra" : {
                for (Ticket ticket: bookTicket.getTickets()) {
                    for (Ticket t: orchestra.getTickets()) {
                        if (ticket.getSeatNo() == t.getSeatNo() && !t.isSold()) {
                            t.setSold(true);
                        }
                    }
                }
                break;
            }

            default: {
                System.out.println("Invalid Booking option.");
            }
        }
        return null;
    }

    public Map<String, List<Ticket>> currentStatus() {
        Map<String, List<Ticket>> currentStatus = new HashMap<String, List<Ticket>>();
        currentStatus.put("Balcony1", balcony1.getAllTickets());
        currentStatus.put("Balcony2", balcony2.getAllTickets());
        currentStatus.put("Main", main.getAllTickets());
        currentStatus.put("Orchestra", orchestra.getAllTickets());
        return currentStatus;
    }
}

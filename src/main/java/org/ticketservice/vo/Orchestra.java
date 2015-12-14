package org.ticketservice.vo;

import org.ticketservice.domain.Ticket;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Durga on 12/14/2015.
 */
public class Orchestra {
    private List<Ticket> tickets;

    private Orchestra() {
    }

    public Orchestra(Builder builder) {
        this.tickets = builder.tickets;
    }

    public List<Ticket> getTickets() {
        List<Ticket> ticketsAvail = new ArrayList<Ticket>();
        for (Ticket ticket : tickets) {
            if (!ticket.isSold()) {
                ticketsAvail.add(ticket);
            }
        }
        return ticketsAvail;
    }

    public List<Ticket> getAllTickets() {
        return tickets;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private List<Ticket> tickets;

        public final Orchestra build() {
            return new Orchestra(this);
        }

        public Builder withTickets(List<Ticket> tickets) {
            if (this.tickets == null) {
                this.tickets = new ArrayList<Ticket>();
            }
            this.tickets = tickets;
            return this;
        }
    }
}

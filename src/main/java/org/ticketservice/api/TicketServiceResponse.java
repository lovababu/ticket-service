package org.ticketservice.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.ticketservice.domain.BookTicket;
import org.ticketservice.domain.Ticket;

import java.util.List;
import java.util.Map;

/**
 * Created by Durga on 12/14/2015.
 */

@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TicketServiceResponse {

    private int statusCode;
    private BookTicket bookTicket;
    private Map<String, List<Ticket>> tickets;

    public TicketServiceResponse(Builder builder) {
        this.bookTicket = builder.bookTicket;
        this.statusCode = builder.statusCode;
        this.tickets = builder.tickets;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        public TicketServiceResponse build() {
            return new TicketServiceResponse(this);
        }

        private int statusCode;
        private BookTicket bookTicket;
        private Map<String, List<Ticket>> tickets;

        public Builder withStatusCode(int statusCode) {
            this.statusCode = statusCode;
            return this;
        }

        public Builder withBookTicket(BookTicket ticket) {
            this.bookTicket = ticket;
            return this;
        }

        public Builder withTickets(Map<String, List<Ticket>> tickets) {
            this.tickets = tickets;
            return this;
        }

    }
}

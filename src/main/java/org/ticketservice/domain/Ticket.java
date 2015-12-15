package org.ticketservice.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by Durga on 12/14/2015.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Ticket {
    private BigDecimal price;
    private int seatNo;
    private boolean isSold;
    private boolean isHold;
    private int level;

    /*@Override
    public int hashCode() {
        return Integer.valueOf(seatNo).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Ticket ticket = (Ticket) obj;
        if (getSeatNo() == ticket.getSeatNo()) {
            return true;
        } else {
            return false;
        }
    }*/
}

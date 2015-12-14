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
}

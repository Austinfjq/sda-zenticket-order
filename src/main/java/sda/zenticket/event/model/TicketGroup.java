package sda.zenticket.event.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class TicketGroup {
    private String groupName;
    private Integer stock;
    private BigDecimal price;
}

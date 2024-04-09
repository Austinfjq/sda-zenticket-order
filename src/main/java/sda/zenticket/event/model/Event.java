package sda.zenticket.event.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

@Getter
@Setter
@Document(collection = "event")
public class Event implements Serializable {
    @Id
    private String id;
    private String eventName;
    private String description;
    private Instant eventStartTime;
    private Instant releaseTime;
    private List<TicketGroup> ticketGroups;
}

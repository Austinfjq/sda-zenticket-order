package sda.zenticket.event.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sda.zenticket.event.model.Event;
import sda.zenticket.event.repository.EventRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    public Event createEvent(Event event) {
        event.setId(null);
        return eventRepository.save(event);
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event getEventById(String eventId) {
        return eventRepository.findById(eventId).orElse(null);
    }

    public Event updateEvent(Event eventDetails) {
        return eventRepository.save(eventDetails);
    }

    public boolean deleteEvent(String eventId) {
        return eventRepository.findById(eventId).map(event -> {
            eventRepository.deleteById(eventId);
            return true;
        }).orElse(false);
    }
}

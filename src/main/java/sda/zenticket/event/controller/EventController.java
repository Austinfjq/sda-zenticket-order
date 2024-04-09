package sda.zenticket.event.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sda.zenticket.event.model.Event;
import sda.zenticket.event.service.EventService;

import java.util.List;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, Spring Boot!";
    }

    // Create a new event
    @PostMapping
    public Event createEvent(@RequestBody Event event) {
        return eventService.createEvent(event);
    }

    // Retrieve all events
    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    // Retrieve a single event by its id
    @GetMapping("/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable(value = "id") String eventId) {
        Event event = eventService.getEventById(eventId);
        if(event == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(event);
    }

    // Update an event given its id
    @PutMapping("/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable(value = "id") String eventId, @RequestBody Event event) {
        event.setId(eventId);
        Event updatedEvent = eventService.updateEvent(event);
        if(updatedEvent == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedEvent);
    }

    // Delete an event given its id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable(value = "id") String eventId) {
        if(eventService.deleteEvent(eventId)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}

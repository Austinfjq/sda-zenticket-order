package sda.zenticket.event.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import sda.zenticket.event.model.Event;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends MongoRepository<Event, String> {
    // find by event name
    Event findByEventName(String eventName);

    // Get event by ID
    Optional<Event> findById(String id);

    @Query("{ 'eventName' : { $regex: ?0, $options: 'i' } }")
    List<Event> searchByName(String name);

    // List all events
    List<Event> findAll();

    // Save or update event
    <S extends Event> S save(S entity);

    // Delete event by ID
    void deleteById(String id);
}

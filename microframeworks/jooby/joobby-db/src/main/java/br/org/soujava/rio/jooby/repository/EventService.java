package br.org.soujava.rio.jooby.repository;

import java.util.List;

import br.org.soujava.rio.jooby.model.Event;

public interface EventService {

    List<Event> getAll();
    void save(Event event);
}
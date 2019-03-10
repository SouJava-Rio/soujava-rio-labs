package br.org.soujava.rio.repository;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Destroyed;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import br.org.soujava.rio.model.Event;

@ApplicationScoped
public class PreBoot {

    @Inject
    private EventRepository eventRepository;

    public void init(@Observes @Initialized(ApplicationScoped.class) Object init) {
        this.eventRepository.save(new Event("deltaspike", "best event of earth", "Apache"));
    }

    public void destroy(@Observes @Destroyed(ApplicationScoped.class) Object init) {
        eventRepository.flush();
    }
}
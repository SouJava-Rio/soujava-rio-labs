package br.org.soujava.rio.repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.apache.deltaspike.core.api.resourceloader.InjectableResource;

import br.org.soujava.rio.model.Event;

@ApplicationScoped
public class PreBoot {

    @Inject
    private EventRepository eventRepository;
    
    @Inject
    @InjectableResource(location="meetup.txt")
    private InputStream inputStream;

    public void init(@Observes @Initialized(ApplicationScoped.class) Object init) {

        try (var palestrantes = new BufferedReader(new InputStreamReader(inputStream))) {
            palestrantes.lines().forEach(palestrante-> {
                var output = palestrante.split("-");
                this.eventRepository.save(new Event(output[0], output[1], output[2]));
                });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
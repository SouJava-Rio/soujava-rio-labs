package br.org.soujava.rio.helidon.main;

import java.io.IOException;
import java.util.Optional;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.jboss.weld.environment.se.events.ContainerInitialized;

import br.org.soujava.rio.helidon.model.Event;
import br.org.soujava.rio.helidon.model.ResponseModel;
import br.org.soujava.rio.helidon.repository.EventRepository;
import io.helidon.media.jsonb.server.JsonBindingSupport;
import io.helidon.webserver.Handler;
import io.helidon.webserver.Routing;
import io.helidon.webserver.ServerConfiguration;
import io.helidon.webserver.WebServer;

public class App {

    public static Optional<String> port = Optional.ofNullable(System.getenv("PORT"));
    
    @Inject
    private EventRepository eventRepository;

     public void main(@Observes ContainerInitialized event) throws IOException {

        var configuration = ServerConfiguration.builder().port(Integer.parseInt(port.orElse("8080"))).build();

        WebServer.create(configuration,Routing.builder().register(JsonBindingSupport.create())
                        .post("/events", Handler.create(Event.class, (req,res,events) -> {
                            this.eventRepository.save(events);
                            res.send(new ResponseModel(res.status().code(), "Evento salvo com Sucesso !"));
                        })).get("/events", (req,res) -> res.send(eventRepository.findAll())))
                        
                        .start();
    }
}

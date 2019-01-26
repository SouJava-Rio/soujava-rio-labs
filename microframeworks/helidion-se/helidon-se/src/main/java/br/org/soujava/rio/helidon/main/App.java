package br.org.soujava.rio.helidon.main;

import java.io.IOException;
import java.util.Optional;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;

import org.jboss.weld.environment.se.events.ContainerInitialized;

import br.org.soujava.rio.helidon.model.Event;
import br.org.soujava.rio.helidon.model.ResponseModel;
import br.org.soujava.rio.helidon.repository.EventRepository;
import io.helidon.webserver.Handler;
import io.helidon.webserver.Routing;
import io.helidon.webserver.ServerConfiguration;
import io.helidon.webserver.ServerRequest;
import io.helidon.webserver.ServerResponse;
import io.helidon.webserver.WebServer;
import io.helidon.webserver.json.JsonSupport;

public class App {

    public static Optional<String> port = Optional.ofNullable(System.getenv("PORT"));
    
    @Inject
    private EventRepository eventRepository;

     public void main(@Observes ContainerInitialized event) throws IOException {

        var configuration = ServerConfiguration.builder().port(Integer.parseInt(port.orElse("8080"))).build();

        WebServer.create(configuration,Routing.builder().register(JsonSupport.create())
                        .post("/event", Handler.create(JsonObject.class, this::addEvent))
                        .get("/event", this::getEventsAll  ))
                        .start();
    }

    private void addEvent(ServerRequest req, ServerResponse res, JsonObject json) {

        var event = new Event(json.getString("name"), json.getString("description"), json.getString("speaker"));

        this.eventRepository.save(event);

        var builder = Json.createArrayBuilder();
        builder.add(new ResponseModel(res.status().code(), "Event Added Successfully!").forRest());
        
        res.send(builder.build());
    }

    private void getEventsAll(ServerRequest req, ServerResponse res) {

        var builder = Json.createArrayBuilder();
        eventRepository.findAll().forEach(data -> builder.add(data.forRest()));

        res.send(builder.build());
    }
}

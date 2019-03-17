package br.org.soujava.rio.helidon.main;

import java.io.IOException;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;

import org.apache.deltaspike.cdise.api.CdiContainerLoader;
import org.apache.deltaspike.core.api.provider.BeanProvider;

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

     public static void main(String[] args) throws IOException {

         var cdiContainer = CdiContainerLoader.getCdiContainer();
         cdiContainer.boot();

          var contextControl = cdiContainer.getContextControl();
          contextControl.startContext(ApplicationScoped.class);

          var eventRepository = BeanProvider.getContextualReference(EventRepository.class, false);

          var configuration = ServerConfiguration.builder().port(Integer.parseInt(port.orElse("8080"))).build();

        WebServer.create(configuration,Routing.builder().register(JsonBindingSupport.create())
 
                        .post("/events", Handler.create(Event.class, (req,res,events) -> {
                            eventRepository.save(events);
                            res.send(new ResponseModel(res.status().code(), "Evento salvo com Sucesso !"));
                        }))

                        .get("/events", (req,res) -> res.send(eventRepository.findAll())))
                        .start();
    }
}
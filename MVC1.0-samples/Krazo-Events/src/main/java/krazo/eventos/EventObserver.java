package krazo.eventos;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.mvc.event.AfterControllerEvent;
import javax.mvc.event.BeforeControllerEvent;
import javax.mvc.event.BeforeProcessViewEvent;

@ApplicationScoped
public class EventObserver {

    @Inject
    private MeuEvento meuEvento;

    public void onBeforeProcessView(@Observes BeforeProcessViewEvent e) {
        
        meuEvento.setView(e.getView());
        meuEvento.setEngine(e.getEngine());
    }

    public void onBeforeController(@Observes BeforeControllerEvent e) {
        System.out.println("URI: " + e.getUriInfo().getRequestUri());
    }

    public void onAfterController(@Observes AfterControllerEvent e) {
        System.out.println("Controller: " + e.getResourceInfo().getResourceMethod());
    }
}
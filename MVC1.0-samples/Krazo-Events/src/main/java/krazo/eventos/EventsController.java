package krazo.eventos;

import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.View;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Controller
@Path("mvc")
public class EventsController {

    @Inject
    private Models models;

    @GET
    @View("events.jsp")
    public void events() {
        this.models.put("events", "Meu evento");
    }
}
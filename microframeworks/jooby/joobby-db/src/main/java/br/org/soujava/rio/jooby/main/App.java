package br.org.soujava.rio.jooby.main;

import org.jooby.Jooby;
import org.jooby.hbm.Hbm;
import org.jooby.jdbc.Jdbc;
import org.jooby.json.Jackson;

import com.google.inject.Inject;

import br.org.soujava.rio.jooby.model.Event;
import br.org.soujava.rio.jooby.model.ResponseModel;
import br.org.soujava.rio.jooby.repository.EventServiceImpl;

public class App extends Jooby {

      @Inject
      EventServiceImpl service;
    
    {
        use(new Jackson());
        use(new Jdbc());
        use(new Hbm().classes(Event.class));

        get("/",(resq, res) -> {
            
            service.save(new Event("Lala","teste","teste"));
         
            res.send(new ResponseModel(1, "ok"));
        });
        
        get("/ola",()-> service.getAll());
    }

    public static void main (String[] args) {
        run(App::new, args);
    }
}
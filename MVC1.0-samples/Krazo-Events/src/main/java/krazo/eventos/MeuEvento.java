package krazo.eventos;

import javax.enterprise.inject.Model;
import javax.mvc.engine.ViewEngine;

@Model
public class MeuEvento {

    private String view;
    private Class<? extends ViewEngine> engine;

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public Class<? extends ViewEngine> getEngine() {
        return engine;
    }

    public void setEngine(Class<? extends ViewEngine> class1) {
        this.engine = class1;
    }
}
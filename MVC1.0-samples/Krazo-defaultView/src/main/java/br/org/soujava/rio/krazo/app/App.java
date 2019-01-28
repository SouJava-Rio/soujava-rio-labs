package br.org.soujava.rio.krazo.app;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.eclipse.krazo.Properties;

@ApplicationPath("app")
public class App extends Application {

    @Override
    public Map<String, Object> getProperties() {
        Map<String, Object> defaultViewExtension = new HashMap<>();
        defaultViewExtension.put(Properties.DEFAULT_VIEW_FILE_EXTENSION, "jsp");
        return defaultViewExtension;
    }
}
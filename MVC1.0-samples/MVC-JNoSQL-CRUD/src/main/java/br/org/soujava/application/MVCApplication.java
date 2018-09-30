package br.org.soujava.application;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.mvcspec.ozark.Properties;

@ApplicationPath("app")
public class MVCApplication extends Application { 

    @Override
    public Map<String, Object> getProperties() {
        final Map<String, Object> map = new HashMap<>();
        map.put(Properties.DEFAULT_VIEW_FILE_EXTENSION, "jsp");
        return map;
    }
}
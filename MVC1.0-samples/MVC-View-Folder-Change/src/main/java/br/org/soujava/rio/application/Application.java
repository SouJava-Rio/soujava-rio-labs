package br.org.soujava.rio.application;

import java.util.HashMap;
import java.util.Map;

import javax.mvc.engine.ViewEngine;
import javax.ws.rs.ApplicationPath;

/**
 * @author Daniel Dias
 * github:Daniel-Dos
 * twitter:@danieldiasjava
 */
@ApplicationPath("mvc")
public class Application extends javax.ws.rs.core.Application {

	@Override
    public Map<String, Object> getProperties() {
        final Map<String, Object> map = new HashMap<>();
        map.put(ViewEngine.VIEW_FOLDER, "/jsp/");       // overrides default /WEB-INF/
        return map;
    }
}
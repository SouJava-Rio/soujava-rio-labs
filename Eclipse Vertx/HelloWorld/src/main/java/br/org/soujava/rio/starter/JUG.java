package br.org.soujava.rio.starter;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class JUG implements Serializable {

    private static final long serialVersionUID = 1L;

    private String jug = "SouJava-Rio";
    private List<String> lideres = List.of("Daniel Dias","Paulo Simões","Ulisses Telemaco");
    
    public JUG(String jug, List<String> lideres) {
        this.jug = jug;
        this.lideres = lideres;
    }
    
    public JUG() { }

    public String getJug() {
        return jug;
    }

    public void setJug(String jug) {
        this.jug = jug;
    }

    public List<String> getLideres() {
        return lideres.stream()
                      .map(String::toUpperCase)
                      .collect(Collectors.toList());
    }

    public void setLideres(List<String> lideres) {
        this.lideres = lideres;
    }
}
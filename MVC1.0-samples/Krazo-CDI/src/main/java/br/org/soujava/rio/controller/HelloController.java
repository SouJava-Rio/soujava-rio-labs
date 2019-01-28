package br.org.soujava.rio.controller;

import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.View;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import br.org.soujava.rio.model.Pessoa;

@Controller
@Path("hello")
public class HelloController {

    @Inject 
    private Models models;  
    
    @Inject
    private Pessoa pessoa;

    @View("hello")
    @GET
    public void getHello() {
        this.models.put("nome","Daniel");
    }
    
    @View("hello")
    @Path("cdi")
    @GET
    public void getHelloCDI() {
    	this.pessoa.setNome("Daniel Dias");
    }
}
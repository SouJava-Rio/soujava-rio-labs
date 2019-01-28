package br.org.soujava.rio.controller;

import java.util.Arrays;
import java.util.List;

import javax.mvc.Controller;
import javax.mvc.View;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.org.soujava.rio.modelo.Pessoa;


@Path("hello")
public class HelloController {

    @Controller
    @View("hello.jsp")
    @GET
    public void getHello() {}

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("json")
    public Response getHelloJson() {
      return Response.ok().entity(new Pessoa("Daniel Dias", 27)).build();
    }
}

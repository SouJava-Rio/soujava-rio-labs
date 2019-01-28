package br.org.soujava.rio.krazo.controller;

import javax.mvc.Controller;
import javax.mvc.View;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Controller
@Path("Hello")
public class HelloController {

    @View("hello")
    @GET
    public void getHello() {}
}
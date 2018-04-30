package br.org.soujava.controller;

import javax.mvc.annotation.Controller;
import javax.mvc.annotation.View;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Controller
@Path("home")
public class HomeController {

	@GET
	@View("home.jsp")
	public void homePage() {}
}
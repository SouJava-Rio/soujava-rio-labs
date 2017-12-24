package br.org.soujava.rio.controller;

import javax.inject.Inject;
import javax.mvc.Models;
import javax.mvc.annotation.Controller;
import javax.mvc.annotation.View;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Controller
@Path("hello")
public class TomeeController {

	@Inject
	private Models models;

	@GET
	@View("hello.jsp")
	public void getHello(@QueryParam("name") String name) {
		this.models.put("hello",name);
	}
}
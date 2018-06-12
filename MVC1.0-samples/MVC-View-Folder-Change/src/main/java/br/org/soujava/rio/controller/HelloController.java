package br.org.soujava.rio.controller;

import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.View;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * @author Daniel Dias
 * github:Daniel-Dos
 * twitter:@danieldiasjava
 */

@Path("hello")
public class HelloController {

	@Inject
	private Models models;

	@Controller
	@GET
	@View("hello.jsp")
	public void getHello() {
		this.models.put("hello", "em uma nova pasta customizada.");
	}
}
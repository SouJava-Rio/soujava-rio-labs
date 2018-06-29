/*
 * The MIT License
 * Copyright © 2017 Daniel Dias
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package br.org.soujava.rio.controller;

import javax.inject.Inject;
import javax.mvc.Models;
import javax.mvc.Controller;
import javax.mvc.View;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * @author Daniel Dias
 * github:Daniel-Dos
 * daniel.dias@soujava.org.br
 * twitter:@danieldiasjava
 */
@Controller
@Path("template")
public class TemplateEngineController {

	@Inject
	private Models models;
	
	@GET
	@Path("jtwig")
	@View("resultado.twig.html")
	public void getJtwig() {
		this.models.put("jtwig", "Jtwig");
	}

	@GET
	@Path("groovy")
	@View("resultado.tpl")
	public void getGroovy() {
		this.models.put("groovy", "Groovy");
	}
	
	@GET
	@Path("jsp")
	@View("resultado.jsp")
	public void getJSP() {
		this.models.put("jsp", "JSP - Default");
	}

	@GET
	@Path("facelets")
	@View("resultado.xhtml")
	public void getFacelets() {
		this.models.put("jsf", "Facelets - Default");
	}

	@GET
	@Path("jetbrick")
	@View("resultado.jetx")
	public void getJetbrick() {
		this.models.put("jetbrick", "jetbrick");
	}

	@GET
	@Path("pebble")
	@View("resultado.peb")
	public void getPebble() {
		this.models.put("pebble", "pebble");
	}

	@GET
	@Path("thymeleaf")
	@View("resultado.html")
	public void getThymeleaf() {
		this.models.put("thymeleaf", "thymeleaf");
	}

	@GET
	@Path("velocity")
	@View("resultado.vm")
	public void getVelocity() {
		this.models.put("velocity", "Velocity");
	}

	@GET
	@Path("mustache")
	@View("resultado.mustache")
	public void getMustache() {
		this.models.put("mustache", "Mustache");
	}

	@GET
	@Path("jade")
	@View("resultado.jade")
	public void getJade() {
		this.models.put("titulo", "MVC-Template Engine");
		this.models.put("jade", "Jade");
	}

	@GET
	@Path("handlebars")
	@View("resultado.hbs")
	public void getHandlebars() {
		this.models.put("handlebars", "Handlebars");
	}

	@GET
	@Path("freemarker")
	@View("resultado.ftl")
	public void getFreemarker() {
		this.models.put("freemarker", "Freemarker");
	}

	@GET
	@Path("asciidoc")
	@View("resultado.adoc")
	public void getAsciiDoc() {
		this.models.put("adoc", "adoc - engine");
	}
}
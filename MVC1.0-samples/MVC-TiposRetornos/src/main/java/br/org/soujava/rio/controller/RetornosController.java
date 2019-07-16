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
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.View;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.eclipse.krazo.engine.Viewable;

/**
 * @author Daniel Dias
 * github:Daniel-Dos
 * daniel.dias@soujava.org.br
 * twitter:@danieldiasjava
 */
@Controller
@Path("retornos")
public class RetornosController {

	@Inject
	private Models models;

	@GET
	@View("retorno")
	@Path("void")
	public void getView() {
		this.models.put("retorno", "Retorno do tipo void usando @View");
	}

	@GET
	@Path("String")
	public String getString() {
		this.models.put("retorno", "Retorno do tipo String");
		return "retorno";
	}

	@GET
	@Path("Response")
	public Response getResponse() {
		this.models.put("retorno", "Retorno do Tipo Response do Jax-RS");
		return Response.status(Response.Status.OK).entity("retorno").build();
	}

	@GET
	@Path("ViewAble")
	public Viewable getViewAble() {
		this.models.put("retorno", "Retorno do Tipo Viewable,especifico da RI Krazo");
		return new Viewable("retorno");
	}
}
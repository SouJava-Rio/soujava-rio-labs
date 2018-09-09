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
package br.org.soujava.rio.microprofile.helidon.resources;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.config.inject.ConfigProperty;

/**
 * @author <a href="mailto:daniel.dias@soujava.org.br">Daniel Dias</a>
 * github:Daniel-Dos
 * twitter:@danieldiasjava
 */
@Path("JUG")
@Produces(MediaType.APPLICATION_JSON)
public class JugService {

	@Inject
	@ConfigProperty(name = "jug.nome")
	private String jugNome;

	@Inject
	@ConfigProperty(name = "jug.leaders")
	private String jugLeaders;

	@Inject
	@ConfigProperty(name = "jug.descricao")
	private String descricao;	

	@GET
	public Response getJUG() {

		JsonObject json = Json.createObjectBuilder()
				.add("Jug", jugNome)
				.add("Lideres", jugLeaders)
				.add("Descrição", descricao)
				.build();

		String resultado = json.toString();

		return Response.ok().entity(resultado).build();
	}
}

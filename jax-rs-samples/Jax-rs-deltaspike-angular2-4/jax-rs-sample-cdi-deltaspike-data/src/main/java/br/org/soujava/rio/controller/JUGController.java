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

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.org.soujava.rio.model.JUG;
import br.org.soujava.rio.model.ResponseModel;
import br.org.soujava.rio.repository.JUGRepository;

/**
 * @author Daniel Dias
 * github:Daniel-Dos
 * daniel.dias@soujava.org.br
 * twitter:@danieldiasjava
 */
@Path("jug")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class JUGController {

	@Inject
	private JUGRepository jugRepository;

	@POST
	@Path("/cadastrar")
	public Response cadastrarJUG(JUG jug) {
		try {
			jugRepository.save(jug);
			return Response.ok().entity(new ResponseModel(1,"JUG Adicionada Com Sucesso!")).build();	
		} catch (Exception e) {
			return Response.ok().entity(new ResponseModel(0,e.getMessage())).build();
		}
	}
	
	@PUT
	@Path("/editar")
	public Response editarJUG(JUG jug) {
		try {
			jugRepository.save(jug);
			return Response.ok().entity(new ResponseModel(1, "JUG Atualizada Com Sucesso!")).build();	
		} catch (Exception e) {
			return Response.ok().entity(new ResponseModel(0,e.getMessage())).build();
		}
	}
	
	@GET
	@Path("consultar/{codigo}")
	public Response consultarJUG(@PathParam("codigo") Long codigo) {
		JUG jug = this.jugRepository.findBy(codigo);
		return Response.ok().entity(jug).build();
	}

	@GET
	public List<JUG> getJUGS() {
		return jugRepository.findAll();
	}

	@DELETE
	@Path("deletar/{codigo}")
	public Response removerJUG(@PathParam("codigo") Long codigo) {
		try {
			JUG jug = this.jugRepository.findBy(codigo);
			jugRepository.remove(jug);
			return Response.ok().entity(new ResponseModel(1, "JUG excluida com Sucesso!")).build();
		} catch (Exception e) {
			return Response.ok().entity(new ResponseModel(0,e.getMessage())).build();
		}
	}
}
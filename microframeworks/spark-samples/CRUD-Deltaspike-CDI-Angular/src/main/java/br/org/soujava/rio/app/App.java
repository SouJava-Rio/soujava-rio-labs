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
package br.org.soujava.rio.app;

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.path;
import static spark.Spark.port;
import static spark.Spark.post;
import static spark.Spark.put;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.json.bind.Jsonb;

import org.jboss.weld.environment.se.events.ContainerInitialized;

import br.org.soujava.rio.filter.cors.CorsFilter;
import br.org.soujava.rio.model.JUG;
import br.org.soujava.rio.model.ResponseModel;
import br.org.soujava.rio.repository.JUGRepository;
import br.org.soujava.rio.transformer.JsonTransformer;

/**
 * @author Daniel Dias 
 * github:Daniel-Dos 
 * daniel.dias@soujava.org.br
 * twitter:@danieldiasjava
 */

public class App {

	@Inject
	private JUGRepository jugRepository;

	@Inject
	private JsonTransformer jsonTransformer;

	@Inject
	private Jsonb jsonb;

	public void main(@Observes ContainerInitialized event) {

		port(8080);
		CorsFilter.enableCORS();

		path("api/", () -> {

			post("cadastrar", (req, res) -> {
				try {
					res.type("application/json");
					JUG jug = jsonb.fromJson(req.body(), JUG.class);
					jugRepository.save(jug);
					return new ResponseModel(1, "JUG Adicionada Com Sucesso!");
				} catch (Exception e) {
					return new ResponseModel(0, e.getMessage());
				}
			}, jsonTransformer);

			get("consultar", (req, res) -> {
				res.type("application/json");
				return jugRepository.findAll();
			}, jsonTransformer);

			get("consultar/:codigo", (req, res) -> {
				res.type("application/json");
				String codigo = req.params("codigo");
				Long id = Long.valueOf(codigo);
				JUG jug = jugRepository.findBy(id);
				return jug;
			}, jsonTransformer);

			put("editar", (req, res) -> {
				try {
					res.type("application/json");
					JUG jug = jsonb.fromJson(req.body(), JUG.class);
					jugRepository.save(jug);
					return new ResponseModel(1, "JUG Atualizada Com Sucesso!");
				} catch (Exception e) {
					return new ResponseModel(0, e.getMessage());
				}
			}, jsonTransformer);

			delete("deletar/:codigo", (req, res) -> {
				try {
					res.type("application/json");
					String codigo = req.params("codigo");
					Long id = Long.valueOf(codigo);
					JUG jug = jugRepository.findBy(id);
					jugRepository.remove(jug);
					return new ResponseModel(1, "JUG excluida com Sucesso!");
				} catch (Exception e) {
					return new ResponseModel(0, e.getMessage());
				}
			}, jsonTransformer);
		});
	}
}
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
package br.org.soujava.rio.micronaut.controller;

import java.util.Arrays;

import br.org.soujava.rio.micronaut.model.JUG;
import br.org.soujava.rio.micronaut.model.Lideres;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

/**
 * @author Daniel Dias
 * github:Daniel-Dos
 * twitter:@danieldiasjava
 */

@Controller("/hello")
public class HelloController {

	@Get("/")
	public HttpResponse helloWorld() {
		var jug = new JUG();
		var lideres = new Lideres();
		var lideres2 = new Lideres();
		var lideres3 = new Lideres();
		
		lideres.setNome("Daniel Dias");
		lideres.setGithub("https://github.com/daniel-dos");
		lideres2.setNome("Paulo");
		lideres2.setGithub("https://github.com/pasimoes");
		lideres3.setNome("Ulisses");
		lideres3.setGithub("https://github.com/utelemaco");
		
		var listaLideres = Arrays.asList(lideres,lideres2,lideres3);

		jug.setLideres(listaLideres);
		
		return HttpResponse.ok().body(jug);
	}
}
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
package br.org.soujava.rio.javaconfig;

import java.util.List;

import javax.config.inject.ConfigProperty;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;

import org.jboss.weld.environment.se.events.ContainerInitialized;

/**
 * @author Daniel Dias
 * github:Daniel-Dos
 * daniel.dias@soujava.org.br
 * twitter:@danieldiasjava
 */

public class JavaConfiguration {

	@Inject
	@ConfigProperty(name="org.jug.nome", defaultValue="SouJava")
	private String nomeJug;
	
	@Inject
	@ConfigProperty(name="org.jug.site.url", defaultValue="http://soujava.or.br")
	private String siteURL;
	
	@Inject
	@ConfigProperty(name="org.jug.reuniao.mes", defaultValue="0")
	private int reuniaoMes;
	
	@Inject
	@ConfigProperty(name="org.jug.membros.quant", defaultValue="8")
	private int quanMembros;

	public void main(@Observes ContainerInitialized event) {
		
		var jsonbConfig = new JsonbConfig().withFormatting(true);
		var jsonB = JsonbBuilder.create(jsonbConfig);
		
		var JugConfig = List.of(nomeJug, siteURL, reuniaoMes, quanMembros);
		
		System.out.println(jsonB.toJson(JugConfig));
	} 
}
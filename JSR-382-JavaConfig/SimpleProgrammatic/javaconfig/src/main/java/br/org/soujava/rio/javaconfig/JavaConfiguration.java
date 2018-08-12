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

import javax.config.Config;
import javax.config.ConfigProvider;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;

/**
 * @author Daniel Dias 
 * github:Daniel-Dos 
 * daniel.dias@soujava.org.br
 * twitter:@danieldiasjava
 */
public class JavaConfiguration {
	public static void main(String[] args) {

		Config config = ConfigProvider.getConfig();
		
		var jsonbConfig = new JsonbConfig().withFormatting(true);
		var jsonB = JsonbBuilder.create(jsonbConfig);

		var nomeJug = config.getValue("org.jug.nome", String.class);
		var siteURL = config.getValue("org.jug.site.url", String.class);
		var reuniaoMes = config.getValue("org.jug.reuniao.mes", Integer.class);
		var quanMembro = config.getValue("org.jug.membros.quant", Integer.class);
		
		var  JUGConfig = List.of(nomeJug, siteURL, reuniaoMes,quanMembro);
		
		var output = jsonB.toJson(JUGConfig);

		System.out.println(output);
	}
}
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
package br.org.soujava.rio.micronaut.model;

import java.util.List;

/**
 * @author Daniel Dias
 * github:Daniel-Dos
 * daniel.dias@soujava.org.br
 * twitter:@danieldiasjava
 */
public class JUG {
	
	public JUG() {}

	public JUG(List<Lideres> lideres, String nomeJug, String mensagem) {
		super();
		this.lideres = lideres;
		this.nomeJug = nomeJug;
		this.mensagem = mensagem;
	}

	private List<Lideres> lideres = List.of(new Lideres());
	private String nomeJug = "SouJava - Rio";
	private String mensagem = "Fortalencendo a Comunidade Java Brasileira.";

	public List<Lideres> getLideres() {
		return lideres;
	}

	public void setLideres(List<Lideres> lideres) {
		this.lideres = lideres;
	}

	public String getNomeJug() {
		return nomeJug;
	}

	public void setNomeJug(String nomeJug) {
		this.nomeJug = nomeJug;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	@Override
	public String toString() {
		return "JUG [lideres=" + lideres + ", nomeJug=" + nomeJug + ", mensagem=" + mensagem + "]";
	}
}
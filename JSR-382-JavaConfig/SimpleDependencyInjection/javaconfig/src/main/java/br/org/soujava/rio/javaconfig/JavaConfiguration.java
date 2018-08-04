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

import java.util.Optional;
import java.util.logging.Logger;

import javax.config.inject.ConfigProperty;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.jboss.weld.environment.se.events.ContainerInitialized;

/**
 * @author Daniel Dias
 * github:Daniel-Dos
 * daniel.dias@soujava.org.br
 * twitter:@danieldiasjava
 */

public class JavaConfiguration {

	@Inject
	@ConfigProperty(name="org.jug.name", defaultValue="SouJava-Rio")
	private String nomeJug;
	
	@Inject
	@ConfigProperty(name="org.jug.members.number", defaultValue="0")
	private Optional<Integer> membersNumber;

	@Inject
	@ConfigProperty(name="org.jug.reunion.month", defaultValue="1")
	private javax.inject.Provider<Long> reunionMonth;

	public void main(@Observes ContainerInitialized event) {
		
		System.out.println("Nome da JUG " + nomeJug);
		System.out.println("Numero de membros  " + membersNumber);
		System.out.println("Reunião por mes " + reunionMonth.get());
	} 
}
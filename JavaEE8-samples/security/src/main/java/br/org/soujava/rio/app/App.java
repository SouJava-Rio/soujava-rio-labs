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

import java.util.HashSet;
import java.util.Set;

import javax.annotation.security.DeclareRoles;
import javax.security.enterprise.authentication.mechanism.http.BasicAuthenticationMechanismDefinition;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.glassfish.soteria.identitystores.annotation.Credentials;
import org.glassfish.soteria.identitystores.annotation.EmbeddedIdentityStoreDefinition;

import br.org.soujava.rio.controller.HelloController;

/**
 * @author Daniel Dias
 * github:Daniel-Dos
 * daniel.dias@soujava.org.br
 * twitter:@danieldiasjava
 */
@BasicAuthenticationMechanismDefinition(realmName = "My App")
@EmbeddedIdentityStoreDefinition({ 
    @Credentials(callerName = "duke", password = "dance", groups = { "user"})}
)
@DeclareRoles({"user","admin"})
@ApplicationPath("resources")
public class App extends Application { 

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> clazzes = new HashSet<>();
		clazzes.add(HelloController.class);
		return clazzes;
	}
}
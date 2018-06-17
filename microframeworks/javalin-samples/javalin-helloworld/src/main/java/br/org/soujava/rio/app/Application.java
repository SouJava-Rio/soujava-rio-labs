package br.org.soujava.rio.app;

import java.util.List;
import lombok.var;

import br.org.soujava.rio.model.JUG;
import io.javalin.Javalin;

public class Application {
	public static void main(String[] args) {

		Javalin javalin = Javalin.start(8080);
		
		var nome = "SouJava Rio";
		var lideres = List.of("Daniel Dias","Paulo Simões", "Ulisses Telemaco");
		
		javalin.get("/", ctx -> ctx.result(new JUG(nome,lideres).toString()));
	}
}
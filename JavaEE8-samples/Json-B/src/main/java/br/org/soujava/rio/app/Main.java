package br.org.soujava.rio.app;

import java.util.Arrays;
import java.util.List;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;

import br.org.soujava.rio.model.JUG;
import br.org.soujava.rio.model.Localidade;

/**
 * @author Daniel Dias
 * github:Daniel-Dos
 * daniel.dias@soujava.org.br
 * twitter:@danieldiasjava
 */
public class Main {
	public static void main(String[] args) {

	JsonbConfig jsonbConfig = new JsonbConfig().withFormatting(true);
	Jsonb jsonb = JsonbBuilder.create(jsonbConfig);

	System.out.println("Serializando a Classe");

	List<String> leaders = Arrays.asList("Daniel Dias", "Paulo Simões", "Ulisses Telemaco");

	JUG jug = JUG.builder()
				 .nome("SouJava-Rio")
				 .leaders(leaders)
				 .descricao("Comunidade Java do Rio")
				 .localidade(new Localidade("RJ", "Brasil"))
				 .build();

	String serializado = jsonb.toJson(jug);
	System.out.println(serializado);

	System.out.println("Deserializar a Classe");

	JUG jugDeserializar = jsonb.fromJson(serializado, JUG.class);
	System.out.println("\n" + jugDeserializar);

	}
}

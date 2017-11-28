package br.org.soujava.rio.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Daniel Dias
 * github:Daniel-Dos
 * daniel.dias@soujava.org.br
 * twitter:@danieldiasjava
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JUG {

	private String nome;
	private List<String> leaders;
	private String descricao;
	private Localidade localidade;
}
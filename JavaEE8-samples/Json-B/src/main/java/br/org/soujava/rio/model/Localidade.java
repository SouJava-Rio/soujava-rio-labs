package br.org.soujava.rio.model;

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
public class Localidade {

	private String estado;
	private String pais;
}
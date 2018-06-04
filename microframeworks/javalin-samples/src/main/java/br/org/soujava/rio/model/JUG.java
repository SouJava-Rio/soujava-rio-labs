package br.org.soujava.rio.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JUG {

	private String nome;
	private List<String> lideres;
}

package br.org.rio.soujava.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Imagem
 * 
 * @author arruda
 *
 */
@Entity
@Table(name = "IMAGES")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Image implements Serializable{

	//https://docs.jboss.org/hibernate/orm/5.0/mappingGuide/en-US/html_single/#identifiers-generators
	//6.3.5. Using UUID generation
	//https://en.wikipedia.org/wiki/Universally_unique_identifier
	@Id
	@GeneratedValue( generator="uuid" )
	@GenericGenerator(
			name="uuid",
			strategy="org.hibernate.id.UUIDGenerator",
			parameters = {
					@Parameter(
							name="uuid_gen_strategy_class",
							value="org.hibernate.id.uuid.CustomVersionOneStrategy"
					)
			}
	)
	public UUID id;
	private String title;
	private int orderNumber;
	private LocalDateTime created;
}

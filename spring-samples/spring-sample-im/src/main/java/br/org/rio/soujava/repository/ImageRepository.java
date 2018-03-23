package br.org.rio.soujava.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.rio.soujava.domain.Image;

/**
 * Repositório de {@link Image}
 * 
 * @author arruda
 *
 */
@Repository
public interface ImageRepository extends JpaRepository<Image, UUID>{
	
}

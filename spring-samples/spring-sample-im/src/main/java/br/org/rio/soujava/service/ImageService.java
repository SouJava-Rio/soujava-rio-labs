package br.org.rio.soujava.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;

import javax.annotation.PostConstruct;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import br.org.rio.soujava.config.StorageProperties;
import br.org.rio.soujava.domain.Image;
import br.org.rio.soujava.exception.StorageException;
import br.org.rio.soujava.repository.ImageRepository;
import lombok.RequiredArgsConstructor;

/**
 * Serviço de manutenção de {@link Image}
 * 
 * @author arruda
 *
 */
//Cria construtor com imageRepository
@RequiredArgsConstructor
@Service
public class ImageService {
	
	private static final int START_PAGE = 0;
	private static final int TOTAL_ITEMS_PER_PAGE = 10;
	
	//Injetando dependência pelo construtor
	private final ImageRepository imageRepository;
	private final StorageProperties properties;
	private Path rootLocation;
	
	@PostConstruct
	public void doPostConstruct(){
		 this.rootLocation = Paths.get(properties.getLocation());
	}
	
	@Transactional(readOnly = true)
    public Page<Image> findAll(Integer pageNumber) {
		
		PageRequest pageable = PageRequest.of(
				(pageNumber == null) ? START_PAGE : pageNumber, TOTAL_ITEMS_PER_PAGE);
		
        return imageRepository.findAll(pageable);
    }
       
	public void saveImage(MultipartFile file){
		
	      String filename = StringUtils.cleanPath(file.getOriginalFilename());
	      
	        try {
	        	
	            if (file.isEmpty()) {
	                throw new StorageException("Failed to store empty file " + filename);
	            }
	            
	            if (filename.contains("..")) {
	                // This is a security check
	                throw new StorageException(
	                        "Cannot store file with relative path outside current directory "
	                                + filename);
	            }

	            final Image image = Image.builder()
				        		.title(filename)
				        		.orderNumber(0)
				        		.created(LocalDateTime.now())
				        		.build();
	            
	            imageRepository.save(image);
	            
	            Files.copy(file.getInputStream(), this.rootLocation.resolve(image.getId().toString()),
	                    StandardCopyOption.REPLACE_EXISTING);
	            
	        }catch (IOException e) {
	            throw new StorageException("Failed to store file " + filename, e);
	        }
	}
	
    public Path load(String filename) {
        return rootLocation.resolve(filename);
    }

    public Resource loadAsResource(String filename) {
        try {
            Path file = load(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            }
            else {
                throw new StorageException(
                        "Could not read file: " + filename);

            }
        }
        catch (MalformedURLException e) {
            throw new StorageException("Could not read file: " + filename);
        }
    }

}

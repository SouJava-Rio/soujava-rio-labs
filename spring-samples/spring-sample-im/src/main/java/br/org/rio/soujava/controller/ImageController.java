package br.org.rio.soujava.controller;

import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.org.rio.soujava.domain.Image;
import br.org.rio.soujava.service.ImageService;
import lombok.RequiredArgsConstructor;

/**
 * Controle para operações com {@link Image}
 * 
 * @author arruda
 *
 */
@RequiredArgsConstructor
@Controller
@RequestMapping("/images")
public class ImageController {

	private final ImageService imageService;

	@RequestMapping(value = { "", "/" })
	public String root(Model model) {

		Page<Image> page = imageService.findAll(0);

		int current = page.getNumber() + 1;
		int begin = Math.max(1, current - 5);
		int end = Math.min(begin + 10, page.getTotalPages());

		model.addAttribute("images", page);
		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", end);
		model.addAttribute("currentIndex", current);

		return "images";
	}

	@GetMapping(value = "/pages/{pageNumber}")
	public String getAllImages(@PathVariable Integer pageNumber, Model model) {

		Page<Image> page = imageService.findAll(pageNumber);

		int current = page.getNumber() + 1;
		int begin = Math.max(1, current - 5);
		int end = Math.min(begin + 10, page.getTotalPages());

		model.addAttribute("deploymentLog", page);
		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", end);
		model.addAttribute("currentIndex", current);

		return "images";
	}

	@GetMapping(value="/thumb/{imageId:.+}", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@PathVariable String imageId) {

		Resource file = imageService.loadAsResource(imageId);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file);
	}

	@PostMapping("/upload")
	public String handleFileUpload(@RequestParam("imagem") MultipartFile file, RedirectAttributes redirectAttributes) {

		imageService.saveImage(file);

		redirectAttributes.addFlashAttribute("message",
				"You successfully uploaded " + file.getOriginalFilename() + "!");

		return "redirect:/images";
	}
}

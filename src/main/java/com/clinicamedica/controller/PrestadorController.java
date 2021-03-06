package com.clinicamedica.controller;

import java.awt.image.BufferedImage;
import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import org.springframework.core.io.Resource;

import com.clinicamedica.dto.DesativarPrestadorDTO;
import com.clinicamedica.dto.PrestadorDTO;
import com.clinicamedica.entity.FileUploadFileResponse;
import com.clinicamedica.file.FileStorageService;
import com.clinicamedica.file.ImageService;
import com.clinicamedica.service.PrestadorService;
import com.google.common.net.HttpHeaders;

import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@RestController
@RequestMapping(value = "/api-prestador")
public class PrestadorController {
	
	@Autowired
	private static final Logger log = LoggerFactory.getLogger(MedicoController.class);
	
	@Autowired
	private PrestadorService proxyPrestador;
		
	@Autowired
	private ImageService imageService;
	
	@Autowired
	private FileStorageService fileStorageService;
	
	@GetMapping(value = "/busca-todos-usuario")
	public ResponseEntity<?> buscaPrestadoresService() {
		log.info("Iniciando controller busca-todos-usuario");
		List<PrestadorDTO> lista = proxyPrestador.buscaPrestadoresService();
		return new ResponseEntity<>(lista,HttpStatus.OK);
	}

	@GetMapping(value = "/buscaId/{id}")
	public ResponseEntity<?> buscarPorIDService(@PathVariable int id) {
		log.info("iniciando controller metodo buscarPorIDService busca por id");
		return new ResponseEntity<>(proxyPrestador.buscarPorIDService(id),HttpStatus.OK);
	}

	@PostMapping(value = "/inserir-prestador")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> inserirPrestador(@RequestBody PrestadorDTO obj) {
		log.info("iniciando controller metodo inserirPrestador");
		if (obj != null) {
			proxyPrestador.InserirPrestadorService(obj);
			return new ResponseEntity<>("Usu??rio cadastrad com sucesso!!",HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping(value = "/upodate-prestador")
	public ResponseEntity<?> updatePrestador(@RequestBody PrestadorDTO obj) {
		log.info("Iniciando controller de alterar prestador upodate-prestador");
		proxyPrestador.alterarPrestadorService(obj);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/delete-prestador")
	public ResponseEntity<?> deletePrestador(@RequestBody PrestadorDTO obj) {
		log.info("Deletando usuario da base");
		proxyPrestador.deletePrestadorService(obj);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(value = "/buscarPrestadorLogin/{login}")
	public ResponseEntity<?> buscarPrestadorANDLogin(@PathVariable String login){
		log.info("iniciando a busca por login na tabela de login");
		return new ResponseEntity<>(proxyPrestador.buscaPrestadorLoginService(login),HttpStatus.OK);
	}
	 
	
	@PostMapping(value = "/prestador-upload-arquivo")
	public ResponseEntity<?> uploadPrestadorFile(@RequestParam(name="file") MultipartFile file){
		URI uri = proxyPrestador.uploadPrestador(file);
		String url = uri.toString();
		return new ResponseEntity<>(url,HttpStatus.CREATED);
	}
	
	@PostMapping(value = "/prestador-upload-arquivo-img")
	public ResponseEntity<?> uploadPrestadorFileImg(@RequestParam(name="file") MultipartFile file){
		URI uri = proxyPrestador.uploadPrestadorImgHTML(file);
		String url = uri.toString();
		return new ResponseEntity<>(url,HttpStatus.CREATED);
	}
	
	@PostMapping(value="/prestador-upload-arquivo-format/{id}")
	public ResponseEntity<?> uploadPrestadorFileFormat(@RequestParam(name="file") MultipartFile file,@PathVariable int id){
		URI uri = proxyPrestador.uploadPrestadorFormat(file, id); 
		return new ResponseEntity<>(uri,HttpStatus.CREATED);
	}
	
	@PostMapping(value = "/desativar-prestador")
	public ResponseEntity<?> DesativarPrestador(@RequestBody DesativarPrestadorDTO dto){
		log.info("iniciando o processo de  desativar prestador");
		proxyPrestador.DesativarPrestadorService(dto.getFlag(),dto.getId());
		return new ResponseEntity<>("OK",HttpStatus.CREATED);
	}
	
	/*
	 * @PostMapping(value = "/Inserir-prestador-jpa") public ResponseEntity<?>
	 * InserirPrestadorJPA(@RequestBody PrestadorDTO obj){
	 * log.info("iniciando o processo de inserir-prestador-JPA");
	 * proxyPrestador.InserirPrestadorJPA(obj); return new
	 * ResponseEntity<>("OK Inserir",HttpStatus.CREATED); }
	 */
	
	@PostMapping("/uploadFile")
	public FileUploadFileResponse uploadFile(@RequestParam("file") MultipartFile file){
		String fileName = fileStorageService.storeFile(file);
		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("/api-prestador/downloadFile/")
				.path(fileName)
				.toUriString();
		
		return new FileUploadFileResponse(fileName, fileDownloadUri, file.getContentType(),file.getSize());
	}
	
	@PostMapping("/uploadFiles")
	public  List<FileUploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files){
		return Arrays.asList(files)
				.stream()
				.map(f -> uploadFile(f))
				.collect(Collectors.toList());
	}
	
	@GetMapping("/downloadFile/{fileName:.+}")
	public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request){
		
		Resource resource = fileStorageService.loadfileasResource(fileName);
		String contentType = null;
		
		try {
			contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
		} catch (Exception e) {
			log.info("N??o consegui determina o arquivo");
		}
		
		if(contentType == null) {
			contentType = "application/octet-stream";
		}
		
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(contentType))
				.header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\"" + resource.getFilename() + "\"")
				.body(resource);
		
	}
	

}

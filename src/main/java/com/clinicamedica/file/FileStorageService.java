package com.clinicamedica.file;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.Files;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.clinicamedica.config.FileStorageCofig;
import com.clinicamedica.exception.FileStorageException;
import com.clinicamedica.exception.MyFileNotFoundException;

import org.springframework.util.StringUtils;

@Service
public class FileStorageService {

	private final Path filestorageLocation;
	
	@Value("${path.file.clinica}")
	private String pathFile;
	
	public String getPathFile() {
		return pathFile;
	}

	public FileStorageService(FileStorageCofig fileStorageConfig) {

		this.filestorageLocation = Paths.get(fileStorageConfig.getUploadDir()).toAbsolutePath().normalize();

		try {
			Files.createDirectories(filestorageLocation);
		} catch (Exception e) {
			throw new FileStorageException("Não encontrado o caminho", e);
		}

	}

	public String storeFile(MultipartFile file) {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());

		try {
			if (fileName.contains("..")) {
				throw new FileStorageException("Arquivo com sequencia invalida" + fileName.toString());
			}

			Path targetLocation = this.filestorageLocation.resolve(fileName);
			Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
			return fileName;
		} catch (Exception e) {
			throw new FileStorageException("Deu erro no arquivo nome : " + fileName, e);
		}
	}

	public Resource loadfileasResource(String fileName) {

		try {
			Path filePath = this.filestorageLocation.resolve(fileName).normalize();
			Resource resource = new UrlResource(filePath.toUri());
			if (resource.exists()) {
				return resource;
			} else {
				throw new MyFileNotFoundException("Arquivo não existe");
			}
		} catch (Exception e) {
			throw new MyFileNotFoundException("Arquivo não existe 2", e);
		}

	}

}

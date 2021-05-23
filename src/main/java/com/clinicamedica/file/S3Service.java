package com.clinicamedica.file;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.clinicamedica.exception.FileException;

@Service
public class S3Service {

	private Logger LOG = LoggerFactory.getLogger(S3Service.class);
	
	@Autowired
	private AmazonS3 s3client;
	
	@Value("${s3.bucket}")
	private String bucketName;
	
	public URI uploadFile(MultipartFile multipartFile) {
		try {
			 LOG.info("iniciando o upload");
			 String filename = multipartFile.getOriginalFilename();
			 InputStream is = multipartFile.getInputStream();
			 String contentType = multipartFile.getContentType();
			 return uploadFile(is, filename, contentType);
		} catch (IOException e) {
			LOG.info("Erro : "+e.getMessage());
			throw new  FileException("Erro de io: " + e.getMessage());
		}
	}
	
	public URI uploadFile(InputStream is, String filename, String contentType) {
		try {
			ObjectMetadata meta = new ObjectMetadata();
			meta.setContentType(contentType);
			LOG.info("iniciando o upload");
			s3client.putObject(bucketName, filename, is, meta);
			LOG.info("finalizando upload");
			return  s3client.getUrl(bucketName, filename).toURI();
		} 
		catch (URISyntaxException e) {
			throw new FileException("Erro ao converter URL em URI");
		}
	}
}

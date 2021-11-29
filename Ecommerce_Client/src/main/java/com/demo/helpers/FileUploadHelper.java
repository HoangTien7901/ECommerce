package com.demo.helpers;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadHelper {

	public static String upload(MultipartFile multipartFile, ServletContext servletContext) {
		try {
			String fileName = generateFileName(multipartFile.getOriginalFilename());
			byte[] bytes = multipartFile.getBytes();
			Path path = Paths.get(servletContext.getRealPath("/uploads/images/" + fileName));
			Files.write(path, bytes);
			return fileName;
		} catch (Exception e) {
			return null;
		}
	}
	
	public static String uploads(MultipartFile[] multipartFiles, ServletContext servletContext) {
		try {
			for(MultipartFile multipartFile : multipartFiles) {
				String fileName = generateFileName(multipartFile.getOriginalFilename());
				byte[] bytes = multipartFile.getBytes();
				Path path = Paths.get(servletContext.getRealPath("/uploads/images/" + fileName));
				Files.write(path, bytes);
			}
			return "OK";
		} catch (Exception e) {
			return null;
		}
	}
	
	private static String generateFilename(String filename) {
		String name = UUID.randomUUID().toString().replace("-", "");
		int index = filename.lastIndexOf(".");
		String ext = filename.substring(index);
		return name + ext;
	}
}

package com.project.control;


import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtill {
	
	public static void saveFile(String uploadDir,MultipartFile multipartFile,String fileName) throws Exception {
		Path uploadPath=Paths.get(uploadDir); 
		
		   if(!Files.exists(uploadPath)) {			   
			   Files.createDirectories(uploadPath);
		   }
		  try {
			  InputStream inputStream=multipartFile.getInputStream();
			  Path filePath=uploadPath.resolve(fileName);
			  System.out.println(filePath.toFile().getAbsolutePath());
			  Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
		} catch (Exception e) {
			throw new Exception("dosya bulunamadi"+fileName);
		} 
		  
	}

}

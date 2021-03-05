package com.springbatch.springbatchdemo.service;

import javax.annotation.Resource;

import org.springframework.web.multipart.MultipartFile;
import java.nio.file.Path;
import java.util.stream.Stream;

public interface FilesStorageService {
	
	//  public void init();

	  public void save(MultipartFile file);

	  public org.springframework.core.io.Resource load(String filename);

	 // public void deleteAll();

	  public Stream<Path> loadAll();

}

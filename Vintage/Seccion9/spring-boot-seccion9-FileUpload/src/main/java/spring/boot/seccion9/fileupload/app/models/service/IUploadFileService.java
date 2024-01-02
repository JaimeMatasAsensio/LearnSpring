package spring.boot.seccion9.fileupload.app.models.service;

import java.io.IOException;
import java.net.MalformedURLException;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface IUploadFileService {
	
	public Resource load(String fileName) throws MalformedURLException;
	
	public String copy(MultipartFile file)  throws IOException;
	
	public Boolean delete(String fileName);
	
	public void deleteAll();
	
	public void init() throws IOException;
}

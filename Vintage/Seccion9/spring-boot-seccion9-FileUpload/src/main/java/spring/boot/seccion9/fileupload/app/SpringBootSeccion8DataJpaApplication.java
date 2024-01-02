package spring.boot.seccion9.fileupload.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import spring.boot.seccion9.fileupload.app.models.service.IUploadFileService;

@SpringBootApplication
public class SpringBootSeccion8DataJpaApplication implements CommandLineRunner {
	
	@Autowired
	IUploadFileService uploadFileService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootSeccion8DataJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		uploadFileService.deleteAll();
		uploadFileService.init();
		
	}

}

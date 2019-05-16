package br.com.isoftware.rrsite.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.isoftware.rrsite.model.File;
import br.com.isoftware.rrsite.service.FileService;

/**
 * Created by @author olivanaires on 12/05/2019.
 */
@RestController
@RequestMapping("/api/file")
public class FileController {

	@Autowired
	private FileService fileService;

	@PostMapping(value = "/upload")
	@PreAuthorize("hasRole('ADMIN')")
	public void handleFileUpload(@RequestParam("file") MultipartFile file) throws IOException {
		
		fileService.storeFile(file);
	}
	
	@GetMapping("/download/{fileId}")
	@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Resource> download(@PathVariable Long fileId) {
        File dbFile = fileService.getFile(fileId);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(dbFile.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getFileName() + "\"")
                .body(new ByteArrayResource(dbFile.getData()));
    }
	
	@GetMapping("/load/{fileId}")
    public File load(@PathVariable Long fileId) {
        File dbFile = fileService.getFile(fileId);

        return dbFile;
    }
	
	@GetMapping("/loadAll")
    public List<File> loadAll() {
        return fileService.getAllBanners();
    }

}

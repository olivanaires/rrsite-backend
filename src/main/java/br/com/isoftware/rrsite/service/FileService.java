package br.com.isoftware.rrsite.service;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import br.com.isoftware.rrsite.exception.AppException;
import br.com.isoftware.rrsite.model.File;
import br.com.isoftware.rrsite.model.enums.FileType;
import br.com.isoftware.rrsite.repository.FileRepository;

/**
 * Created by @author olivanaires on 12/05/2019.
 */
@Service
public class FileService {
	
	@Autowired
	private FileRepository fileRepository;
	
	public void storeFile(MultipartFile file) {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		System.out.println(fileName);
		try {
			if (fileName.contains("..")) {
				throw new AppException("Sorry! Filename contains invalid path sequence " + fileName);
			}

			File dbFile = new File(fileName, file.getContentType(), FileType.BANNER, file.getBytes());

			fileRepository.save(dbFile);
		} catch (IOException ex) {
			throw new AppException("Could not store file " + fileName + ". Please try again!", ex);
		}
	}

	public File getFile(Long fileId) {
		return fileRepository.findById(fileId).orElseThrow(() -> new AppException("File not found with id " + fileId.toString()));
	}
	
	public List<File> getAll() {
		return fileRepository.findAll();
	}
	
	@Transactional
	public List<File> getAllBanners() {
		return fileRepository.findByType(FileType.BANNER);
	}

}

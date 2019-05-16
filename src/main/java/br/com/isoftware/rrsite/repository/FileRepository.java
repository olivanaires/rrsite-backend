package br.com.isoftware.rrsite.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.isoftware.rrsite.model.File;
import br.com.isoftware.rrsite.model.enums.FileType;

/**
 * Created by @author olivanaires on 12/05/2019.
 */
@Repository
public interface FileRepository extends JpaRepository<File, Long> {
	
	List<File> findByType(FileType fileType);
	
}

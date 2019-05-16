package br.com.isoftware.rrsite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.isoftware.rrsite.model.PropertyPhoto;

/**
 * Created by @author olivanaires on 14/05/2019.
 */
@Repository
public interface PropertyPhotoRepository extends JpaRepository<PropertyPhoto, Long> {

}

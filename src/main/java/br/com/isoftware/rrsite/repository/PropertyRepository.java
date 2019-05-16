package br.com.isoftware.rrsite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.isoftware.rrsite.model.Property;

/**
 * Created by @author olivanaires on 14/05/2019.
 */
@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {

}

package br.com.isoftware.rrsite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.isoftware.rrsite.model.City;

/**
 * Created by @author olivanaires on 21/05/2019.
 */
@Repository
public interface CityRepository extends JpaRepository<City, Long> {

}

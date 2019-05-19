package br.com.isoftware.rrsite.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.isoftware.rrsite.model.Client;

/**
 * Created by @author olivanaires on 17/05/2019.
 */
public interface ClientRepository extends JpaRepository<Client, Long> {

}

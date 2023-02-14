package cm.cti.cinema.serviceutulisateurs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import cm.cti.cinema.serviceutulisateurs.models.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> { 
	

}


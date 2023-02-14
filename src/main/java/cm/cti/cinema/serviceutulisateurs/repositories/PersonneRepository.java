package cm.cti.cinema.serviceutulisateurs.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cm.cti.cinema.serviceutulisateurs.models.Personne;


@Repository
public interface PersonneRepository extends JpaRepository<Personne, Long> {
	List<Personne> findByEmail(String email);
	List<Personne> findByNom(String nom);
	List<Personne> findByPrenom(String prenom);
	

}

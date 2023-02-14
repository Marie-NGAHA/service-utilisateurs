package cm.cti.cinema.serviceutulisateurs.controleurs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cm.cti.cinema.serviceutulisateurs.models.Client;
import cm.cti.cinema.serviceutulisateurs.models.Personne;
import cm.cti.cinema.serviceutulisateurs.repositories.ClientRepository;
import cm.cti.cinema.serviceutulisateurs.repositories.PersonneRepository;

@RestController
@RequestMapping(value = "api/personne")

public class personneControleurs {
	@Autowired
	private PersonneRepository personneRequestory;
	
	@GetMapping("nom/{nom}")
	public List<Personne>  findBynom(
			@PathVariable("nom") String nom) {
		return personneRequestory.findByNom(nom);
	}
	
	@GetMapping("prenom/{prenom}")
	public List<Personne>  findByprenom(
			@PathVariable("prenom") String prenom) {
		return personneRequestory.findByPrenom(prenom);
	}
	
	@GetMapping("email/{email}")
	public List<Personne>  findByemail(
			@PathVariable("email") String email) {
		return personneRequestory.findByEmail(email);
	}
	
	
	
	

}

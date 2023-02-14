package cm.cti.cinema.serviceutulisateurs.controleurs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cm.cti.cinema.serviceutulisateurs.models.Administrateurs;
import cm.cti.cinema.serviceutulisateurs.repositories.AdministrateursRepository;
import cm.cti.cinema.serviceutulisateurs.repositories.PersonneRepository;

@RestController
@RequestMapping(value = "api/administrateurs")
public class AdministrateursControleurs {
	
	@Autowired
	private AdministrateursRepository administrateursRequestory;
	@Autowired
	private PersonneRepository personneRepository;
	
	@GetMapping("/all")
	public List<Administrateurs> findALLAdmin2(){
		return administrateursRequestory.findAll();
	}
	
	
	@PostMapping
	public Administrateurs create(
			@RequestBody Administrateurs administrateurs) {
		administrateurs.setId(null);
		
		if(administrateurs.getPersonne().getNom().length() < 4)return null;
		if(personneRepository.findByEmail(administrateurs.getPersonne().getEmail()).size() > 0) return null;
		
		administrateursRequestory.save(administrateurs);
		return administrateurs ;
		
		
	}
	@GetMapping("/{id}")
	public Administrateurs findById(
			@PathVariable("id") Long id) {
		return administrateursRequestory.findById(id).get();
	}
	
	@DeleteMapping("/{id}")
	public String delete(
			@PathVariable("id") Long id) {
		Administrateurs administrateurs = administrateursRequestory.findById(id).get();
		administrateursRequestory.delete(administrateurs);
		return "OK" ;
	}
	
	@PutMapping
	public Administrateurs update(
			@RequestBody Administrateurs administrateurs) {
		
		if(administrateurs.getPersonne().getNom().length() < 4)return null;
		
		Administrateurs administrateurs2 = administrateursRequestory.findById(administrateurs.getId()).get();
		
		administrateurs2.getPersonne().setNom(administrateurs .getPersonne().getNom());
		administrateurs2.getPersonne().setPrenom(administrateurs .getPersonne().getPrenom());
		administrateurs2.getPersonne().setEmail(administrateurs .getPersonne().getEmail());
		administrateurs2.getPersonne().setTel(administrateurs .getPersonne().getTel());
		
		administrateursRequestory.save(administrateurs2);
		return administrateurs2;
		
		
	}
	
	

}

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
import cm.cti.cinema.serviceutulisateurs.models.Client;
import cm.cti.cinema.serviceutulisateurs.repositories.AdministrateursRepository;
import cm.cti.cinema.serviceutulisateurs.repositories.ClientRepository;

@RestController
@RequestMapping(value = "api/client")

public class ClientControleurs {
	@Autowired
	private ClientRepository clientRequestory;
	
	@GetMapping("/all")
	public List<Client> findALLclient(){
		return clientRequestory.findAll();
	}
	
	@PostMapping
	public Client create(
			@RequestBody Client client) {
		client.setId(null);
		
		if(client.getPersonne().getNom().length() < 4)return null;
		clientRequestory.save(client);
		return client ;
		
	}
	
	@GetMapping("/{id}")
	public Client  findById(
			@PathVariable("id") Long id) {
		return clientRequestory.findById(id).get();
	}
	
	@DeleteMapping("/{id}")
	public String delete(
			@PathVariable("id") Long id) {
		Client  client = clientRequestory.findById(id).get();
		clientRequestory.delete(client);
		return "OK" ;
	}
	
	@PutMapping
	public Client  update(
			@RequestBody Client  client) {
		
		if(client.getPersonne().getNom().length() < 4)return null;
		
		Client client2 = clientRequestory.findById(client.getId()).get();
		
		client2.getPersonne().setNom(client .getPersonne().getNom());
		client2.getPersonne().setPrenom(client .getPersonne().getPrenom());
		client2.getPersonne().setEmail(client .getPersonne().getEmail());
		client2.getPersonne().setTel(client .getPersonne().getTel());
		
		clientRequestory.save(client2);
		return client2;
		
		
	}
	
	
	 

	
	
	
	
	
	
}

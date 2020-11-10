package prod.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import prod.entities.Personne;
import prod.repositories.PersonneRepository;


@RestController
@RequestMapping("/api")
public class PersonneController {


	@Autowired
	private PersonneRepository personneRepository;
	
	@GetMapping("/personnes")
	public List<Personne> getPersonnes()
	{
		return personneRepository.findAll();
	}
	
	@GetMapping("/personne/{id}")
	public Personne getPersonne(@PathVariable Long id)
	{
		return personneRepository.findById(id).get();
	}
	
	
	@DeleteMapping("/personne/{id}")
	public boolean deletePersonne(@PathVariable Long id)
	{
		personneRepository.deleteById(id);
		return true;
	}
	@PutMapping("/personne/{id}")
	public Personne updatePersonne(Personne personne)
	{
		return personneRepository.save(personne);
	}

	@PostMapping("/personne/{id}")
	public Personne createPersonne(Personne personne)
	{
		return personneRepository.save(personne);
	}



	@RequestMapping("/getusersofsuite")
	public List<Personne> getusersofsuite( int x) 
	{
		return personneRepository.getusersofsuite(x);
	}

}

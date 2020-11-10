package prod.controllers;

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

import prod.entities.Pluie;
import prod.repositories.PluieRepository;


@RestController
@RequestMapping("/api/pluies")
public class PluieController {


	@Autowired
	private PluieRepository pluieRepository;
	
	@GetMapping("/All")
	public List<Pluie> getpluies()
	{
		return pluieRepository.findAll();
	}
	
	@GetMapping("/getOne/{id}")
	public Pluie getpluie(@PathVariable int id)
	{
		return pluieRepository.findById(id).get();
	}
	
	
	@DeleteMapping("/delete/{id}")
	public boolean deletepluie(@PathVariable int id)
	{
		pluieRepository.deleteById(id);
		return true;
	}
	@PutMapping("/update")
	public Pluie updatepluie(@RequestBody Pluie pluie)
	{
		return pluieRepository.save(pluie);
	}

	@PostMapping("/add")
	public Pluie createpluie(@RequestBody Pluie pluie)
	{
		return pluieRepository.save(pluie);
	}


	@GetMapping("/get_mois.info")
	public List<?> getMoisInfo() 
	{
		return pluieRepository.getMoisInfo();
	} 
	

	@GetMapping("/get_pluie.info3")
	public List<?> getPluieInfo3()
	{
		return pluieRepository.getPluieInfo3();
	} 
	

	@GetMapping("/get_pluie.info4")
	public List<?> getPluieInfo4()
	{
		return pluieRepository.getPluieInfo4();
	} 


}

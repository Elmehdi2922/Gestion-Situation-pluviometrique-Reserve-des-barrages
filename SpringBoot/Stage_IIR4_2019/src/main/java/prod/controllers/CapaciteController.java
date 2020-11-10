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

import prod.entities.Capacite; 
import prod.repositories.CapaciteRepository;


@RestController
@RequestMapping("/api/capacites")
public class CapaciteController {


	@Autowired
	private CapaciteRepository capaciteRepository;
	
	@GetMapping("/All")
	public List<Capacite> getCapacites()
	{
		return capaciteRepository.findAll();
	}
	
	@GetMapping("/getOne/{id}")
	public Capacite getCapacite(@PathVariable int id)
	{
		return capaciteRepository.findById(id).get();
	}
	
	
	@DeleteMapping("/delete/{id}")
	public boolean deleteCapacite(@PathVariable int id)
	{
		capaciteRepository.deleteById(id);
		return true;
	}
	@PutMapping("/update")
	public Capacite updateCapacite(@RequestBody Capacite capacite)
	{
		return capaciteRepository.save(capacite);
	}

	@PostMapping("/add")
	public Capacite createCapacite(@RequestBody Capacite capacite)
	{
		return capaciteRepository.save(capacite);
	}

	@GetMapping("/get_ann-prec.info")
	public List<?> getAnnPrecInfo()
	{
		return capaciteRepository.getAnnPrecInfo();
	} 

	@GetMapping("/get_aujour.info")
	public List<?> getAujourInfo()
	{
		return capaciteRepository.getAujourInfo();
	} 

	@GetMapping("/get_aujour.info2")
	public List<?> getAujourInfo2()
	{
		return capaciteRepository.getAujourInfo2();
	} 
	
	@GetMapping("/get_aujour.info3")
	public List<?> getAujourInfo3()
	{
		return capaciteRepository.getAujourInfo3();
	} 

	@GetMapping("/get_aujour.info4")
	public List<?> getAujourInfo4()
	{
		return capaciteRepository.getAujourInfo4();
	} 
	
	@GetMapping("/get_aujour.info5")
	public List<?> getAujourInfo5()
	{
		return capaciteRepository.getAujourInfo5();
	} 
	

	@GetMapping("/get_aujour-bar.info")
	public List<?> getAujourBarInfo() 
	{
		return capaciteRepository.getAujourBarInfo();
	} 


	@GetMapping("/get_aujour-bar.info2")
	public List<?> getAujourBarInfo2() 
	{
		return capaciteRepository.getAujourBarInfo2();
	} 

	@GetMapping("/get_aujour-bar.info4")
	public List<?> getAujourBarInfo4() 
	{
		return capaciteRepository.getAujourBarInfo4();
	} 

	@GetMapping("/get_barrages.info2")
	public List<?> getBarragesInfo2() 
	{
		return capaciteRepository.getBarragesInfo2();
	} 


	@GetMapping("/get_barrages.info3")
	public List<?>  getBarragesInfo3() 
	{
		return capaciteRepository.getBarragesInfo3();
	} 


	@GetMapping("/get_hier.info")
	public List<?> getHierInfo() 
	{
		return capaciteRepository.getHierInfo();
	} 

	

	
}

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

import prod.entities.Barrage;
import prod.repositories.BarrageRepository;


@RestController
@RequestMapping("/api/barrages")
public class BarrageController {


	@Autowired
	private BarrageRepository barrageRepository;
	
	@GetMapping("/All")
	public List<Barrage> getBarrages()
	{
		return barrageRepository.findAll();
	}
	
	@GetMapping("/getOne/{id}")
	public Barrage getBarrage(@PathVariable int id)
	{
		return barrageRepository.findById(id).get();
	}
	
	
	@DeleteMapping("/delete/{id}")
	public boolean deleteBarrage(@PathVariable int id)
	{
		barrageRepository.deleteById(id);
		return true;
	}
	
	@PutMapping("/update")
	public Barrage updatebarrage(@RequestBody Barrage barrage)
	{
		return barrageRepository.save(barrage);
	}

	@PostMapping("/add")
	public Barrage createbarrage(@RequestBody Barrage barrage)
	{
		return barrageRepository.save(barrage);
	} 
	
	

 
	
}

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

import prod.entities.Sbassin;
import prod.repositories.SbassinRepository;


@RestController
@RequestMapping("/api/sbassins")
public class SbassinController {


	@Autowired
	private SbassinRepository sbassinRepository;
	
	@GetMapping("/All")
	public List<Sbassin> getsbassins()
	{
		return sbassinRepository.findAll();
	}
	
	@GetMapping("/getOne/{id}")
	public Sbassin getSbassin(@PathVariable int id)
	{
		return sbassinRepository.findById(id).get();
	}
	
	
	@DeleteMapping("/delete/{id}")
	public boolean deletesbassin(@PathVariable int id)
	{
		sbassinRepository.deleteById(id);
		return true;
	}
	@PutMapping("/update")
	public Sbassin updatesbassin(@RequestBody Sbassin sbassin)
	{
		return sbassinRepository.save(sbassin);
	}

	@PostMapping("/add")
	public Sbassin createsbassin(@RequestBody Sbassin sbassin)
	{
		return sbassinRepository.save(sbassin);
	}

	@GetMapping("/get_sbassin.info2")
	public List<?> getSbassinInfo2() 
	{
		return sbassinRepository.getSbassinInfo2();
	} 
	
	
	@GetMapping("/get_sbassin.info3")
	public List<?> getSbassinInfo3() 
	{
		return sbassinRepository.getSbassinInfo3();
	} 
	
	@GetMapping("/get_sbassinbyprovince.info")
	public List<?> getSbassinByProvinceInfo() 
	{
		return sbassinRepository.getSbassinByProvinceInfo();
	} 

}

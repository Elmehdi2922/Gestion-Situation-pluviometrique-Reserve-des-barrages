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

import prod.entities.Province;
import prod.repositories.ProvinceRepository;


@RestController
@RequestMapping("/api/provinces")
public class ProvinceController {


	@Autowired
	private ProvinceRepository provinceRepository;
	
	@GetMapping("/All")
	public List<Province> getProvinces()
	{		
		return provinceRepository.findAll();
	}
	
	@GetMapping("/getOne/{id}")
	public Province getprovince(@PathVariable Long id)
	{
		return provinceRepository.findById(id).get();
	}
	
	
	@DeleteMapping("/delete/{id}")
	public boolean deleteprovince(@PathVariable long id)
	{
		provinceRepository.deleteById(id);
		return true;
	}
	@PutMapping("/update")
	public Province updateprovince(@RequestBody Province province)
	{
		return provinceRepository.save(province);
	}

	@PostMapping("/add")
	public Province createprovince(@RequestBody Province province)
	{
		return provinceRepository.save(province);
	}

	@GetMapping("/get_province.info")
	public List<?> getProvinceInfo()
	{
		return provinceRepository.getProvinceInfo();
	} 

	@GetMapping("/get_sbassin.info4")
	public List<?> getSbassinInfo4() 
	{
		return provinceRepository.getSbassinInfo4();
	} 

	@GetMapping("/get_sbassinbyprovince.info/{id}")
	public List<?> getSbassinByProvinceInfo(@PathVariable int id) 
	{
		return provinceRepository.getSbassinByProvinceInfo(id);
	} 


}

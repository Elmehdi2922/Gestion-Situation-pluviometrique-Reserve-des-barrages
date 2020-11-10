package prod.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import prod.entities.Admin;
import prod.repositories.AdminRepository;


@RestController

public class AdminController {


	@Autowired
	private AdminRepository adminRepository;
	@RequestMapping("/api/user")
	public Principal user(Principal user)
	{
		return user;
	}
	
	
	@GetMapping("/admins")
	public List<Admin> getAdmins()
	{
		return adminRepository.findAll();
	}
	
	@RequestMapping("/getadmin")
	public Admin getAdmin(int id)
	{
		return adminRepository.findById(id).get();
	}
	
	
	@RequestMapping("/deleteadmin")
	public boolean deleteAdmin(int id)
	{
		adminRepository.deleteById(id);
		return true;
	}
	@RequestMapping("/updateadmin")
	public Admin updateAdmin(Admin admin)
	{
		return adminRepository.save(admin);
	}

	@RequestMapping("/saveadmin")
	public Admin createAdmin(Admin admin)
	{
		return adminRepository.save(admin);
	}


 

 
	
}

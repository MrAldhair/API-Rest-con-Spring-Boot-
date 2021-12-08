package api.sales.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import api.sales.models.BranchOffice;
import api.sales.services.ServiceBranchOfficeImplement;

@RestController
public class BranchOfficeController {
	
	@Autowired
	private ServiceBranchOfficeImplement serviceBranchOfficeImplement;
	
	@GetMapping("/ListBranchOffice")
	public List<BranchOffice> listar(){
		
		return serviceBranchOfficeImplement.findAll();
		
	}
	
	@GetMapping("/ver/{id}")
	public BranchOffice ver(@PathVariable Long id) {
		
		return serviceBranchOfficeImplement.findById(id);
		
	}

}

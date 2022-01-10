package api.sales.controllers;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import api.sales.models.Sale;
import api.sales.services.IServiceBranchOffice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.sales.models.BranchOffice;
import api.sales.services.ServiceBranchOfficeImplement;

@RestController
//@RequestMapping("/api/")
public class BranchOfficeController {
	
	@Autowired
	private IServiceBranchOffice serviceBranchOffice;
	
	@GetMapping("/ListBranchOffice")
	@Transactional(readOnly = true)
	public ResponseEntity<?> listar(){
		//Manejo de excepciones
		List<BranchOffice> branchOffice;
		Map<String, Object> response = new HashMap<>();

		try {
			branchOffice = serviceBranchOffice.findAll();
		} catch (DataAccessException e){
			response.put("msg","Error en al consulta de la DB");
			response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		//Alamacenar los objetos/valores asociados a un nombre
		//Map(interfaz)/HashMap(implementacion)
		if (branchOffice.isEmpty()) {
			response.put("msg","No existen registros de sucursales");
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
		}


		return new ResponseEntity<List<BranchOffice>>(branchOffice, HttpStatus.OK);

		//return serviceBranchOffice.findAll();
	}
	
	@GetMapping("/ListBranchOffice/{id}")
	@Transactional(readOnly = true)
	public ResponseEntity<?> ver(@PathVariable Long id) {
		//Manejo de excepciones
		BranchOffice branchOffice = null;
		Map<String, Object> response = new HashMap<>();

		try {
			branchOffice = serviceBranchOffice.findById(id);
		} catch (DataAccessException e){
			response.put("msg","Error en al consulta de la DB");
			response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		//Alamacenar los objetos/valores asociados a un nombre
		//Map(interfaz)/HashMap(implementacion)
		if (branchOffice == null) {
			response.put("msg","La sucursal: ".concat(id.toString().concat(" no existe!!")));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<BranchOffice>(branchOffice, HttpStatus.OK);
	}
		
		//return serviceBranchOfficeImplement.findById(id);
		
	}



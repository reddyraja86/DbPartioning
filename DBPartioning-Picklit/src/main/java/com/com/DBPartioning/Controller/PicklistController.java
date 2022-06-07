package com.com.DBPartioning.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.com.DBPartioning.repositories.PicklistRepository;
import com.com.DBPartioning.testme.Definition;
import com.com.DBPartioning.testme.DefinitionPK;

@RestController
public class PicklistController {
	
	@Autowired
	PicklistRepository picklistRepository;
	
	@GetMapping(path = "/test")
	public void testMe() {
		System.out.println("=============");
	}
	
	@GetMapping(path = "/picklist/all")
	public void getAllPicklists() {
		
		//picklistRepository.save(null)
		
		
		System.out.println(picklistRepository.findAll());
		
		List<Definition> listDef = picklistRepository.findAll();
		
		listDef.forEach((definiton) -> System.out.println(definiton.getName()));
		
		listDef.stream().forEach((defin) -> defin.getPicklistValues().forEach((val) -> System.out.println( val.getValue())));	
		
	}
	
	@GetMapping(path = "/picklist/{id}/{tenant}")
	public Optional<Definition> getPicklistDefByIdAndTenant(@PathVariable(value = "id") String id ,@PathVariable(value = "tenant")String tenant) {
		System.out.println(tenant+"==="+id);
		DefinitionPK pk =new  DefinitionPK();
		pk.setId(Integer.parseInt(id));
		pk.setScopeid(tenant);
		return picklistRepository.findById(pk);
	}

}

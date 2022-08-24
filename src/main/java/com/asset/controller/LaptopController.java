package com.asset.controller;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.asset.entity.LaptopEntity;
import com.asset.exceptions.BadRequestException;
import com.asset.exceptions.NotFoundException;
import com.asset.service.LaptopServiceInterface;
@Transactional
@CrossOrigin
@RestController
public class LaptopController {
	@Autowired
	LaptopServiceInterface laptopServiceInterface;
	
	
	@GetMapping("/showalllaptops")
	public List<LaptopEntity> getAllLaptops() throws NotFoundException {
		return laptopServiceInterface.getAllLaptops();
	}
	
	
	//-----------------------------------------------------
	
	@PostMapping("/addlaptop") 
	public LaptopEntity addLaptop(@RequestBody LaptopEntity l) {
		return laptopServiceInterface.addLaptop(l);
	}
	
	
	//-------------------------------------------------------
	
	
	@DeleteMapping("/deletelaptop/{gGID}") 
	public String deleteLaptop(@PathVariable("gGID") int ggid) throws NotFoundException {
		laptopServiceInterface.deleteLaptop(ggid);
		return "Deleted Successfully";
	}
	
	@DeleteMapping("/deletelaptopsn/{serialNumber}") 
	public String deleteLaptopBySerialNumber(@PathVariable("serialNumber") String n) throws BadRequestException {
		laptopServiceInterface.deleteLaptopBySerialNumber(n);
		return "Deleted Successfully";
	}
	
	
	//----------------------------------------------------------
	
	
	@PutMapping("/updatelaptop/{gGID}") 
	public LaptopEntity updateLaptopByGgid(@PathVariable("gGID") int n, @RequestBody LaptopEntity l) {
		return laptopServiceInterface.updateLaptopByGgid(n,l );
	}
	
	@PutMapping("/updatelaptopsn/{serialNumber}") 
	public LaptopEntity updateLaptop(@PathVariable("serialNumber") String n, @RequestBody LaptopEntity l) {
		return laptopServiceInterface.updateLaptop(n,l );
	}
	
	//---------------------------------------------------
		@GetMapping("/laptop/{gGID}")
		public LaptopEntity getLaptopByGgid(@PathVariable("gGID") int ggid) throws NotFoundException {

			return laptopServiceInterface.getLaptopByGgid(ggid);
		}

	
	  @GetMapping("/laptopsn/{serialNumber}")
	  public LaptopEntity getLaptopBySerialNumber(@PathVariable("serialNumber") String name) throws BadRequestException {
	   return laptopServiceInterface.getLaptopBySerialNumber(name); 
	   }
	  
	  
	  
	
}

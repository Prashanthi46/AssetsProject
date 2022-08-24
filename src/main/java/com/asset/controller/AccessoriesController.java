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

import com.asset.entity.AccessoriesEntity;
import com.asset.exceptions.BadRequestException;
import com.asset.exceptions.NotFoundException;
import com.asset.service.AccessoriesServiceInterface;

@Transactional
@CrossOrigin
@RestController
public class AccessoriesController {

	@Autowired
	AccessoriesServiceInterface accessoriesServiceInterface;
	
	    @GetMapping("/showallaccessories") 
	    public List<AccessoriesEntity> getAllAccessories() throws NotFoundException {
        return accessoriesServiceInterface.getAllAccessories();
	    }
	
	
	 //-------------------------------------------------------
	    
	   @PostMapping("/addaccessories") 
	   public AccessoriesEntity addAccessories(@RequestBody AccessoriesEntity a) {
       return accessoriesServiceInterface.addAccessories(a);
	   }
	   
	 //---------------------------------------------------
		
		@PutMapping("/updateaccessoriessn/{serialNumber}")
	    public AccessoriesEntity updateAccessories(@PathVariable("serialNumber") String name,@RequestBody AccessoriesEntity a) {
	    return accessoriesServiceInterface.updateAccessories(name,a);
			
		}
		@PutMapping("/updateaccessories/{gGID}")
	    public AccessoriesEntity updateAccessoriesByGgid(@PathVariable("gGID") int name,@RequestBody AccessoriesEntity a) {
		return accessoriesServiceInterface.updateAccessoriesByGgid(name,a);
			
		}
		
	 //------------------------------------------------------
	

	   @DeleteMapping("/deleteaccessoriessn/{serialNumber}")
	   public String deleteAccessories(@PathVariable("serialNumber") String n)throws BadRequestException{
	   accessoriesServiceInterface.deleteAccessories(n);
	   return "Removed";
	   }
	
	   @DeleteMapping("/deleteaccessories/{gGID}")
	   public String deleteAccessoriesByGgid(@PathVariable("gGID") int n)throws NotFoundException{
	   accessoriesServiceInterface.deleteAccessoriesByGgid(n);
	   return "Removed";
	   }
	   
	//----------------------------------------------------
	
	
		@GetMapping("/accessoriessn/{serialNumber}") 
		public AccessoriesEntity getAccessoriesBySerialNumber(@PathVariable("serialNumber") String name) throws BadRequestException {
	    return accessoriesServiceInterface.getAccessoriesBySerialNumber(name);
		}

		@GetMapping("/accessories/{gGID}") 
		public AccessoriesEntity getAccessoriesByGgid(@PathVariable("gGID") int name) throws NotFoundException {
	    return accessoriesServiceInterface.getAccessoriesByGgid(name);
		}

		/*
		 * 
		 * @GetMapping("/accessoriescount/{assettype}") public List<AccessoriesEntity>
		 * getAccessoriescount(@PathVariable("assettype") String name) { return
		 * accessoriesServiceInterface.getAccessoriescount(name); }
		 */
		
		}
		
		
		
		
		
		



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
import com.asset.entity.MobileEntity;
import com.asset.exceptions.BadRequestException;
import com.asset.exceptions.NotFoundException;
import com.asset.service.MobileServiceInterface;
@Transactional
@CrossOrigin
@RestController
public class MobileController {
	@Autowired
	MobileServiceInterface mobileServiceInterface;

	@GetMapping("/showallmobiles")
	public List<MobileEntity> getAllMobiles() throws NotFoundException {
		return mobileServiceInterface.getAllMobiles();
	}

	// ----------------------------------------------------

	@PostMapping("/addmobile")
	public MobileEntity addMobile(@RequestBody MobileEntity m) {
		return mobileServiceInterface.addMobile(m);
	}

	// -----------------------------------------------



	@PutMapping("/updatemobile/{gGID}")
	public MobileEntity updateMobileByGgid(@PathVariable("gGID") int n, @RequestBody MobileEntity m) {
		return mobileServiceInterface.updateMobileByGgid(n, m);
	}


	@PutMapping("/updatemobilesn/{serialNumber}")
	public MobileEntity updateMobile(@PathVariable("serialNumber") String n, @RequestBody MobileEntity m) {
		return mobileServiceInterface.updateMobile(n, m);
	}

	  //-----------------------------------------------
	  
	  @DeleteMapping("/deletemobilesn/{serialNumber}") 
	  public String deleteMobileBySerialNumber(@PathVariable("serialNumber") String n)throws BadRequestException{
	  mobileServiceInterface.deleteMobileBySerialNumber(n);
	  return "Removed";
	  }
	 
	  @DeleteMapping("/deletemobile/{gGID}") 
	  public String deleteMobile(@PathVariable("gGID") int n)throws NotFoundException{
	  mobileServiceInterface.deleteMobile(n);
	  return "Removed";
	  }
	 
	// -------------------------------------------
	@GetMapping("/mobile/{gGID}")
	public MobileEntity getMobileByGgid(@PathVariable("gGID") int n) throws NotFoundException {
		return mobileServiceInterface.getMobileByGgid(n);
	}

	
	  @GetMapping("/mobilesn/{serialNumber}") 
	  public MobileEntity getMobileBySerialNumber(@PathVariable("serialNumber") String name) throws BadRequestException { 
	  return mobileServiceInterface.getMobileBySerialNumber(name);
	  }
	  
	
}
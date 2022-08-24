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
import com.asset.entity.DesktopEntity;
import com.asset.exceptions.BadRequestException;
import com.asset.exceptions.NotFoundException;
import com.asset.service.DesktopServiceInterface;

@Transactional
@CrossOrigin
@RestController
public class DesktopController {
	
	@Autowired
	DesktopServiceInterface desktopServiceInterface;
	
	@GetMapping("/showAllDesktops") 
	public List<DesktopEntity> getAllDesktops() throws NotFoundException {
    return desktopServiceInterface.getAllDesktops();
	}
	
	//-------------------------------------------------------
		@PostMapping("/adddesktop") 
		public DesktopEntity addDesktop(@RequestBody DesktopEntity l) {
	    return desktopServiceInterface.addDesktop(l);
		}
	//---------------------------------------------------
	
		
	  
	  @PutMapping("/updatedesktop/{gGID}") 
		public DesktopEntity updateDesktopByGgid(@PathVariable("gGID") int n, @RequestBody DesktopEntity d) {
			return desktopServiceInterface.updateDesktopByGgid(n, d);
		}

	  
	  @PutMapping("/updatedesktopsn/{serialNumber}") 
		public DesktopEntity updateDesktop(@PathVariable("serialNumber") String name, @RequestBody DesktopEntity d) {
			return desktopServiceInterface.updateDesktop(name, d);
		}
		  //-------------------------------------------------------
		  

	  @DeleteMapping("/deletedesktopsn/{serialNumber}")
	  public String deleteDesktop(@PathVariable("serialNumber") String n)throws BadRequestException{
	  desktopServiceInterface.deleteDesktop(n);
	  return "Removed"; }
	 
			
	  
			  @DeleteMapping("/deletedesktop/{gGID}") public String
			  deleteDesktopByGgid(@PathVariable("gGID") int n)throws NotFoundException{
			  desktopServiceInterface.deleteDesktopByGgid(n); return "Removed"; }
			 
		  //-------------------------------------------------------
		  
		  
		  
		 
	@GetMapping("/desktop/{gGID}") 
	public DesktopEntity getDesktopByGgid(@PathVariable("gGID")int n) throws NotFoundException {
    return desktopServiceInterface.getDesktopByGgid(n);
	}
	
	
	  
	  @GetMapping("/desktopsn/{serialNumber}") 
	  public DesktopEntity getDesktopBySerialNumber(@PathVariable("serialNumber") String name) throws BadRequestException {
		  return desktopServiceInterface.getDesktopBySerialNumber(name); }
	  
	 
	  
	   

}

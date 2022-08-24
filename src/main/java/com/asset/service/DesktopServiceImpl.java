package com.asset.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asset.controller.AccessoriesController;
import com.asset.entity.DesktopEntity;
import com.asset.exceptions.BadRequestException;
import com.asset.exceptions.NotFoundException;
import com.asset.repository.DesktopRepository;
@Service
public class DesktopServiceImpl implements DesktopServiceInterface {
	@Autowired
	DesktopRepository desktopRepo;
	Logger logger = LoggerFactory.getLogger(AccessoriesController.class);

	
	  //View All details of desktops
	   @Override
	   public List<DesktopEntity> getAllDesktops() throws NotFoundException {
       List<DesktopEntity> m =desktopRepo.findAll();
       long total=m.stream().count(); 
       int count1=0;
       for(int i=0;i<total;i++) {
       // System.out.println(ls.get(i).getStatus());
       if(m.get(i).getStatus().equals("Allocated")) {
       count1=count1+1;}
       }
       System.out.println("Allocated: "+count1);  
       int count2=0;
       for(int i=0;i<total;i++) {
       // System.out.println(ls.get(i).getStatus());
       if(m.get(i).getStatus().equals("Surrendered")) {
       count2=count2+1;}
       }
       System.out.println("Surrendered: "+count2);  
       int count3=0;
       for(int i=0;i<total;i++) {
       // System.out.println(ls.get(i).getStatus());
       if(m.get(i).getStatus().equals("Surrendered To ODC")) {
       count3=count3+1;}
       }
       System.out.println("Surrendered To ODC: "+count3);
       int count4=0;
       for(int i=0;i<total;i++) {
       // System.out.println(ls.get(i).getStatus());
       if(m.get(i).getStatus().equals("Not Applicable")) {
       count4=count4+1;}
       }
       System.out.println("Not Applicable: "+count4);
       int count5=0;
       for(int i=0;i<total;i++) {
       // System.out.println(ls.get(i).getStatus());
       if(m.get(i).getStatus().equals("Available")) {
       count5=count5+1;}
       }
       System.out.println("Available: "+count5);
       int count6=0;
       for(int i=0;i<total;i++) {
       // System.out.println(ls.get(i).getStatus());
       if(m.get(i).getStatus().equals("Transferred")) {
       count6=count6+1;}
       }
       System.out.println("Transferred: "+count6);
       int count7=0;
       for(int i=0;i<total;i++) {
       // System.out.println(ls.get(i).getStatus());
       if(m.get(i).getStatus().equals("Not Surrendered")) {
       count7=count7+1;}
       }
       System.out.println("Not Surrendered: "+count7);
	   if (m.isEmpty()) {
	   logger.error("No desktops in Database");
	   throw new NotFoundException("no desktops found");}
	   logger.info("Fetch all desktops details from the database");
	   return desktopRepo.findAll();
	   }
	
	   //------------------------------------------------------
	 
	   //Add a new desktops
	   @Override
	   public DesktopEntity addDesktop(DesktopEntity d) {
	   logger.info("Successfully created");
	   return desktopRepo.save(d);}
	
	   //------------------------------------------------------------
	    
	    //update the desktops by its id
		@Override
	    public DesktopEntity updateDesktopByGgid(int n, DesktopEntity d) {
	 	d.setgGID(n);
		logger.info("Updated Successfully");
		return desktopRepo.save(d);}

		
	    //update the desktops by its serialNumber
        @Override
	    public DesktopEntity updateDesktop(String name, DesktopEntity d) {
		d.setSerialNumber(name);
		logger.info("Updated Successfully");
		return desktopRepo.save(d);}

	    //------------------------------------------------------------
        //delete desktops by its id
	    @Override public String deleteDesktopByGgid(int n)throws NotFoundException{
	    Optional<DesktopEntity> m = desktopRepo.findBygGID(n); 
	    if(!m.isPresent()){
	    logger.error("There is no desktop with the id {} to delete", n);
	    throw new NotFoundException("no desktops found with this id!!");  }
	    desktopRepo.deleteBygGID(n);
		logger.info("Successfully deleted the desktop with id {}", n);
	    return"Deleted Successfully";   }
	 
	    
        //delete desktops by its serialNumber
	    @Override public String deleteDesktop(String n)throws BadRequestException{
	    Optional<DesktopEntity> m = desktopRepo.findBySerialNumber(n); 
	    if(!m.isPresent()){
	    logger.error("There is no desktop with the serialnumber {} to delete", n);
	    throw new BadRequestException("no desktops found with this serialNumber to delete!!");  }
	    desktopRepo.deleteByserialNumber(n);
	    logger.info("Successfully deleted the desktop with serialnumber {}", n);
	    return"Deleted Successfully";   }
	
        //--------------------------------------------------------------
	    
	    //get the details of desktops by its id
	    @Override
	    public DesktopEntity getDesktopByGgid(int name) throws NotFoundException {
		Optional<DesktopEntity> m = desktopRepo.findBygGID(name);
		if(!m.isPresent()) {
	    logger.error("desktop with the id {} is not in database", name);
		throw new NotFoundException("no desktops found with this id!!");}
		logger.info("fetch all details of the desktop of the id {}", name);
		return m.get();
	     }
	
	
	    //get the details of desktops by its serialnumber
	    @Override 
	    public DesktopEntity getDesktopBySerialNumber(String name) throws BadRequestException {
	    Optional<DesktopEntity> m = desktopRepo.findBySerialNumber(name);
	    if(!m.isPresent()) {
	    logger.error("desktop with the serialnumber {} is not in database", name);
	    throw new BadRequestException("no desktops found with this serial number!!");}
	    logger.info("fetch all details of the desktop of the serialnumber {}", name);
	    return m.get(); }
	  
	  
	  
	 
}

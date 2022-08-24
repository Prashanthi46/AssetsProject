package com.asset.service;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.asset.controller.AccessoriesController;
import com.asset.entity.LaptopEntity;
import com.asset.exceptions.BadRequestException;
import com.asset.exceptions.NotFoundException;
import com.asset.repository.LaptopRepository;

@Service
public class LaptopServiceImpl implements LaptopServiceInterface{
	@Autowired
	LaptopRepository laptopRepo;
	Logger logger = LoggerFactory.getLogger(AccessoriesController.class);

	   //View All details of laptops
	   @Override
	   public List<LaptopEntity> getAllLaptops() throws NotFoundException {
	   List<LaptopEntity> m =laptopRepo.findAll();
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
	   logger.error("No laptops in Database");
	   throw new NotFoundException("No laptops found");}
	   logger.info("Fetch all laptops details from the database");
	   return laptopRepo.findAll();
	   }
	
	   
	   //------------------------------------------------------
		 
	   //Add a new laptops
	   @Override
	   public LaptopEntity addLaptop(LaptopEntity r) {
	   logger.info("Successfully created");
	   return laptopRepo.save(r);}
	
	   
	   //------------------------------------------------------------
	   
       //delete laptop by its id
	   @Override
	   public String deleteLaptop(int ggid) throws NotFoundException {
	   Optional<LaptopEntity> m = laptopRepo.findBygGID(ggid);
       if (!m.isPresent()) {
       logger.error("There is no laptop with the id {} to delete", ggid);
	   throw new NotFoundException("Sorry we can't find this Id!!");}
	   laptopRepo.deleteBygGID(ggid);
	   logger.info("Successfully deleted the laptop with id {}", ggid);
	   return "Removed";}
	
	   
	   //delete laptop by its serialNumber
	   @Override
	   public String deleteLaptopBySerialNumber(String n) throws BadRequestException {
       Optional<LaptopEntity> m = laptopRepo.findByserialNumber(n);
	   if (!m.isPresent()) {
	   logger.error("There is no laptop with the serialnumber {} to delete", n);
	   throw new BadRequestException("Sorry we can't find this Id!!");}
	   laptopRepo.deleteByserialNumber(n);
	   logger.info("Successfully deleted the laptop with serialnumber {}", n);
	   return "Removed";}
	
	   //------------------------------------------------------------
	    
	  
	   //update the laptop by its id
	   @Override
	   public LaptopEntity updateLaptopByGgid(int n,LaptopEntity l){
	   l.setGGID(n);
	   logger.info("Updated Successfully");
	   return laptopRepo.save(l);
		}
	
	   
	    //update the laptop by its serialNumber
	    @Override
	    public LaptopEntity updateLaptop(String n,LaptopEntity l){
		l.setSerialNumber(n);
		logger.info("Updated Successfully");
		return laptopRepo.save(l);}
	

        //--------------------------------------------------------------
	    
	    //get the details of laptop by its id
      	@Override
        public LaptopEntity getLaptopByGgid(int ggid) throws NotFoundException {
		Optional<LaptopEntity> m = laptopRepo.findBygGID(ggid);
		if (!m.isPresent()) {
	    logger.error("laptop with the id {} is not in database", ggid);
	    throw new NotFoundException("no laptop found with this id!!");}
		logger.info("fetch all details of the laptop of the id {}", ggid);
		return m.get();}
	
      	
       //get the details of laptops by its serialnumber
	   @Override
	   public LaptopEntity getLaptopBySerialNumber(String name) throws BadRequestException {
	   Optional<LaptopEntity> m = laptopRepo.findByserialNumber(name);
       if (!m.isPresent()) {
       logger.error("laptop with the serialnumber {} is not in database", name);
	   throw new BadRequestException("no laptop found with this serialnumber!!");}
       logger.info("fetch all details of the laptop of the serialnumber {}", name);
	   return m.get(); 
	   }




}

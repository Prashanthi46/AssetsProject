package com.asset.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asset.controller.AccessoriesController;
import com.asset.entity.MobileEntity;
import com.asset.exceptions.BadRequestException;
import com.asset.exceptions.NotFoundException;
import com.asset.repository.MobileRepository;
@Service
public class MobileServiceImpl implements MobileServiceInterface{ 
	@Autowired
	MobileRepository mobileRepo;
	Logger logger = LoggerFactory.getLogger(AccessoriesController.class);

	    //View All details of mobiles
	    @Override
	    public List<MobileEntity> getAllMobiles() throws NotFoundException {
		List<MobileEntity> m =mobileRepo.findAll();
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
		logger.error("No mobiles in Database");
		throw new NotFoundException("No mobiles found");}
		logger.info("Fetch all mobiles details from the database");
		return mobileRepo.findAll();}
	    
	    //------------------------------------------------------
		 
		 //Add a new mobiles
	     @Override
	     public MobileEntity addMobile(MobileEntity m) {
	     logger.info("Successfully created");
		 return mobileRepo.save(m);}

		 //------------------------------------------------------------
		    
	     
		 //update the mobile by its id
	     @Override
	     public MobileEntity updateMobile(String n, MobileEntity m) {
		 m.setSerialNumber(n);
		 logger.info("Successfully updated");
		 return mobileRepo.save(m);}
	     
	     
	     @Override
	     public MobileEntity updateMobileByGgid(int n, MobileEntity m) {
	   	 m.setgGID(n);
		 logger.info("Updated Successfully");
		 return mobileRepo.save(m);}
	
	     //------------------------------------------------------------
		   
	     
	     //delete mobile by its serialnumber
	     @Override 
	     public String deleteMobileBySerialNumber(String n)throws  BadRequestException{ 
		 Optional<MobileEntity> m = mobileRepo.findByserialNumber(n);
		 if(!m.isPresent()) {
		 logger.error("There is no mobile with the serialnumber {} to delete", n);
		 throw new BadRequestException("No mobiles found to delete ");}
		 logger.info("Successfully deleted the mobile with id {}", n);
	     mobileRepo.deleteByserialNumber(n);
	     return"Deleted Successfully"; }
	 
	     
	     //delete mobile by its id
	     @Override 
	     public String deleteMobile(int n)throws  NotFoundException{ 
		 Optional<MobileEntity> m = mobileRepo.findBygGID(n);
		 if(!m.isPresent()) {
		 logger.error("There is no mobile with the id {} to delete", n);
	     throw new NotFoundException("No mobiles found to delete ");}
		 logger.info("Successfully deleted the mobile with id {}", n);
	     mobileRepo.deleteBygGID(n);
	     return"Deleted Successfully"; }
	 
	     //--------------------------------------------------------------
		    
	     
		 //get the details of mobile by its id  
	     @Override
	     public MobileEntity getMobileByGgid(int a) throws NotFoundException {
		 Optional<MobileEntity> m = mobileRepo.findBygGID(a);
		 if (m.isEmpty()) {
		 logger.error("mobile with the id {} is not in database", a);
		 throw new NotFoundException("no mobile found with this id!!");}
		 logger.info("fetch all details of the mobile of the id {}", a);
		 return m.get();}
	
	
	  
	     //get the details of mobiles by its serialnumber
	     @Override public MobileEntity getMobileBySerialNumber(String name) throws BadRequestException {
		 Optional<MobileEntity> m = mobileRepo.findByserialNumber(name);
		 if (m.isEmpty()) {
		 logger.error("mobile with the serialnumber {} is not in database", name);
	     throw new BadRequestException("no mobile found with this serialnumber!!");}
		 logger.info("fetch all details of the mobile of the serialnumber {}", name);
		 return m.get();
		}
		
}

package com.asset.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.asset.controller.AccessoriesController;
import com.asset.entity.AccessoriesEntity;
import com.asset.exceptions.BadRequestException;
import com.asset.exceptions.NotFoundException;
import com.asset.repository.AccessoriesRepository;
@Service
public class AccessoriesServiceImpl implements AccessoriesServiceInterface {
	@Autowired
	AccessoriesRepository accessoriesRepo;
	Logger logger = LoggerFactory.getLogger(AccessoriesController.class);
	
	
	     //view all details of Accessories
	     @Override
	     public List<AccessoriesEntity> getAllAccessories() throws NotFoundException {
         List<AccessoriesEntity> m =accessoriesRepo.findAll();
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
	     logger.error("No Assets in Database");
		 throw new NotFoundException("no Assets found in database ");}
		 logger.info("Fetch all Accessories details from the database");
		 return accessoriesRepo.findAll(); }
	
	     //-----------------------------------------------------

         //add a new Accessories
	     @Override
	     public AccessoriesEntity addAccessories(AccessoriesEntity c) {
	     logger.info("Successfully created");
		 return accessoriesRepo.save(c);}
	
	     //---------------------------------------------------------
	 	
		    //update Accessories details by using serial number
		    @Override
		    public AccessoriesEntity updateAccessories(String name, AccessoriesEntity a) {
			a.setSerialNumber(name);
			logger.info("Updated Successfully");
			return accessoriesRepo.save(a);
		    }

		    
		    //update Accessories details by using GGID
		    @Override
		    public AccessoriesEntity updateAccessoriesByGgid(int name, AccessoriesEntity a) {
			a.setgGID(name);
			logger.info("Updated Successfully");
			return accessoriesRepo.save(a);
		    }

	   //------------------------------------------------------
	
	     //delete Accessories by using GGID
		 public String deleteAccessories(String n)throws BadRequestException{
		 Optional<AccessoriesEntity> m = accessoriesRepo.findByserialNumber(n);
		 if (!m.isPresent()) {
		 logger.error("There is no asset with the serialnumber {} to delete", n);
		 throw new BadRequestException("No Accessories to delete with the serialnumber"); }
		 accessoriesRepo.deleteByserialNumber(n);
		 logger.info("Successfully deleted the asset with serialnumber {}", n);
		 return"Deleted Successfully"; }
		

	    //delete Accessories by using GGID
	    public String deleteAccessoriesByGgid(int n)throws NotFoundException{
		Optional<AccessoriesEntity> m = accessoriesRepo.findBygGID(n);
		if (!m.isPresent()) {
		logger.error("There is no asset with the id {} to delete", n);
		throw new NotFoundException("No Accessories to delete with the id");}
		accessoriesRepo.deleteBygGID(n);
		logger.info("Successfully deleted the asset with id {}", n);
		return"Deleted Successfully"; }
	
      
        //----------------------------------------------------------
	
	
	    //get a perticular Accessories details by GGID
	    @Override
	    public AccessoriesEntity getAccessoriesByGgid(int name) throws NotFoundException {
		Optional<AccessoriesEntity> m = accessoriesRepo.findBygGID(name);
		if (!m.isPresent()) {
		logger.error("asset with the Id {} is not in database", name);
		throw new NotFoundException("No Accessories in Database with that id");}
		logger.info("fetch all details of the asset of the Id {}", name);
		return m.get(); }
	
	
	    //get a perticular Accessories details by serial number
	    @Override
	    public AccessoriesEntity getAccessoriesBySerialNumber(String name) throws BadRequestException {
		Optional<AccessoriesEntity> m = accessoriesRepo.findByserialNumber(name);
		if (!m.isPresent()) {
		logger.error("asset with the serialnumber {} is not in database", name);
		throw new BadRequestException("No Accessories in Database with that serialnumber");}
		logger.info("fetch all details of the asset of the serialnumber {}", name);
		return m.get();}

	
	  
}


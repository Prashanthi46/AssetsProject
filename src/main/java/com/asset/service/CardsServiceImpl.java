package com.asset.service;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asset.controller.AccessoriesController;
import com.asset.entity.CardsEntity;
import com.asset.exceptions.BadRequestException;
import com.asset.exceptions.NotFoundException;
import com.asset.repository.CardsRepository;

@Service
public class CardsServiceImpl implements CardsServiceInterface {
	
	@Autowired
	CardsRepository cardsRepo;
	Logger logger = LoggerFactory.getLogger(AccessoriesController.class);

	
	   //View All details of Cards 
	   @Override
	   public List<CardsEntity> getAllCards() throws NotFoundException {
	   List<CardsEntity> m =cardsRepo.findAll();
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
	   logger.error("No cards in Database");
	   throw new NotFoundException("no cards found");}
	   logger.info("Fetch all Card details from the database");
	   return cardsRepo.findAll();}
	
       //-----------------------------------------------------------
	   
       //Add a new card
	   @Override
	   public CardsEntity addCard(CardsEntity c) {
	   logger.info("Successfully created");
	   return cardsRepo.save(c); }
	
	   //--------------------------------------------------------
	   
        //delete card by its serialNumber
	    public String deleteCardBySerialNumber(String n)throws BadRequestException{
		Optional<CardsEntity> m = cardsRepo.findBySerialNumber(n);
		if (m.isEmpty()) {
	    logger.error("There is no cards with the serialnumber {} to delete", n);
		throw new BadRequestException("Sorry we can't find this serial number!!");}
	    logger.info("Successfully deleted the cards with serialnumber {}", n);
		cardsRepo.deleteBySerialNumber(n);
		return"Deleted Successfully";}
	    
	    
	    //delete card by its id
	    public String deleteCardByGgid(int n)throws NotFoundException{
		Optional<CardsEntity> m = cardsRepo.findBygGID(n);
		if (!m.isPresent()) {
	    logger.error("There is no cards with the id {} to delete", n);
	    throw new NotFoundException("Sorry we can't find this Id!!");	}
		cardsRepo.deleteBygGID(n);
		logger.info("Successfully deleted the cards with id {}", n);
		return"Deleted Successfully";}

	    //------------------------------------------------------------
	    
	    //update the cards by its serialNumber
	    @Override
	    public CardsEntity updateCard(String name, CardsEntity c) {
		c.setSerialNumber(name);
		logger.info("Updated Successfully");
		return cardsRepo.save(c); }

	    
	    
	    //update the cards by its Id
	    @Override
	    public CardsEntity updateCardByGgid(int name, CardsEntity c) {
		c.setgGID(name);
		logger.info("Updated Successfully");
		return cardsRepo.save(c);}

	    //--------------------------------------------------------------
	    
	    //get the details of card by its serialNumber
	    @Override
	    public CardsEntity getCardBySerialNumber(String name) throws BadRequestException {
		Optional<CardsEntity> m = cardsRepo.findBySerialNumber(name);
		if (m.isEmpty()) {
	    logger.error("card with the serialnumber {} is not in database", name);
		throw new BadRequestException("Sorry we can't find this serial Number!!");}	
		logger.info("fetch all details of the card of the serialnumber {}", name);
		return m.get();}
	    
	    
	
	    //get the details of card by its id
	    @Override
	    public CardsEntity getCardByGgid(int name) throws NotFoundException {
		Optional<CardsEntity> m = cardsRepo.findBygGID(name);
		if (!m.isPresent()) {
	    logger.error("card with the Id {} is not in database", name);
	    throw new NotFoundException(" Id not present!!");}
		logger.info("fetch all details of the card of the Id {}", name);
		return m.get();
	    }


	
}
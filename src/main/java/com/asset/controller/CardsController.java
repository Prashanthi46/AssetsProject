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
import com.asset.entity.CardsEntity;
import com.asset.exceptions.BadRequestException;
import com.asset.exceptions.NotFoundException;
import com.asset.service.CardsServiceInterface;
@Transactional
@CrossOrigin
@RestController
public class CardsController {
	
	@Autowired
	CardsServiceInterface cardsServiceInterface;
	
	    @GetMapping("/showallcards") 
	    public List<CardsEntity> getAllCards() throws NotFoundException {
        return cardsServiceInterface.getAllCards();
	    }
	

	    //-------------------------------------------------------
	    @PostMapping("/addcard") 
	    public CardsEntity addCard(@RequestBody CardsEntity l) {
        return cardsServiceInterface.addCard(l);
	    }

	
	    //------------------------------------------------------
	
	    @DeleteMapping("/deletecardsn/{serialNumber}")
	    public String deleteCardBySerialNumber(@PathVariable("serialNumber") String n)throws BadRequestException{
		cardsServiceInterface.deleteCardBySerialNumber(n);
	    return "Removed";
		}
	
	    @DeleteMapping("/deletecard/{gGID}")
	    public String deleteCardByGgid(@PathVariable("gGID")int n)throws NotFoundException{
		cardsServiceInterface.deleteCardByGgid(n);
		return "Removed";
		}
	
	    //----------------------------------------------------
	
	    @PutMapping("/updatecardsn/{serialNumber}")
        public CardsEntity updateCard(@PathVariable("serialNumber") String name,@RequestBody CardsEntity c) {
		return cardsServiceInterface.updateCard(name,c);
	    }

		@PutMapping("/updatecard/{gGID}")
	    public CardsEntity updateCardByGgid(@PathVariable("gGID")int name,@RequestBody CardsEntity c) {
		return cardsServiceInterface.updateCardByGgid(name,c);
		}
		//----------------------------------------------------
	
	    @GetMapping("/cardssn/{serialNumber}") 
	    public CardsEntity getCardBySerialNumber(@PathVariable("serialNumber") String name) throws BadRequestException {
        return cardsServiceInterface.getCardBySerialNumber(name);
	    }

	
	    @GetMapping("/cards/{gGID}") 
	    public CardsEntity getCardByGgid(@PathVariable("gGID") int name) throws NotFoundException {
        return cardsServiceInterface.getCardByGgid(name);
	    }

}
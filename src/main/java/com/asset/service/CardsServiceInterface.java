package com.asset.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.asset.entity.CardsEntity;
import com.asset.exceptions.BadRequestException;
import com.asset.exceptions.NotFoundException;

@Service
public interface CardsServiceInterface {

	public List<CardsEntity> getAllCards() throws NotFoundException;
	public CardsEntity addCard(CardsEntity c);
	public CardsEntity updateCard(String name, CardsEntity c);
	public String deleteCardBySerialNumber(String name) throws BadRequestException;
	public String deleteCardByGgid(int n)throws NotFoundException;
	public CardsEntity getCardByGgid(int name) throws NotFoundException;
    CardsEntity getCardBySerialNumber(String name) throws BadRequestException;
	CardsEntity updateCardByGgid(int name, CardsEntity c);
	
	

	


	



	

	

	

	

}

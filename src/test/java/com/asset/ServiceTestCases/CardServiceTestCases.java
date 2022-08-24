package com.asset.ServiceTestCases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.asset.entity.CardsEntity;
import com.asset.exceptions.BadRequestException;
import com.asset.exceptions.NotFoundException;
import com.asset.service.CardsServiceInterface;


public class CardServiceTestCases {

	@Mock
	CardsServiceInterface cardsServiceInterface;
	
	@Mock
	CardsEntity c;
	
	@BeforeEach
	void startup() {
		MockitoAnnotations.openMocks(this);

		c = new CardsEntity(1002, "Cards","Test Cards", "NL32432", "Edentifier", "ABN AMRO",
				"RTN7635",LocalDate.of(2022,05,16),"Sourabh", "STN5436", LocalDate.of(2022,05,16), 
				"Banglore", "Not Applicable", "with the employee", "AWS");
	            }
	
	     @Test
	     public void testgetAllCards() throws NotFoundException {		
		 Mockito.when(cardsServiceInterface.getAllCards()).thenReturn(Arrays.asList(c));
		 assertEquals(Arrays.asList(c),cardsServiceInterface.getAllCards());
		 Mockito.verify(cardsServiceInterface,times(1)).getAllCards();
	     }
	
	
		
		  @Test public void testdeleteCardBySerialNumber() throws NotFoundException,
		  BadRequestException { CardsEntity c5 = new CardsEntity(1002, "Cards","Test Cards", "NL32432", "Edentifier", "ABN AMRO",
					"RTN7635",LocalDate.of(2022,05,16),"Sourabh", "STN5436", LocalDate.of(2022,05,16), 
					"Banglore", "Not Applicable", "with the employee", "AWS");
		  when(cardsServiceInterface.deleteCardBySerialNumber(c5.getSerialNumber())).thenReturn("REMOVED");
		  String status = cardsServiceInterface.deleteCardBySerialNumber("NL32432");
		  assertEquals("REMOVED",status);
		  }
		 
		  
	      @Test
	      public void testdeleteCardByGgid() throws NotFoundException {
		  CardsEntity c3 = new CardsEntity(1002,null,"PR Cards", "NL32432", "Edentifier", 
				"ABN AMRO","RTN7635",LocalDate.of(2022,05,16),"Sourabh", "STN5436", LocalDate.of(2022,05,16), 
				"Banglore", null, "with the employee", "Account");
		  when(cardsServiceInterface.deleteCardByGgid(c3.getgGID())).thenReturn("REMOVED");
		  String status = cardsServiceInterface.deleteCardByGgid(1002);
		  assertEquals("REMOVED",status);
		  }
	
	
	      @Test
	      public void testaddCard() {
		  CardsEntity c4 = new CardsEntity(1002, null,"PR Cards", "NL32432", "Edentifier", 
				"ABN AMRO","RTN7635",LocalDate.of(2022,05,16),"Sourabh", "STN5436", LocalDate.of(2022,05,16), 
				"Banglore", null, "with the employee", "Account");
		  Mockito.when(cardsServiceInterface.addCard(c4)).thenReturn(c4);
		  assertEquals(c4,cardsServiceInterface.addCard(c4));
		  Mockito.verify(cardsServiceInterface).addCard(c4);
		  
		  }

	      @Test
	      public void testgetCardBySerialNumber() throws BadRequestException {
		  CardsEntity c6 = new CardsEntity(1002, null,"PR Cards", "NL32432", "Edentifier", 
				"ABN AMRO","RTN7635",LocalDate.of(2022,05,16),"Sourabh", "STN5436", LocalDate.of(2022,05,16), 
				"Banglore",null, "with the employee", "Account");
	      when(cardsServiceInterface.getCardBySerialNumber("NL32432")).thenReturn(c6);
		  assertEquals(c6, cardsServiceInterface.getCardBySerialNumber("NL32432"));
		  Mockito.verify(cardsServiceInterface).getCardBySerialNumber("NL32432");
		  }
	
	      
	      @Test
	      public void testgetCardByGgid() throws NotFoundException {
		  CardsEntity c2 = new CardsEntity(1002, null,"PR Cards", "NL32432", "Edentifier", 
				"ABN AMRO","RTN7635",LocalDate.of(2022,05,16),"Sourabh", "STN5436", LocalDate.of(2022,05,16), 
				"Banglore", null, "with the employee", "Account");
	      when(cardsServiceInterface.getCardByGgid(1002)).thenReturn(c2);
		  assertEquals(c2, cardsServiceInterface.getCardByGgid(1002));
		  Mockito.verify(cardsServiceInterface).getCardByGgid(1002);
		  }
	
}

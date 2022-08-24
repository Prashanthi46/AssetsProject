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

import com.asset.entity.LaptopEntity;
import com.asset.exceptions.BadRequestException;
import com.asset.exceptions.NotFoundException;
import com.asset.service.LaptopServiceInterface;


public class LaptopServiceTestCases {
	@Mock
	LaptopServiceInterface laptopServiceInterface;
	
	@Mock
	LaptopEntity laptopEntity;
	
	@BeforeEach
	void startup() {
		MockitoAnnotations.openMocks(this);

		laptopEntity = new LaptopEntity(1001, "Laptop", "KJSHEHK", "LIN542634", "HP Laptop","ABN AMRO",
				"RTN7635",LocalDate.of(2022,05,16),"Sourabh", "STN5436", LocalDate.of(2022,05,16), 
				"Banglore", "Allocated", "with the employee", "Account");
	            }
	
	     @Test
	     public void testgetAllLaptops() throws NotFoundException {		
		 Mockito.when(laptopServiceInterface.getAllLaptops()).thenReturn(Arrays.asList(laptopEntity));
		 assertEquals(Arrays.asList(laptopEntity),laptopServiceInterface.getAllLaptops());
		 Mockito.verify(laptopServiceInterface,times(1)).getAllLaptops();
	     }
	
	
		
		  @Test public void testdeleteLaptopBySerialNumber() throws BadRequestException{
			  LaptopEntity c5 = new LaptopEntity(1001, "Laptop", "KJSHEHK", "LIN542634", "HP Laptop","ABN AMRO",
						"RTN7635",LocalDate.of(2022,05,16),"Sourabh", "STN5436", LocalDate.of(2022,05,16), 
						"Banglore", "Allocated", "with the employee", "Account");
		  when(laptopServiceInterface.deleteLaptopBySerialNumber(c5.getSerialNumber())).thenReturn("REMOVED"); 
		  String status =laptopServiceInterface.deleteLaptopBySerialNumber("LIN542634");
		  assertEquals("REMOVED",status);
		  }
		 
		  
	      @Test
	      public void testdeleteLaptop() throws NotFoundException {
	    	  LaptopEntity c3 = new LaptopEntity(1001, "Laptop", "KJSHEHK", "LIN542634", "HP Laptop","ABN AMRO",
						"RTN7635",LocalDate.of(2022,05,16),"Sourabh", "STN5436", LocalDate.of(2022,05,16), 
						"Banglore", "Allocated", "with the employee", "Account");
		           
		  when(laptopServiceInterface.deleteLaptop(c3.getGGID())).thenReturn("REMOVED");
		  String status = laptopServiceInterface.deleteLaptop(1001);
		  assertEquals("REMOVED",status);
		  }
	
	
	      @Test
	      public void testaddLaptop(){
	    	  LaptopEntity c4 = new LaptopEntity(1001, "Laptop", "KJSHEHK", "LIN542634", "HP Laptop","ABN AMRO",
						"RTN7635",LocalDate.of(2022,05,16),"Sourabh", "STN5436", LocalDate.of(2022,05,16), 
						"Banglore", "Allocated", "with the employee", "Account");
		            
		  Mockito.when(laptopServiceInterface.addLaptop(c4)).thenReturn(c4);
		  assertEquals(c4,laptopServiceInterface.addLaptop(c4));
		  Mockito.verify(laptopServiceInterface).addLaptop(c4);
		  }

	      @Test
	      public void testgetLaptopBySerialNumber() throws BadRequestException {
	    	  LaptopEntity c6 =new LaptopEntity(1001, "Laptop", "KJSHEHK", "LIN542634", "HP Laptop","ABN AMRO",
						"RTN7635",LocalDate.of(2022,05,16),"Sourabh", "STN5436", LocalDate.of(2022,05,16), 
						"Banglore", "Allocated", "with the employee", "Account");
		           
	      when(laptopServiceInterface.getLaptopBySerialNumber("LIN542634")).thenReturn(c6);
		  assertEquals(c6, laptopServiceInterface.getLaptopBySerialNumber("LIN542634"));
		  Mockito.verify(laptopServiceInterface).getLaptopBySerialNumber("LIN542634");
		  }
	
	      
	      @Test
	      public void testgetLaptopByGgid() throws NotFoundException {
	      LaptopEntity c2 = new LaptopEntity(1001, "Laptop", "KJSHEHK", "LIN542634", "HP Laptop","ABN AMRO",
					"RTN7635",LocalDate.of(2022,05,16),"Sourabh", "STN5436", LocalDate.of(2022,05,16), 
					"Banglore", "Allocated", "with the employee", "Account");
	      when(laptopServiceInterface.getLaptopByGgid(1001)).thenReturn(c2);
		  assertEquals(c2, laptopServiceInterface.getLaptopByGgid(1001));
		  Mockito.verify(laptopServiceInterface).getLaptopByGgid(1001);
		  }
	
}

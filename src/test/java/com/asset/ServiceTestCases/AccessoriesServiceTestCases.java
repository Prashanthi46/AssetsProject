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

import com.asset.entity.AccessoriesEntity;
import com.asset.exceptions.BadRequestException;
import com.asset.exceptions.NotFoundException;
import com.asset.service.AccessoriesServiceInterface;


public class AccessoriesServiceTestCases {
	@Mock
	AccessoriesServiceInterface accessoriesServiceInterface;
	
	@Mock
	AccessoriesEntity a;
	
	@BeforeEach
	void startup() {
		MockitoAnnotations.openMocks(this);

		a = new AccessoriesEntity(1002, "Accessories","25482222", "Headphones", "Headphones-03", "Jabra headset",
				"RTN763365",LocalDate.of(2022,05,16),"Sourabh", "STN543766", LocalDate.of(2022,05,16), 
				"Hyd", "Transferred", "with the employee", "Account");
	            }
	
	     @Test
	     public void testgetAllAccessories() throws NotFoundException {		
		 Mockito.when(accessoriesServiceInterface.getAllAccessories()).thenReturn(Arrays.asList(a));
		 assertEquals(Arrays.asList(a),accessoriesServiceInterface.getAllAccessories());
		 Mockito.verify(accessoriesServiceInterface,times(1)).getAllAccessories();
	     }
	
	
		
		  @Test
		  public void testdeleteAccessories() throws BadRequestException {
		  AccessoriesEntity c5 = new AccessoriesEntity(1002, "Accessories", "Headphones", "25482222","Headphones-03", "Jabra headset",
					"RTN763365",LocalDate.of(2022,05,16),"Sourabh", "STN543766", LocalDate.of(2022,05,16), 
					"Hyd", "Transferred", "with the employee", "Account");
		            
		  when(accessoriesServiceInterface.deleteAccessories(c5.getSerialNumber())).thenReturn("REMOVED");
		  String status = accessoriesServiceInterface.deleteAccessories("25482222");
		  assertEquals("REMOVED",status);
		  }
		 
		  
	      @Test
	      public void testdeleteAccessoriesByGgid() throws NotFoundException {
	    	  AccessoriesEntity c3 = new AccessoriesEntity(1002, "Accessories","25482222", "Headphones", "Headphones-03", "Jabra headset",
						"RTN763365",LocalDate.of(2022,05,16),"Sourabh", "STN543766", LocalDate.of(2022,05,16), 
						"Hyd", "Transferred", "with the employee", "Account");
		  when(accessoriesServiceInterface.deleteAccessoriesByGgid(c3.getgGID())).thenReturn("REMOVED");
		  String status = accessoriesServiceInterface.deleteAccessoriesByGgid(1002);
		  assertEquals("REMOVED",status);
		  }
	
	
	      @Test
	      public void testaddAccessories() {
	    	  AccessoriesEntity c4 = new AccessoriesEntity(1002, "Accessories","25482222", "Headphones", "Headphones-03", "Jabra headset",
						"RTN763365",LocalDate.of(2022,05,16),"Sourabh", "STN543766", LocalDate.of(2022,05,16), 
						"Hyd", "Transferred", "with the employee", "Account");
		  Mockito.when(accessoriesServiceInterface.addAccessories(c4)).thenReturn(c4);
		  assertEquals(c4,accessoriesServiceInterface.addAccessories(c4));
		  Mockito.verify(accessoriesServiceInterface).addAccessories(c4);
		  
		  }

	      @Test
	      public void testgetAccessoriesBySerialNumber() throws BadRequestException {
	    	  AccessoriesEntity c6 = new AccessoriesEntity(1002, "Accessories","25482222", "Headphones", "Headphones-03", "Jabra headset",
						"RTN763365",LocalDate.of(2022,05,16),"Sourabh", "STN543766", LocalDate.of(2022,05,16), 
						"Hyd", "Transferred", "with the employee", "Account");
	      when(accessoriesServiceInterface.getAccessoriesBySerialNumber("25482222")).thenReturn(c6);
		  assertEquals(c6, accessoriesServiceInterface.getAccessoriesBySerialNumber("25482222"));
		  Mockito.verify(accessoriesServiceInterface).getAccessoriesBySerialNumber("25482222");
		  }
	
	      
	      @Test
	      public void testgetAccessoriesByGgid() throws NotFoundException {
	    	  AccessoriesEntity c2 = new AccessoriesEntity(1002, "Accessories","25482222", "Headphones", "Headphones-03", "Jabra headset",
						"RTN763365",LocalDate.of(2022,05,16),"Sourabh", "STN543766", LocalDate.of(2022,05,16), 
						"Hyd", "Transferred", "with the employee", "Account");
	      when(accessoriesServiceInterface.getAccessoriesByGgid(1002)).thenReturn(c2);
		  assertEquals(c2, accessoriesServiceInterface.getAccessoriesByGgid(1002));
		  Mockito.verify(accessoriesServiceInterface).getAccessoriesByGgid(1002);
		  }
	
}

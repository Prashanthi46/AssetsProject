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
import com.asset.entity.MobileEntity;
import com.asset.exceptions.BadRequestException;
import com.asset.exceptions.NotFoundException;
import com.asset.service.MobileServiceInterface;

public class MobileServiceTestCases {
	@Mock
	MobileServiceInterface mobileServiceInterface;
	
	@Mock
	MobileEntity mobileEntity;
	
	@BeforeEach
	void startup() {
		MockitoAnnotations.openMocks(this);

		mobileEntity = new MobileEntity(1002,"Mobiles","Support phone", "Samsung Galaxy J21", "SR4XD66S", "ABN AMRO",
				"RTN7635",LocalDate.of(2022,05,16),"Sourabh", "STN5436", LocalDate.of(2022,05,16), 
				"Banglore", null, "with the employee", "Account", "JEHERI22", "SAT2733HS", "2YIUW26", "YE37WI", "123:64:647");
	            }
	
	     @Test
	     public void testgetAllMobiles() throws NotFoundException {		
		 Mockito.when(mobileServiceInterface.getAllMobiles()).thenReturn(Arrays.asList(mobileEntity));
		 assertEquals(Arrays.asList(mobileEntity),mobileServiceInterface.getAllMobiles());
		 Mockito.verify(mobileServiceInterface,times(1)).getAllMobiles();
	     }
	
	
		
		  @Test public void testdeleteMobileBySerialNumber() throws BadRequestException{
		  MobileEntity c5 = new MobileEntity(1002,"Mobiles","Support phone",  "SR4XD66S","Samsung Galaxy J21", "ABN AMRO",
					"RTN7635",LocalDate.of(2022,05,16),"Sourabh", "STN5436", LocalDate.of(2022,05,16), 
					"Banglore", null, "with the employee", "Account", "JEHERI22", "SAT2733HS", "2YIUW26", "YE37WI", "123:64:647");
		  when(mobileServiceInterface.deleteMobileBySerialNumber(c5.getSerialNumber())).thenReturn("REMOVED"); 
		  String status =mobileServiceInterface.deleteMobileBySerialNumber("SR4XD66S");
		  assertEquals("REMOVED",status);
		  }
		 
		  
	      @Test
	      public void testdeleteMobile() throws NotFoundException {
	      MobileEntity c3 = new MobileEntity(1002,"Mobiles","Support phone", "Samsung Galaxy J21", "SR4XD66S", "ABN AMRO",
					"RTN7635",LocalDate.of(2022,05,16),"Sourabh", "STN5436", LocalDate.of(2022,05,16), 
					"Banglore", null, "with the employee", "Account", "JEHERI22", "SAT2733HS", "2YIUW26", "YE37WI", "123:64:647");
		  when(mobileServiceInterface.deleteMobile(c3.getgGID())).thenReturn("REMOVED");
		  String status = mobileServiceInterface.deleteMobile(1002);
		  assertEquals("REMOVED",status);
		  }
	
	
	      @Test
	      public void testaddMobile(){
	      MobileEntity c4 = new MobileEntity(1002,"Mobiles","Support phone", "Samsung Galaxy J21", "SR4XD66S", "ABN AMRO",
					"RTN7635",LocalDate.of(2022,05,16),"Sourabh", "STN5436", LocalDate.of(2022,05,16), 
					"Banglore", null, "with the employee", "Account", "JEHERI22", "SAT2733HS", "2YIUW26", "YE37WI", "123:64:647");
		  Mockito.when(mobileServiceInterface.addMobile(c4)).thenReturn(c4);
		  assertEquals(c4,mobileServiceInterface.addMobile(c4));
		  Mockito.verify(mobileServiceInterface).addMobile(c4);
		  }

	      @Test
	      public void testgetMobileBySerialNumber() throws BadRequestException {
	      MobileEntity c6 = new MobileEntity(1002,"Mobiles","Support phone",  "SR4XD66S","Samsung Galaxy J21", "ABN AMRO",
					"RTN7635",LocalDate.of(2022,05,16),"Sourabh", "STN5436", LocalDate.of(2022,05,16), 
					"Banglore", null, "with the employee", "Account", "JEHERI22", "SAT2733HS", "2YIUW26", "YE37WI", "123:64:647");
	      when(mobileServiceInterface.getMobileBySerialNumber("SR4XD66S")).thenReturn(c6);
		  assertEquals(c6, mobileServiceInterface.getMobileBySerialNumber("SR4XD66S"));
		  Mockito.verify(mobileServiceInterface).getMobileBySerialNumber("SR4XD66S");
		  }
	
	      
	      @Test
	      public void testgetMobileByGgid() throws NotFoundException {
	      MobileEntity c2 = new MobileEntity(1002,"Mobiles","Support phone", "Samsung Galaxy J21", "SR4XD66S", "ABN AMRO",
					"RTN7635",LocalDate.of(2022,05,16),"Sourabh", "STN5436", LocalDate.of(2022,05,16), 
					"Banglore", null, "with the employee", "Account", "JEHERI22", "SAT2733HS", "2YIUW26", "YE37WI", "123:64:647");
	      when(mobileServiceInterface.getMobileByGgid(1002)).thenReturn(c2);
		  assertEquals(c2, mobileServiceInterface.getMobileByGgid(1002));
		  Mockito.verify(mobileServiceInterface).getMobileByGgid(1002);
		  }
	
}

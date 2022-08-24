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
import com.asset.entity.DesktopEntity;
import com.asset.exceptions.BadRequestException;
import com.asset.exceptions.NotFoundException;
import com.asset.service.DesktopServiceInterface;

public class DesktopServiceTestCases {

	@Mock
	DesktopServiceInterface desktopServiceInterface;
	
	@Mock
	DesktopEntity d;
	
	@BeforeEach
	void startup() {
		MockitoAnnotations.openMocks(this);

		d= new DesktopEntity(1002, "Desktop","Imac Desktop", "DIN67001161","C022B76B6H1", "ABN AMRO",
				"RTN763545",LocalDate.of(2022,05,16),"Sourabh", "STN5646436", LocalDate.of(2022,05,16), 
				"Banglore", "Available", "with the employee", "DSTFKHIUs");
	            }
	
	     @Test
	     public void testgetAllDesktops() throws NotFoundException {		
		 Mockito.when(desktopServiceInterface.getAllDesktops()).thenReturn(Arrays.asList(d));
		 assertEquals(Arrays.asList(d),desktopServiceInterface.getAllDesktops());
		 Mockito.verify(desktopServiceInterface,times(1)).getAllDesktops();
	     }
	
	
		
		  @Test public void testdeleteDesktopBySerialNumber() throws NotFoundException,
		  BadRequestException { DesktopEntity c5 = new DesktopEntity(1002, "Desktop","Imac Desktop", "C022B76B6H1","DIN67001161", "ABN AMRO",
					"RTN763545",LocalDate.of(2022,05,16),"Sourabh", "STN5646436", LocalDate.of(2022,05,16), 
					"Banglore", "Available", "with the employee", "DSTFKHIUs");
		  when(desktopServiceInterface.deleteDesktop(c5.getSerialNumber())).thenReturn("REMOVED");
		  String status = desktopServiceInterface.deleteDesktop("C022B76B6H1");
		  assertEquals("REMOVED",status);
		  }
		 
		  
	      @Test
	      public void testdeleteCardByGgid() throws NotFoundException {
	    	  DesktopEntity c3 = new DesktopEntity(1002, "Desktop","Imac Desktop", "DIN67001161","C022B76B6H1", "ABN AMRO",
						"RTN763545",LocalDate.of(2022,05,16),"Sourabh", "STN5646436", LocalDate.of(2022,05,16), 
						"Banglore", "Available", "with the employee", "DSTFKHIUs");
		  when(desktopServiceInterface.deleteDesktopByGgid(c3.getgGID())).thenReturn("REMOVED");
		  String status = desktopServiceInterface.deleteDesktopByGgid(1002);
		  assertEquals("REMOVED",status);
		  }
	
	
	      @Test
	      public void testaddDesktop() {
	    	  DesktopEntity c4 = new DesktopEntity(1002, "Desktop","Imac Desktop", "DIN67001161","C022B76B6H1", "ABN AMRO",
						"RTN763545",LocalDate.of(2022,05,16),"Sourabh", "STN5646436", LocalDate.of(2022,05,16), 
						"Banglore", "Available", "with the employee", "DSTFKHIUs");
		  Mockito.when(desktopServiceInterface.addDesktop(c4)).thenReturn(c4);
		  assertEquals(c4,desktopServiceInterface.addDesktop(c4));
		  Mockito.verify(desktopServiceInterface).addDesktop(c4);
		  
		  }

	      @Test
	      public void testgetDesktopBySerialNumber() throws BadRequestException {
	    	  DesktopEntity c6 = new DesktopEntity(1002, "Desktop","Imac Desktop", "DIN67001161","C022B76B6H1", "ABN AMRO",
						"RTN763545",LocalDate.of(2022,05,16),"Sourabh", "STN5646436", LocalDate.of(2022,05,16), 
						"Banglore", "Available", "with the employee", "DSTFKHIUs");
	      when(desktopServiceInterface.getDesktopBySerialNumber("C022B76B6H1")).thenReturn(c6);
		  assertEquals(c6, desktopServiceInterface.getDesktopBySerialNumber("C022B76B6H1"));
		  Mockito.verify(desktopServiceInterface).getDesktopBySerialNumber("C022B76B6H1");
		  }
	
	      
	      @Test
	      public void testgetCardByGgid() throws NotFoundException {
	    	  DesktopEntity c2 = new DesktopEntity(1002, "Desktop","Imac Desktop", "DIN67001161","C022B76B6H1", "ABN AMRO",
						"RTN763545",LocalDate.of(2022,05,16),"Sourabh", "STN5646436", LocalDate.of(2022,05,16), 
						"Banglore", "Available", "with the employee", "DSTFKHIUs");
	      when(desktopServiceInterface.getDesktopByGgid(1002)).thenReturn(c2);
		  assertEquals(c2, desktopServiceInterface.getDesktopByGgid(1002));
		  Mockito.verify(desktopServiceInterface).getDesktopByGgid(1002);
		  }
	
}

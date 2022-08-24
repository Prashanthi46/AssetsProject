
package com.asset.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.asset.entity.AccessoriesEntity;
import com.asset.exceptions.BadRequestException;
import com.asset.exceptions.NotFoundException;

@Service
public interface AccessoriesServiceInterface {	
	public List<AccessoriesEntity> getAllAccessories() throws NotFoundException;
    public AccessoriesEntity addAccessories(AccessoriesEntity a);
    
    public String deleteAccessories(String n)throws BadRequestException;
    public String deleteAccessoriesByGgid(int n)throws NotFoundException;
    
    AccessoriesEntity updateAccessoriesByGgid(int name, AccessoriesEntity a);
    public AccessoriesEntity updateAccessories(String name, AccessoriesEntity a);
    
    public AccessoriesEntity getAccessoriesByGgid(int name) throws NotFoundException;
    public AccessoriesEntity getAccessoriesBySerialNumber(String name)throws BadRequestException;
	//public List<AccessoriesEntity> getAccessoriescount(String name);
	
}
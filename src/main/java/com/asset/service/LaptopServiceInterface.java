package com.asset.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.asset.entity.LaptopEntity;
import com.asset.exceptions.BadRequestException;
import com.asset.exceptions.NotFoundException;

@Service("laptopServiceInterface")
public interface LaptopServiceInterface {
	public List<LaptopEntity> getAllLaptops() throws NotFoundException;
	public LaptopEntity addLaptop(LaptopEntity a);
    public String deleteLaptop(int ggid) throws NotFoundException;
	public LaptopEntity getLaptopByGgid(int ggid) throws NotFoundException;
	public LaptopEntity getLaptopBySerialNumber(String name) throws BadRequestException;
	public LaptopEntity updateLaptopByGgid(int n, LaptopEntity l);
	String deleteLaptopBySerialNumber(String n) throws BadRequestException;
	LaptopEntity updateLaptop(String n, LaptopEntity l);
}

package com.asset.service;

import java.util.List;

import com.asset.entity.DesktopEntity;
import com.asset.entity.MobileEntity;
import com.asset.exceptions.BadRequestException;
import com.asset.exceptions.NotFoundException;

public interface MobileServiceInterface {

	List<MobileEntity> getAllMobiles() throws NotFoundException;

	MobileEntity addMobile(MobileEntity m);

	MobileEntity updateMobileByGgid(int n, MobileEntity m);

	MobileEntity getMobileByGgid(int n) throws NotFoundException ;

	MobileEntity getMobileBySerialNumber(String name) throws BadRequestException;

	String deleteMobileBySerialNumber(String n) throws BadRequestException;


	MobileEntity updateMobile(String n, MobileEntity m);

	String deleteMobile(int n) throws NotFoundException;







	
}

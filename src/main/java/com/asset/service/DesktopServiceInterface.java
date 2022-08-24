package com.asset.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.asset.entity.DesktopEntity;
import com.asset.exceptions.BadRequestException;
import com.asset.exceptions.NotFoundException;

@Service
public interface DesktopServiceInterface {

	List<DesktopEntity> getAllDesktops() throws NotFoundException;

	DesktopEntity addDesktop(DesktopEntity d);


	DesktopEntity getDesktopByGgid(int name) throws NotFoundException;

	String deleteDesktopByGgid(int n) throws NotFoundException;

	DesktopEntity updateDesktopByGgid(int n, DesktopEntity d);


	DesktopEntity getDesktopBySerialNumber(String name) throws BadRequestException;


	DesktopEntity updateDesktop(String name, DesktopEntity d);

	String deleteDesktop(String n) throws BadRequestException;






}

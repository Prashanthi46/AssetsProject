package com.asset.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asset.entity.MobileEntity;
@Repository("MobileRepo")
public interface MobileRepository extends JpaRepository<MobileEntity, Integer>{
	
	Optional<MobileEntity> findBygGID(int a);

	Optional<MobileEntity> findByserialNumber(String name);


	void deleteByserialNumber(String n);

	void deleteBygGID(int n);
}

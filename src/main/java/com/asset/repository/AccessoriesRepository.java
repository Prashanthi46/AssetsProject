package com.asset.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asset.entity.AccessoriesEntity;
@Repository
public interface AccessoriesRepository extends JpaRepository<AccessoriesEntity, String>{

	Optional<AccessoriesEntity> findBygGID(int name);

	Optional<AccessoriesEntity> findByserialNumber(String name);

	void deleteBygGID(int n);

	void deleteByserialNumber(String n);

	AccessoriesEntity findAllByassetType(String name);

	AccessoriesEntity findByassetType(String name);



}
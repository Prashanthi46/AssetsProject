package com.asset.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.asset.entity.CountStatus;
import com.asset.entity.LaptopEntity;

@Repository
public interface LaptopRepository extends JpaRepository<LaptopEntity, Integer>{



	Optional<LaptopEntity> findByserialNumber(String n);

	void deleteByserialNumber(String n);

	Optional<LaptopEntity> findBygGID(int ggid);

	void deleteBygGID(int ggid);
	
    @Query("select new com.asset.entity.CountStatus(asset_type,status,count(ggid))"+" from LaptopEntity group by asset_type,status")
    List<CountStatus> countTotalLaptopEntityByAsset_TypeAndStatus();
	 

}

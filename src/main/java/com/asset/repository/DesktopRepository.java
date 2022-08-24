package com.asset.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asset.entity.DesktopEntity;


@Repository
public interface DesktopRepository  extends JpaRepository<DesktopEntity, Integer> {




	Optional<DesktopEntity> findBygGID(int n);

	Optional<DesktopEntity> findBySerialNumber(String name);

	List<DesktopEntity> findByAssetName(String name);

	void deleteBygGID(int n);

	void deleteByserialNumber(String n);

	//DesktopEntity findBySerial_Number(String name);

	//List<DesktopEntity> findByAsset_Name(String name);

}

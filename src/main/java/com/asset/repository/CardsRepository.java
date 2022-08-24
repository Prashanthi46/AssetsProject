package com.asset.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.asset.entity.CardsEntity;


@Repository
public interface CardsRepository  extends JpaRepository<CardsEntity, String> {

	Optional<CardsEntity> findBySerialNumber(String n);

	Optional<CardsEntity> findBygGID(int n);

	void deleteBygGID(int n);

	void deleteBySerialNumber(String n);
}

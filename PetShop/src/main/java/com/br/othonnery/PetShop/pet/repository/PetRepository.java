package com.br.othonnery.PetShop.pet.repository;

import com.br.othonnery.PetShop.pet.domain.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository <Pet,Integer>{
}

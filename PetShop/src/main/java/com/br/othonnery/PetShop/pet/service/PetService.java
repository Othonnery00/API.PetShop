package com.br.othonnery.PetShop.pet.service;


import com.br.othonnery.PetShop.pet.domain.Pet;
import com.br.othonnery.PetShop.pet.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PetService {
@Autowired
    private PetRepository petRepository;

    public Pet adicionarPet(Pet novoPet){
        return petRepository.save(novoPet);
    }

    public List<Pet> listarPets(){
        return petRepository.findAll();
    }

    public Pet atualizarPet(Pet pet){
        return petRepository.save(pet);
    }

    public void deletarPet(Integer idPet){
        petRepository.deleteById(idPet);
    }

    public Optional<Pet> buscarPet(Integer idPet) {
        return petRepository.findById(idPet);
    }
}

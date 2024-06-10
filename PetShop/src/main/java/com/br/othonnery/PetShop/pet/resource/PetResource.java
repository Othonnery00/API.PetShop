package com.br.othonnery.PetShop.pet.resource;

import com.br.othonnery.PetShop.pet.domain.Pet;
import com.br.othonnery.PetShop.pet.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pet")
public class PetResource {

    @Autowired
    private PetService petService;

    @PostMapping
    public ResponseEntity<Pet> adicionarPet(@RequestBody Pet petNovo){
        Pet petAdicionado = petService.adicionarPet(petNovo);
        return new ResponseEntity<>(petAdicionado, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Pet>> listarPets() {
        List<Pet> pets = petService.listarPets();
        return ResponseEntity.ok(pets);
    }

    @GetMapping("/{idPet}")
    public ResponseEntity<Pet> buscarPet(@PathVariable Integer idPet){
        return petService.buscarPet(idPet)
                .map(pet -> new ResponseEntity<>(pet,HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{idPet}")
    public ResponseEntity<Void> deletarPet(@PathVariable Integer idPet){
        petService.deletarPet(idPet);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{idPet}")
    public ResponseEntity<Pet> atualizarPet(@PathVariable Integer idPet, @RequestBody Pet pet){
        if (!petService.buscarPet(idPet).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        pet.setId(idPet);
        Pet novoPet = petService.atualizarPet(pet);
        return new ResponseEntity<>(novoPet, HttpStatus.OK);
    }

}

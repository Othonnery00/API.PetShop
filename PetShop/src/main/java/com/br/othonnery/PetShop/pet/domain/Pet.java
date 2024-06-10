package com.br.othonnery.PetShop.pet.domain;

import com.br.othonnery.PetShop.tutor.domain.Tutor;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode
@Table(name = "Pet")

public class Pet {
    @Id
    @GeneratedValue
    @Column(name = "ID_PET")
    private Integer id;

    @Column(name = "NOME_PET")
    private String NomePet;

    @Column(name = "RACA_PET")
    private String RacaPet;

    @Column(name = "COR_PET")
    private String CorPet;

    @Column(name = "PESO_PET")
    private Integer PesoPet;

    @Column(name = "IDADE_PET")
    private Integer IdadePet;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_TUTOR")
    private Tutor idTutor;
}

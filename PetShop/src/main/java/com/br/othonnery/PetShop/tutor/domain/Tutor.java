package com.br.othonnery.PetShop.tutor.domain;

import com.br.othonnery.PetShop.pet.domain.Pet;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Entity
@Data
@EqualsAndHashCode
@Table(name = "TUTOR")
public class Tutor {

    @Id
    @GeneratedValue
    @Column(name = "ID_TUTOR")
    private Integer id;

    @Column(name = "NOME_TUTOR")
    private String NomeTutor;

    @Column(name = "CPF_TUTOR")
    private Integer CpfTutor;

    @Column(name = "TELEFONE_TUTOR")
    private Integer TelefoneTutor;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_PET")
    private List<Pet> pet;
}

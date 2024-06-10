package com.br.othonnery.PetShop.tutor.service;

import com.br.othonnery.PetShop.tutor.domain.Tutor;
import com.br.othonnery.PetShop.tutor.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TutorService {
@Autowired
    private TutorRepository tutorRepository;

    public Tutor adicionarTutor(Tutor tutorNovo){
        return tutorRepository.save(tutorNovo);
    }

    public Optional<Tutor> buscarTutor(Integer idTutor){
        return tutorRepository.findById(idTutor);
    }

    public List<Tutor> listarTutor(){
        return tutorRepository.findAll();
    }

    public Tutor atualizarTutor(Tutor tutor){
        return tutorRepository.save(tutor);
    }

    public void deletarTutor(Integer idTutor){
        tutorRepository.deleteById(idTutor);
    }


}

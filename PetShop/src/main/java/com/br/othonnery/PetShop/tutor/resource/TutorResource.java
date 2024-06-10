package com.br.othonnery.PetShop.tutor.resource;

import com.br.othonnery.PetShop.tutor.domain.Tutor;
import com.br.othonnery.PetShop.tutor.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/tutor")
public class TutorResource {

        @Autowired
        private TutorService tutorService;

        @PostMapping
        public ResponseEntity<Tutor> adicionarTutor(@RequestBody Tutor tutorNovo){
            Tutor tutorAdicionado = tutorService.adicionarTutor(tutorNovo);
            return new ResponseEntity<>(tutorAdicionado, HttpStatus.CREATED);
        }

        @GetMapping
        public ResponseEntity<List<Tutor>> listarTutor() {
            List<Tutor> tutor = tutorService.listarTutor();
            return ResponseEntity.ok(tutor);
        }

        @GetMapping("/{idTutor}")
        public ResponseEntity<Tutor> buscarTutor(@PathVariable Integer idTutor){
            return tutorService.buscarTutor(idTutor)
                    .map(tutor -> new ResponseEntity<>(tutor,HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        }

        @DeleteMapping("/{idTutor}")
        public ResponseEntity<Void> deletarTutor(@PathVariable Integer idTutor){
            tutorService.deletarTutor(idTutor);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        @PutMapping("/{idTutor}")
        public ResponseEntity<Tutor> atualizarTutor(@PathVariable Integer idTutor, @RequestBody Tutor tutor){
            if (!tutorService.buscarTutor(idTutor).isPresent()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            tutor.setId(idTutor);
            Tutor novoTutor = tutorService.atualizarTutor(tutor);
            return new ResponseEntity<>(novoTutor, HttpStatus.OK);
        }

}

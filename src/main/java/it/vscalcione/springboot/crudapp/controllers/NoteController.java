package it.vscalcione.springboot.crudapp.controllers;

import it.vscalcione.springboot.crudapp.entities.Note;
import it.vscalcione.springboot.crudapp.repositories.NoteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class NoteController {

    private final NoteRepository noteRepository;

    public NoteController(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @GetMapping("/notes")
    Iterable<Note> getNotes(){
        return noteRepository.findAll();

    }

    @PostMapping("/notes")
    Note createNote(@RequestBody Note note){
        return noteRepository.save(note);
    }

    @GetMapping("/notes/{id}")
    Optional<Note> getNote(@PathVariable Long id) {
        return noteRepository.findById(id);
    }
}

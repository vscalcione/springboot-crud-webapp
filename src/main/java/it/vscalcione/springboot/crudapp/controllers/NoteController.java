package it.vscalcione.springboot.crudapp.controllers;

import it.vscalcione.springboot.crudapp.entities.Note;
import it.vscalcione.springboot.crudapp.repositories.NoteRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

}

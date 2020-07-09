package it.vscalcione.springboot.crudapp.controllers;


import it.vscalcione.springboot.crudapp.entities.Note;
import it.vscalcione.springboot.crudapp.repositories.NoteRepository;
import org.springframework.web.bind.annotation.*;

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
    Note getNote(@PathVariable Long id) throws Exception {
        return noteRepository.findById(id).orElseThrow(() -> new Exception("No Object found with id: " + id));
    }

    @PutMapping("/notes/{id}")
    Note updateNote(@PathVariable Long id, @RequestBody Note noteDto) throws Exception{
        Note noteToUpdate = noteRepository.findById(id).orElseThrow(() -> new Exception("No Object found with id: " + id));
        noteToUpdate.setTitle(noteDto.getTitle());
        noteToUpdate.setContent(noteDto.getContent());
        return noteRepository.save(noteToUpdate);
    }

    @DeleteMapping("/notes/{id}")
    void deleteNote(@PathVariable Long id, @RequestBody Note noteDto) throws Exception {
        Note noteToDelete = noteRepository.findById(id).orElseThrow(() -> new Exception("No Object found with id: " + id));
        noteRepository.delete(noteToDelete);
    }
}

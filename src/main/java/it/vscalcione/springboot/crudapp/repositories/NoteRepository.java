package it.vscalcione.springboot.crudapp.repositories;

import it.vscalcione.springboot.crudapp.entities.Note;
import org.springframework.data.repository.CrudRepository;

public interface NoteRepository extends CrudRepository<Note, Long> {
}

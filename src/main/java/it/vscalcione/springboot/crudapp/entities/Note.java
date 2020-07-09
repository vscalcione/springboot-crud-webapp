package it.vscalcione.springboot.crudapp.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Note {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String content;

    public Note() {
    }

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }
}

package com.example.designAPIHW6.controllers;

import com.example.designAPIHW6.models.Note;
import com.example.designAPIHW6.services.impl.NoteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
@AllArgsConstructor
public class NoteController {
    private  final NoteService noteService;


    /**
     * Получение всех заметок
     * @return список заметок
     * */
    @GetMapping
    public ResponseEntity<List<Note>> getAll(){
            return new ResponseEntity<>(noteService.getAllNotes(), HttpStatus.OK);
    }

    /**
     * Получение заметки по id
     * @return ResponseEntity<Note>
     * */
    @GetMapping("/{id}")
    public ResponseEntity<Note> getNote(@PathVariable Long id){
        return new ResponseEntity<>(noteService.getNoteById(id), HttpStatus.OK);
    }


    /**
     * Удаление заметки по id
     * */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id){
        noteService.deleteNoteById(id);
        return ResponseEntity.ok().build();
    }

    /**
     * Редактирование заметки, найденной по id
     * @return ResponseEntity<Note>
     * */
    @PutMapping("/{id}")
    public ResponseEntity<Note> update(@PathVariable Long id,  @RequestBody Note note){
        return new ResponseEntity<>(noteService.updateNote(id, note), HttpStatus.OK);
    }

    /**
     * Создание новой заметки
     * @return ResponseEntity<Note>
     * */
    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody Note note){
        return new ResponseEntity<>(noteService.createNote(note), HttpStatus.CREATED);
    }
}

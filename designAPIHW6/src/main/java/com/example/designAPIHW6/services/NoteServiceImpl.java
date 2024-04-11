package com.example.designAPIHW6.services;

import com.example.designAPIHW6.models.Note;
import com.example.designAPIHW6.repo.NoteRepo;
import com.example.designAPIHW6.services.impl.NoteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class NoteServiceImpl implements NoteService {

    private final NoteRepo noteRepo;

    /**
     * Получение всех заметок
     * @return список заметок
     * */
    @Override
    public List<Note> getAllNotes() {
        return noteRepo.findAll();
    }

    /**
     * Получение заметки по id
     * @return заметок
     * */
    @Override
    public Note getNoteById(Long id) {
        return noteRepo.findById(id).orElseThrow(null);
    }

    /**
     * Редактирование заметки, найденной по id
     * @return Note
     * */
    @Override
    public Note updateNote(Long id,Note newNote) {
        Optional<Note> noteByID = noteRepo.findById(id);
        if (noteByID.isPresent()) {
            Note note = noteByID.get();
            note.setTitle(newNote.getTitle());
            note.setContent(newNote.getContent());
            note.setCtreationDate(newNote.getCtreationDate());
            return noteRepo.save(note);
        } else {
            throw new IllegalArgumentException("Task not found");
        }
    }

    /**
     * Создание новой заметки
     * @return Note
     * */
    @Override
    public Note createNote(Note note) {
        note.setCtreationDate(LocalDateTime.now());
        return noteRepo.save(note);
    }

    /**
     * Удаление заметки по id
     * */
    @Override
    public void deleteNoteById(Long id) {
        noteRepo.deleteById(id);
    }
}

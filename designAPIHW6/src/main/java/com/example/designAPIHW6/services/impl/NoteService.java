package com.example.designAPIHW6.services.impl;

import com.example.designAPIHW6.models.Note;

import java.util.List;

public interface NoteService{
    List<Note> getAllNotes();
    Note getNoteById(Long id);
    Note updateNote(Long id, Note note);
    Note createNote(Note note);
    void deleteNoteById(Long id);

}

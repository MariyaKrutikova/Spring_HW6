package com.example.designAPIHW6.repo;

import com.example.designAPIHW6.models.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepo extends JpaRepository<Note, Long> {
}

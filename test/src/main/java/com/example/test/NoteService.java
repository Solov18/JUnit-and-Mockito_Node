package com.example.test;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NoteService {
    @Autowired
    private NoteRepository noteRepository;
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }
    public Note getNoteById(Long id) {
        return noteRepository.findById(id).orElse(null);
    }
    public Note saveOrUpdate(Note note) {
        return noteRepository.save(note);
    }
    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }
}
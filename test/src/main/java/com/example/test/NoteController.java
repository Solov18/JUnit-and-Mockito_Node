package com.example.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteController {
    @Autowired
    private NoteService noteService;

    @GetMapping
    public List<Note> getAllNotes() {
        return noteService.getAllNotes();
    }
    @GetMapping("/{id}")
    public Note getNote(@PathVariable Long id) {
        return noteService.getNoteById(id);
    }
    @PostMapping
    public Note createNote(@RequestBody Note note) {
        return noteService.saveOrUpdate(note);
    }
    @PutMapping("/{id}")
    public Note updateNote(@PathVariable Long id, @RequestBody Note
            updatedNote) {
        Note note = noteService.getNoteById(id);
        note.setTitle(updatedNote.getTitle());
        note.setContent(updatedNote.getContent());
        return noteService.saveOrUpdate(note);
    }
    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
    }
}

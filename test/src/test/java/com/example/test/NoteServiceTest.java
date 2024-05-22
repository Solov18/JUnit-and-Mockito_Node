package com.example.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class NoteServiceTest {
    @InjectMocks
    private NoteService noteService;
    @Mock
    private NoteRepository noteRepository;
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void getAllNotesTest() {
        Note note = new Note();
        note.setTitle("Test Title");
        note.setContent("Test Content");
        List<Note> expectedNotes = Collections.singletonList(note);
        when(noteRepository.findAll()).thenReturn(expectedNotes);
        List<Note> actualNotes = noteService.getAllNotes();
        assertEquals(expectedNotes, actualNotes);
    }
// ... Другие тесты для методов сервиса
}
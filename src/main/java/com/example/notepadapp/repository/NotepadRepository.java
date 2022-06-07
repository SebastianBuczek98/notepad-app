package com.example.notepadapp.repository;

import com.example.notepadapp.model.NoteEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NotepadRepository {

    private List<NoteEntity> notesList = new ArrayList<>();
    private Long currentNoteId = 1L;

    public List<NoteEntity> getAllNotes() {
        return this.notesList;
    }

    public void removeNote(Long noteId) {
        NoteEntity noteEntity = notesList.stream().filter(note -> note.getNoteId().equals(noteId)).findFirst().orElseThrow(() -> new RuntimeException("Note not found"));
        notesList.remove(noteEntity);
    }

    public Long addNote(NoteEntity noteEntity) {
        noteEntity.setNoteId(this.currentNoteId);
        notesList.add(noteEntity);
        return this.currentNoteId++;
    }

    public void updateNote(NoteEntity noteEntity) {
        NoteEntity oldNoteEntity = getNoteById(noteEntity.getNoteId());
        notesList.set(notesList.indexOf(oldNoteEntity), noteEntity);
    }

    public NoteEntity getNoteById(Long noteId) {
        return notesList.stream().filter(note -> note.getNoteId().equals(noteId)).findFirst().orElseThrow(() -> new RuntimeException("Note not found"));
    }

}

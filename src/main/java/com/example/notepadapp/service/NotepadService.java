package com.example.notepadapp.service;

import com.example.notepadapp.model.NoteEntity;
import com.example.notepadapp.model.dto.EditNoteDto;
import com.example.notepadapp.model.dto.FullNoteDto;
import com.example.notepadapp.model.dto.NoteDto;
import com.example.notepadapp.repository.NotepadRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
@AllArgsConstructor
public class NotepadService {

    private final NotepadRepository repository;

    public List<NoteEntity> getAllNotes() {
        return repository.getAllNotes();
    }

    public void removeNote(Long noteId) {
        repository.removeNote(noteId);
    }

    public Long addNote(NoteDto noteDto) {
        NoteEntity noteEntity = NoteEntity.builder()
                .title(noteDto.getTitle())
                .body(noteDto.getBody())
                .creationDate(LocalDateTime.now())
                .priority(noteDto.isPriority())
                .build();
        return repository.addNote(noteEntity);
    }

    public void editNote(EditNoteDto editNoteDto) {
        NoteEntity noteEntity = NoteEntity.builder()
                .noteId(editNoteDto.getNoteId())
                .title(editNoteDto.getTitle())
                .body(editNoteDto.getBody())
                .build();
        repository.updateNote(noteEntity);
    }

    public FullNoteDto getNoteById(Long noteId) {
        NoteEntity noteEntity = repository.getNoteById(noteId);
        return FullNoteDto.builder()
                .noteId(noteEntity.getNoteId())
                .title(noteEntity.getTitle())
                .body(noteEntity.getBody())
                .creationDate(noteEntity.getCreationDate().format(DateTimeFormatter.ISO_DATE_TIME))
                .priority(noteEntity.isPriority())
                .build();
    }

}

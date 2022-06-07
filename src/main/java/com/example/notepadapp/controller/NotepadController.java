package com.example.notepadapp.controller;

import com.example.notepadapp.model.NoteEntity;
import com.example.notepadapp.model.dto.EditNoteDto;
import com.example.notepadapp.model.dto.FullNoteDto;
import com.example.notepadapp.model.dto.NoteDto;
import com.example.notepadapp.service.NotepadService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/notes")
@AllArgsConstructor
public class NotepadController {

    private final NotepadService service;

    @GetMapping(path = "/getAllNotes")
    public ResponseEntity<List<NoteEntity>> getAllNotes() {
        return ResponseEntity.ok(service.getAllNotes());
    }

    @DeleteMapping(path = "/removeNote")
    public ResponseEntity<?> removeNote(@RequestParam Long noteId) {
        service.removeNote(noteId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(path = "/addNote")
    public ResponseEntity<Long> addNote(@RequestBody NoteDto noteDto) {
        return ResponseEntity.ok(service.addNote(noteDto));
    }

    @PutMapping(path = "/editNote")
    public ResponseEntity<?> editNote(@RequestBody EditNoteDto editoteDto) {
        service.editNote(editoteDto);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(path = "/getNoteById")
    public ResponseEntity<FullNoteDto> getNoteById(@RequestParam Long noteId) {
        return ResponseEntity.ok(service.getNoteById(noteId));
    }


}

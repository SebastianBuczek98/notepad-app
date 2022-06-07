package com.example.notepadapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class NoteEntity {

    private Long noteId;
    private String title;
    private String body;
    private LocalDateTime creationDate;
    private boolean priority;

}

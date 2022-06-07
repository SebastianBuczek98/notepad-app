package com.example.notepadapp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FullNoteDto {
    private Long noteId;
    private String title;
    private String body;
    private String creationDate;
    private boolean priority;
}

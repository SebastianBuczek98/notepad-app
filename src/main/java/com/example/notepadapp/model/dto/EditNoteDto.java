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
public class EditNoteDto {

    private Long noteId;
    private String title;
    private String body;
    private boolean priority;

}

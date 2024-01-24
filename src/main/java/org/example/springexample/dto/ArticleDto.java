package org.example.springexample.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import java.time.LocalDateTime;
import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ArticleDto {
    Long id;
    String title;
    String content;
    LocalDateTime creationTime;
    List<CommentDto> comments;
}
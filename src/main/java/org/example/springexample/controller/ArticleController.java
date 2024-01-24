package org.example.springexample.controller;

import lombok.RequiredArgsConstructor;
import org.example.springexample.dto.ArticleDto;
import org.example.springexample.service.ArticleCrudService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@RestController
@RequestMapping("/article")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleCrudService articleCrudService;
    @GetMapping
    public ResponseEntity<Collection<ArticleDto>> getAllArticle() {
        Collection<ArticleDto> articles = articleCrudService.getAll();
        return ResponseEntity.ok(articles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleDto> getArticleById(@PathVariable Integer id) {
        ArticleDto articleDto = articleCrudService.getById(id);
        return ResponseEntity.ok(articleDto);
    }

    @PostMapping
    public ResponseEntity<ArticleDto> createArticle(@RequestBody ArticleDto articleDto) {
        articleCrudService.create(articleDto);
        return new ResponseEntity<>(articleDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArticleDto> updateArticle(@RequestBody ArticleDto articleDto) {
        articleCrudService.create(articleDto);
        return new ResponseEntity<>(articleDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ArticleDto> deleteArticle(@PathVariable Integer id) {
        articleCrudService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
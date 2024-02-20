package com.example.books.directory.controllers;

import com.example.books.directory.entities.Book;
import com.example.books.directory.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class BooksController {
    private final BookService bookService;
    @GetMapping("/")
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable Integer id) {
        Optional<Book> book = bookService.getBookById(id);
        if (book.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(book.get());
    }
    @PostMapping("/")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        return ResponseEntity.ok(bookService.createBook(book));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBookById(@PathVariable Integer id, @RequestBody Book book) {
        Book updatedBook = bookService.updateBookById(id, book);
        if (updatedBook == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedBook);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id) {
        bookService.deleteBookById(id);
        return ResponseEntity.noContent().build();
    }
}

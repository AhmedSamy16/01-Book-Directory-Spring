package com.example.books.directory.repository;

import com.example.books.directory.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Book, Integer> {
}

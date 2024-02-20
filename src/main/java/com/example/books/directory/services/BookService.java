package com.example.books.directory.services;

import com.example.books.directory.entities.Book;
import com.example.books.directory.repository.BooksRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BooksRepository booksRepo;
    public Book createBook(Book book) {
        return booksRepo.save(book);
    }
    public List<Book> getAllBooks() {
        return booksRepo.findAll();
    }
    public Optional<Book> getBookById(Integer id) {
        return booksRepo.findById(id);
    }
    public Book updateBookById(Integer id, Book book) {
        Optional<Book> existedBook = booksRepo.findById(id);
        if (existedBook.isEmpty()) {
            return null;
        }
        Book b = existedBook.get();
        b.setTitle(book.getTitle());
        b.setAuthor(book.getAuthor());
        return booksRepo.save(b);
    }
    public void deleteBookById(Integer id) {
        booksRepo.deleteById(id);
    }
}

package com.example.buoi2.Service;

import com.example.buoi2.Model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private List<Book> books = new ArrayList<>();

    public BookService() {
        // Initialize with some data
        books.add(new Book(1, "Think and Grow Rich", "Napoleon Hill"));
        books.add(new Book(2, "Rich Dad Poor Dad", "Robert Kiyosaki"));
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public Optional<Book> getBookById(int id) {
        return books.stream().filter(book -> book.getId() == id).findFirst();
    }

    public Book addBook(Book book) {
        books.add(book);
        return book;
    }

    public Book updateBook(int id, Book bookDetails) {
        Optional<Book> bookOptional = getBookById(id);
        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            book.setTitle(bookDetails.getTitle());
            book.setAuthor(bookDetails.getAuthor());
            return book;
        }
        return null;
    }

    public boolean deleteBook(int id) {
        return books.removeIf(book -> book.getId() == id);
    }
}

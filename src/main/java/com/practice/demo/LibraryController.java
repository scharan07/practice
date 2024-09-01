package com.practice.demo;

import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/books")
public class LibraryController {
    List<Book> books =new ArrayList<>();

    public LibraryController()
    {
        books.add(new Book(1, "B1", "A1", "C1"));
        books.add(new Book(2, "B2", "A2", "C2"));
        books.add(new Book(3, "B3", "A3", "C3"));
    }


    @GetMapping
    public List<Book> getAllBooks() {
        return books;
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        OptionalInt id = books.stream().mapToInt(Book::getId).max();
        int newId = id.isPresent() ? id.getAsInt() + 1 : 1;
        book.setId(newId);
        books.add(book);

        return book;
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Integer id, @RequestBody Book book) {
        int index = IntStream.range(0, books.size()).filter(i -> books.get(i).getId() == id).findFirst().orElse(-1);

        if (id > -1) {
            book.setId(id);
            books.set(index, book);
        }
        return book;
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Integer id) {
        int index = IntStream.range(0, books.size()).filter(i -> books.get(i).getId() == id).findFirst().orElse(-1);
        if (index > -1) {
            books.remove(index);
        }
    }
}

class Book {
    private int id;
    private String title;
    private String author;
    private String category;

    public Book(int id, String title, String author, String category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

class Author {
    private int id;
    private String name;
}
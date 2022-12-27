package com.example.borrow_books.service.impl;
import com.example.borrow_books.model.Book;
import com.example.borrow_books.repository.IBookRepository;
import com.example.borrow_books.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBookService {

    @Autowired
    private IBookRepository bookRepository;

    @Override
    public Book findByIdBook(Integer id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public Book findByCode(long code) {
        return bookRepository.findByCode(code);
    }

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(int id) {
        return bookRepository.findById(id);
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void remove(int id) {
        bookRepository.deleteById(id);
    }
}

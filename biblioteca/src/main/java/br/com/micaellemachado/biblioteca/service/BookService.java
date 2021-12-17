package br.com.micaellemachado.biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.micaellemachado.biblioteca.model.Book;
import br.com.micaellemachado.biblioteca.model.Genre;
import br.com.micaellemachado.biblioteca.repository.BookRepository;

@Service
public class BookService {
    @Autowired
    private BookRepository repository;

    public Book insertOrUpdate(Book book) {
        return repository.save(book);
    }

    public List<Book> findAll() {
        return repository.findAll();
    }

    public boolean delete(int id) {
        var book = repository.findById(id);

        if (book.isPresent()) {
            repository.deleteById(id);
            book = repository.findById(id);
            return book.isEmpty();
        }
        return false;
    }

    public Book findByName(String name) {
        var book = repository.findByNameContains(name);
        if (book.isPresent()) {
            return book.get();
        }
        return new Book();
    }

    public List<Book> findByAuthor(String author) {
        return repository.findByAuthor(author);
    }

    public List<Book> findByPublishing(String name) {
        return repository.findByPublishing(name);
    }

    public List<Book> findByYearOfPublication(int year) {
        return repository.findByYearOfPublication(year);
    }

    public List<Book> findByGenre(Genre genre) {
        return repository.findByGenre(genre);
    }

    public Optional<Book> findById(int id) {
        return repository.findById(id);
    }
}

package br.com.micaellemachado.biblioteca.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.micaellemachado.biblioteca.model.Book;
import br.com.micaellemachado.biblioteca.model.Genre;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    public Optional<Book> findByNameContains(String name);

    public List<Book> findByAuthor(String author);

    public List<Book> findByYearOfPublication(int year);

    public List<Book> findByPublishing(String name);

    public List<Book> findByGenre(Genre genre);
}

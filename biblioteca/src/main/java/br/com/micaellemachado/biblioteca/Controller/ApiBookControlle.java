package br.com.micaellemachado.biblioteca.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.micaellemachado.biblioteca.model.dto.BookDTO;
import br.com.micaellemachado.biblioteca.service.BookService;
import br.com.micaellemachado.biblioteca.util.BookMapping;

@RestController
@RequestMapping("/api/books")
public class ApiBookControlle {
    @Autowired
    private BookService service;

    @PostMapping
    public ResponseEntity<BookDTO> insert(@RequestBody BookDTO dto) {
        if (dto.getId() != 0)
            return new ResponseEntity<>(new BookDTO(), HttpStatus.BAD_REQUEST);

        var book = service.insertOrUpdate(
                BookMapping.toBook(dto));

        if (book != null)
            return new ResponseEntity<>(
                    BookMapping.fromBook(book), HttpStatus.CREATED);
        return new ResponseEntity<>(new BookDTO(), HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public ResponseEntity<BookDTO> update(@RequestBody BookDTO dto) {
        if (dto.getId() < 1)
            return new ResponseEntity<>(new BookDTO(), HttpStatus.BAD_REQUEST);

        var book = service.findById(dto.getId());

        if (book.isPresent())
            return new ResponseEntity<>(
                    BookMapping.fromBook(
                            service.insertOrUpdate(
                                    BookMapping.toBook(dto))),
                    HttpStatus.OK);
        return new ResponseEntity<>(new BookDTO(), HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<BookDTO>> findAll() {
        return new ResponseEntity<>(
                service.findAll().stream().map(
                        (obj) -> BookMapping.fromBook(obj)).collect(Collectors.toList()),
                HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        var book = service.findById(id);
        if (book.isPresent()) {
            var isSuccess = service.delete(id);

            if (isSuccess)
                return new ResponseEntity<>("Livro removido com sucesso!!!", HttpStatus.OK);
            return new ResponseEntity<>("Não foi possível remover o livro!!!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Livro não localizado!!!", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/author/{name}")
    public ResponseEntity<List<BookDTO>> findByAuthor(@PathVariable String name) {
        return new ResponseEntity<>(
                service.findByAuthor(name).stream().map(
                        (obj) -> BookMapping.fromBook(obj)).collect(Collectors.toList()),
                HttpStatus.OK);
    }
}

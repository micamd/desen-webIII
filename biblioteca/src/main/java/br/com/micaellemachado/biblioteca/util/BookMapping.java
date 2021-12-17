package br.com.micaellemachado.biblioteca.util;

import br.com.micaellemachado.biblioteca.model.Book;
import br.com.micaellemachado.biblioteca.model.dto.BookDTO;

public class BookMapping {
    private BookMapping() {
    }

    public static BookDTO fromBook(Book book) {
        return new BookDTO(book.getId(), book.getName(), book.getAuthor(), book.getPublishing(),
                book.getYearOfPublication(),
                book.getGenre());
    }

    public static Book toBook(BookDTO dto) {
        return new Book(dto.getId(), dto.getName(), dto.getAuthor(), dto.getPublishing(), dto.getYearOfPublication(),
                dto.getGenre());
    }
}

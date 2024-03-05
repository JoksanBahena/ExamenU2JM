package com.example.examenu2jm.services;

import com.example.examenu2jm.models.book.Book;
import com.example.examenu2jm.models.book.BookRepository;
import com.example.examenu2jm.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookService {
    @Autowired
    private BookRepository repository;

    @Transactional(readOnly = true)
    public CustomResponse<List<Book>> getAll() {
        return new CustomResponse<>(
                this.repository.findAll(),
                false,
                200,
                "ok"
        );
    }

    @Transactional(readOnly = true)
    public CustomResponse<Book> getById(Long id) {
        if (!this.repository.existsById(id)) {
            return new CustomResponse<>(
                    null,
                    true,
                    404,
                    "No se encontro el libro"
            );
        }

        return new CustomResponse<>(
                this.repository.findById(id).get(),
                false,
                200,
                "ok"
        );
    }

    @Transactional(readOnly = true)
    public CustomResponse<List<Book>> getBooksByPublicationDate() {
        return new CustomResponse<>(
                this.repository.getBookByPublication_date(),
                false,
                200,
                "ok"
        );
    }

    @Transactional(rollbackFor = {Exception.class})
    public CustomResponse<Book> insert(Book book) {
        return new CustomResponse<>(
                this.repository.saveAndFlush(book),
                false,
                200,
                "Se registro el libro"
        );
    }

    @Transactional(rollbackFor = {Exception.class})
    public CustomResponse<String> update(Book book) {
        if (!this.repository.existsById(book.getId())) {
            return new CustomResponse<>(
                    null,
                    true,
                    404,
                    "No se encontro el libro"
            );
        }
        this.repository.saveAndFlush(book);
        return new CustomResponse<>(
                null,
                false,
                200,
                "Se actualizo la informacion del libro"
        );
    }

    @Transactional(rollbackFor = {Exception.class})
    public CustomResponse<String> delete(Long id) {
        if (!this.repository.existsById(id)) {
            return new CustomResponse<>(
                    null,
                    true,
                    404,
                    "No se encontro el libro"
            );
        }

        this.repository.deleteById(id);
        return new CustomResponse<>(
                null,
                false,
                200,
                "Se elimino el libro"
        );
    }
}

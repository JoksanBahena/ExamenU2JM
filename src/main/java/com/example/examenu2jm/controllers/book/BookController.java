package com.example.examenu2jm.controllers.book;

import com.example.examenu2jm.controllers.book.dtos.BookDto;
import com.example.examenu2jm.models.book.Book;
import com.example.examenu2jm.services.BookService;
import com.example.examenu2jm.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = {"*"})
public class BookController {
    @Autowired
    private BookService service;

    @GetMapping("/")
    public ResponseEntity<CustomResponse<List<Book>>> getAll() {
        return new ResponseEntity<>(this.service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomResponse<Book>> getMovieById(@PathVariable long id) {
        return new ResponseEntity<>(this.service.getById(id), HttpStatus.OK);
    }

    @GetMapping("/getByPublicateDate")
    public ResponseEntity<CustomResponse<List<Book>>> getBooksByPublicateDate() {
        return new ResponseEntity<>(this.service.getBooksByPublicationDate(), HttpStatus.OK);
    }

    @GetMapping("/author/{author}")
    public ResponseEntity<CustomResponse<List<Book>>> findByAuthor(@Valid @PathVariable String author) {
        return new ResponseEntity<>(this.service.findByAuthor(author), HttpStatus.OK);
    }

    @GetMapping("/getByImage")
    public ResponseEntity<CustomResponse<List<Book>>> getBooksByImage() {
        return new ResponseEntity<>(this.service.getBooksByImage(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<CustomResponse<Book>> insert(@Valid @RequestBody BookDto bookDto) {
        return new ResponseEntity<>(this.service.insert(bookDto.castToBook()), HttpStatus.CREATED);
    }

    @PutMapping("/{id:[0-9]+}")
    public ResponseEntity<CustomResponse<String>> update(@Valid @PathVariable long id, @RequestBody BookDto bookDto) {
        bookDto.setId(id);
        return new ResponseEntity<>(this.service.update(bookDto.castToBook()), HttpStatus.OK);
    }

    @DeleteMapping("/{id:[0-9]+}")
    public ResponseEntity<CustomResponse<String>> delete(@PathVariable long id) {
        return new ResponseEntity<>(this.service.delete(id), HttpStatus.OK);
    }
}

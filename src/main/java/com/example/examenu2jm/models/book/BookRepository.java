package com.example.examenu2jm.models.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    boolean existsById(Long id);
    boolean existsByAuthor(String author);
    List<Book> findByAuthor(String author);

    @Query(
            value = "select * from books ORDER BY publication_date DESC", nativeQuery = true
    )
    List<Book> getBookByPublication_date();

    @Query(
            value = "SELECT * FROM books WHERE image_book IS NOT NULL", nativeQuery = true
    )
    List<Book> getBookByImage_book();
}

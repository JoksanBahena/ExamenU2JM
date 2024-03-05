package com.example.examenu2jm.models.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    boolean existsById(Long id);

    @Query(
            value = "select * from books ORDER BY publication_date DESC", nativeQuery = true
    )
    List<Book> getBookByPublication_date();
}

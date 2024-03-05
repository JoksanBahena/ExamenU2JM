package com.example.examenu2jm.models.book;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@Table(name = "books")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "author", nullable = false, length = 255)
    private String author;

    @Column(name = "publicate_date", nullable = false)
    private Date publicate_date;

    @Column(name = "image_book", nullable = true)
    private String image_book;
}

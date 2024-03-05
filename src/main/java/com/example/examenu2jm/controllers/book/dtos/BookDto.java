package com.example.examenu2jm.controllers.book.dtos;

import com.example.examenu2jm.models.book.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
public class BookDto {
    public BookDto(){
    }

    private Long id;

    @NotEmpty(message = "Campo obligatorio")
    @Size(max = 100, message = "El nombre debe tener máximo de 100 caracteres")
    private String name;

    @NotEmpty(message = "Campo obligatorio")
    @Size(max = 60, message = "El nombre del autor debe tener máximo 60 caracteres")
    private String author;

    @NotEmpty(message = "Campo obligatorio")
    private Date publicate_date;

    private String image_book;

    public Book castToBook() {
        return new Book(getId(), getName(), getAuthor(), getPublicate_date(), getImage_book());
    }
}

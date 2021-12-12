package com.github.PriAlves.libraryapi.service;

import com.github.PriAlves.libraryapi.model.entity.Book;
import com.github.PriAlves.libraryapi.model.repository.BookRepository;
import com.github.PriAlves.libraryapi.service.impl.BookServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.assertj.core.api.Assertions;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class BookServiceTest {

    BookService service;

    @MockBean //mock implementação
    BookRepository repository;

    @BeforeEach // para ser executada antes de cada teste unitario
    public void setUp(){
        this.service = new BookServiceImpl( repository );
    }

    @Test
    @DisplayName("Deve Salvar um livro")
    public void saveBookTest(){
        //cenário
        Book bookTesteMockito = Book.builder().isbn("123").author("Fulano").title("As aventuras").build();
        Mockito.when(repository.save(bookTesteMockito)).thenReturn(
                Book.builder().id(1l)
                        .isbn("123")
                        .author("Fulano")
                        .title("As aventuras").build());

        //execução
        Book savedBook = service.save(bookTesteMockito);

        //verificação
        assertThat(savedBook.getId()).isNotNull();
        assertThat(savedBook.getIsbn()).isEqualTo("123");
        assertThat(savedBook.getAuthor()).isEqualTo("Fulano");
        assertThat(savedBook.getTitle()).isEqualTo("As aventuras");
    }
}

package com.github.PriAlves.libraryapi.model.repository;

import com.github.PriAlves.libraryapi.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> //entidade book e chave primeria que é um ID long
 {


}

package com.api.book.bootrestbook.dao;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.api.book.bootrestbook.entities.Book;

public interface BookRepository extends CrudRepository<Book,Integer>{
      public Optional<Book> findById(int id);
      
      //public Book findById(int id);


}

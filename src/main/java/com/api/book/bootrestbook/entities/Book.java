package com.api.book.bootrestbook.entities;

import jakarta.persistence.Version;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity

@Table(name="books") 
public class Book {
   
   @Id
   //for Auto Increment //
   //@GeneratedValue(strategy = GenerationType.AUTO)
  // @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name="book_id")
  
   @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;   
    private String title;  
    //private String author;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id", nullable = false)
    
    @JsonManagedReference
    private Author author;

    @Version
    private Integer version;

    public Book(int id, String title, Author author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public Book(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", author=" + author + "]";
    }
   
    


}

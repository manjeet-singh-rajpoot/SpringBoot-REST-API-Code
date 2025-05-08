package com.api.book.bootrestbook.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
     private int authorid;
     private String firstname;
     private String lastname;
     private String language;

     @OneToOne(mappedBy = "author")
     @JsonBackReference
     private Book book;
     
    //  public Author(int authorid, String firstname, String lastname, String language) {
    //     this.authorid = authorid;
    //     this.firstname = firstname;
    //     this.lastname = lastname;
    //     this.language = language;
    // }

    // public Author(){
        
    // }

     public int getAuthorid() {
         return authorid;
     }
     public void setAuthorid(int authorid) {
         this.authorid = authorid;
     }
     public String getFirstname() {
         return firstname;
     }
     public void setFirstname(String firstname) {
         this.firstname = firstname;
     }
     public String getLastname() {
         return lastname;
     }
     public void setLastname(String lastname) {
         this.lastname = lastname;
     }
     public String getLanguage() {
         return language;
     }
     public void setLanguage(String language) {
         this.language = language;
     }
     public Book getBook() {
         return book;
     }
     public void setBook(Book book) {
         this.book = book;
     }

    //  @Override
    //  public String toString() {
    //     return "Author [authorid=" + authorid + ", firstname=" + firstname + ", lastname=" + lastname + ", language="
    //             + language + ", getAuthorid()=" + getAuthorid() + ", getFirstname()=" + getFirstname()
    //             + ", getLastname()=" + getLastname() + ", getLanguage()=" + getLanguage() + ", getClass()=" + getClass()
    //             + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
    //  }





}

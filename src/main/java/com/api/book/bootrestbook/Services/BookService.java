package com.api.book.bootrestbook.Services;

//import java.util.ArrayList;
import java.util.List;
//import java.util.stream.Collector;
//import java.util.stream.Collectors;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entities.Book;

import jakarta.transaction.Transactional;

@Component
@Service
@Transactional
public class BookService {
   
     //private static List<Book> list = new ArrayList<>();

    // static {
         // list.add(new Book(1234,"complete java reference","Mr. Manjeet"));
         // list.add(new Book(5678,"complete Python reference","Mr. Arjun"));
         // list.add(new Book(9123,"complete C# reference","Mr. Kapil"));

    // }
   
    @Autowired
    private BookRepository bookReposotory;

    // get allBooks
    public List<Book> getAllBooks() {
        //return list;  //without database connectivity
         
        //with database connectivity
     List<Book>list=(List<Book>)this.bookReposotory.findAll();

     return list;
      
    }
    // getSingle Book

    public Optional<Book> getBookById(int id){
      //Book book=null;
     
      //book=list.stream().filter(e->e.getId()==id).findFirst().get();
       
      Optional<Book>book = this.bookReposotory.findById(id);
      return book;
}
    // Adding the Book //
    public Book addBook(Book b) {
        // list.add(b);  //without db connect
        // return b;

        //after db connect//
       Book result=this.bookReposotory.save(b);
    System.out.print("Successfully added..");
       return result;

       

    }
 
  
    public void deleteBook(int id) {
        // list = list.stream().filter(book -> {
        //     if (book.getId() != id) {
        //         return true;
        //     } else {
        //         return false;
        //     }
        // }).collect(Collectors.toList());
       
        bookReposotory.deleteById(id);


    }

    //public void updateBook(Book book, int id) {
        // list = list.stream().map(b -> {
        //     if (b.getId() == id) {
        //         b.setTitle(book.getTitle());
        //         b.setAuthor(book.getAuthor());
        //     }
        //     return b;
        // }).collect(Collectors.toList());

              //After database connectivity//

       // book.setId(id);
       // bookReposotory.save(book);
    
        
    //     book.setId(id);
    //     bookReposotory.save(book);
    //     return book;
       
    public Book updateBook(Book book, int id) {
        Optional<Book> existingBook = bookReposotory.findById(id);
        if (existingBook.isPresent()) {
            Book updatedBook = existingBook.get();
            updatedBook.setTitle(book.getTitle());
            updatedBook.setAuthor(book.getAuthor());
            return bookReposotory.save(updatedBook);  // Ensures proper update
        } else {
            throw new RuntimeException("Book not found with ID: " + id);
        }
    }
    

 }

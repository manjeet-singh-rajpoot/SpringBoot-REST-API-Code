package com.api.book.bootrestbook.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.api.book.bootrestbook.Services.BookService;
import com.api.book.bootrestbook.entities.Book;

//import org.slf4j.LoggerFactory;

@RestController
// @Controller
public class BookController {

    @Autowired
    private BookService bookService;

    // @RequestMapping(value = "/books", method = RequestMethod.GET)
    @GetMapping("/books")
    // @PostMapping("/books") for PostMethod
    // DeleteMapping("/books") for DeleteMethod
    // PutMapping("/books") for PutMethod

    public ResponseEntity<List<Book>> getBooks() {

        // Book book=new Book();
        // book.setId(1234);
        // book.setTitle("java Complete Reference....");
        // book.setAuthor("Mr. Manjeet");

        //return this.bookService.getAllBooks();
  try{
    List<Book>list=bookService.getAllBooks();

    if(list.size() <= 0){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    return ResponseEntity.status(HttpStatus.CREATED).body(list);
  }catch(Exception e){
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
  }
       

    }
         
        //1.Read operation//
    @GetMapping("/books/{id}")
    public ResponseEntity<Optional<Book>>getBook(@PathVariable int id) {
        //return bookService.getBookById(id);
        //Book book=bookService.getBookById(id);
          Optional<Book>book=bookService.getBookById(id);
        if(book == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.of(Optional.of(book));

    }

           //2.Create operation//
    @PostMapping("/books")
    public ResponseEntity<Book>addBook(@RequestBody Book book) {
       // Book b =  null;
        try{
            Book b=this.bookService.addBook(book);
            //return ResponseEntity.of(Optional.of(b));
            return ResponseEntity.status(HttpStatus.CREATED).body(b);
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
         //3.delete operation//
    @DeleteMapping("/books/{id}")

    public ResponseEntity<Void>deleteBook(@PathVariable("id") int id){


        try {
            this.bookService.deleteBook(id);
          System.out.println(id +"  "+"Deleted successfully....");
          return ResponseEntity.ok().build();
        } catch (Exception e) {
       
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }  

    }

        //4.update operation //
 
        @PutMapping("/books/{id}")
    
  public   ResponseEntity<Book> updateBook(@RequestBody Book book,@PathVariable("id") int id){
              
          try {
            this.bookService.updateBook(book,id);
            return ResponseEntity.ok().body(book);
          } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
          }            
        }



   
}

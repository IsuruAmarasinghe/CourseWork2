/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.courseWork2.controller;

import edu.ijse.courseWork2.dto.BookDto;
import edu.ijse.courseWork2.service.ServiceFactory;
import edu.ijse.courseWork2.service.custom.BookService;
import java.util.ArrayList;

/**
 *
 * @author Isuru Manchanayake
 */
public class BookController {
    
    private BookService bookService = (BookService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.BOOK);
    
    
     public String save(BookDto bookDto)throws Exception{
       return bookService.save(bookDto);
    }
     
      public String update(BookDto bookDto)throws Exception{
       return bookService.update(bookDto);
    }
    
    public String delete(String bookID)throws Exception{
       return bookService.delete(bookID);
    }
    
     public ArrayList<BookDto>getAll()throws Exception{
      return bookService.getAll();
    }
    
    public BookDto get(String bookID)throws Exception{
      return bookService.get(bookID);
    }
}

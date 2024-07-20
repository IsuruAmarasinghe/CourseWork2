/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.courseWork2.service.custom.impl;

import edu.ijse.courseWork2.dao.DaoFactory;
import edu.ijse.courseWork2.dao.custom.BookDao;
import edu.ijse.courseWork2.dto.BookDto;
import edu.ijse.courseWork2.entity.BookEntity;
import edu.ijse.courseWork2.service.custom.BookService;
import java.util.ArrayList;

/**
 *
 * @author Isuru Manchanayake
 */
public class BookServiceImpl implements BookService{
    
    private BookDao bookDao = (BookDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.BOOK);

    @Override
    public String save(BookDto bookDto) throws Exception {
        BookEntity entity = getBookEntity(bookDto);
        return bookDao.create(entity)? "Success" : "Fail";
    }

    @Override
    public String update(BookDto bookDto) throws Exception {
        BookEntity entity = getBookEntity(bookDto);
        return bookDao.update(entity)? "Success" : "Fail";
    }

    @Override
    public String delete(String bookID) throws Exception {
        return bookDao.delete(bookID)? "Success" : "Fail";
    }

    @Override
    public BookDto get(String bookID) throws Exception {
        BookEntity entity = bookDao.get(bookID);
         if(entity != null){
           return getBookDto(entity);
         }
         return null;
    }

    @Override
    public ArrayList<BookDto> getAll() throws Exception {
       ArrayList<BookEntity>bookEntitys = bookDao.getAll();
      if(bookEntitys != null && !bookEntitys.isEmpty()){
        ArrayList<BookDto>bookDtos = new ArrayList<>();
        
          for (BookEntity entity : bookEntitys) {
            bookDtos.add(getBookDto(entity));
              
          }
           return bookDtos;   
          }
        return null;
      }

    private BookEntity getBookEntity(BookDto bookDto) {
          return new BookEntity(
            bookDto.getBookID(),
            bookDto.getBookName(),
            bookDto.getAuthor(),
            bookDto.getPublisher(),
            bookDto.getPublicationYear(),
            bookDto.getCategoryID(),
            bookDto.getQty());
           
    }

    private BookDto getBookDto(BookEntity entity) {
         return new BookDto(
             entity.getBookID(),
           entity.getBookName(),
            entity.getAuthor(),
            entity.getPublisher(),
            entity.getPublicationYear(),
            entity.getCategoryID(),
            entity.getQty()); 
        
    
    }

      
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.courseWork2.service.custom.impl;

import edu.ijse.courseWork2.dao.custom.ReturnBookDao;
import edu.ijse.courseWork2.dto.ReturnBookDto;
import edu.ijse.courseWork2.dto.TransactionDto;
import edu.ijse.courseWork2.service.custom.ReturnBookService;
import java.util.ArrayList;
import edu.ijse.courseWork2.dao.DaoFactory;
import edu.ijse.courseWork2.dao.custom.BookDao;
import edu.ijse.courseWork2.dao.custom.TransactionDao;
import edu.ijse.courseWork2.db.DBConnection;
import edu.ijse.courseWork2.entity.ReturnBookEntity;
import edu.ijse.courseWork2.entity.BookEntity;
import java.sql.Connection;

/**
 *
 * @author Isuru Manchanayake
 */
public class ReturnBookServiceImpl implements ReturnBookService{
     private ReturnBookDao returnBookDao = (ReturnBookDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.RETURNBOOK);
     private TransactionDao transactionDao = (TransactionDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.TRANSACTION);
     private BookDao bookDao = (BookDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.BOOK);

    @Override
    public String save(ReturnBookDto returnBookDto) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        
        
        try {
            connection.setAutoCommit(false);
            
            ReturnBookEntity returnBookEntity = new ReturnBookEntity(
                   returnBookDto.getTransactionId(),
                   returnBookDto.getBorrowDate(),
                   returnBookDto.getDuedate(),
                   returnBookDto.getReturnDate(),
                   returnBookDto.getFine(),
                   returnBookDto.getBookId(),
                   returnBookDto.getQty()
            );
                   

            //save returnBook
            if (returnBookDao.create(returnBookEntity)) {
                
                BookEntity bookEntity = bookDao.get(returnBookDto.getBookId());
                
                if (bookEntity != null) {
                    // Update the book quantity
                    bookEntity.setQty(bookEntity.getQty() + returnBookEntity.getQty());
                    
                    if (bookDao.update(bookEntity)) {
                        connection.commit();
                        return "Success";
                    } else {
                        connection.rollback();
                        return "Book Update Error";
                    }
                } else {
                    connection.rollback();
                    return "Book Not Found";
                }
            } else {
                connection.rollback();
                return "Transaction Save Error";
            }
        } catch (Exception e) {
            connection.rollback();
            e.printStackTrace();
            throw e;
        } finally {
            connection.setAutoCommit(true);
        }
    }

    @Override
    public String update(ReturnBookDto returnBookDto) throws Exception {
         return null;
    }

    @Override
    public String delete(String transactionId) throws Exception {
       return returnBookDao.delete(transactionId)? "Success" : "Fail";
    }

    @Override
    public ReturnBookDto get(String transactionId) throws Exception {
         ReturnBookEntity entity = returnBookDao.get(transactionId);
         if(entity != null){
           return getReturnBookDto(entity);
         }
         return null;
    }

    @Override
    public ArrayList<ReturnBookDto> getAll() throws Exception {
         ArrayList<ReturnBookEntity>returnBookEntitys = returnBookDao.getAll();
      if(returnBookEntitys != null && !returnBookEntitys.isEmpty()){
        ArrayList<ReturnBookDto>returnBookDtos = new ArrayList<>();
        
          for (ReturnBookEntity entity : returnBookEntitys) {
           returnBookDtos.add(getReturnBookDto(entity));
              
          }
           return returnBookDtos;   
          }
        return null;
      }

    private ReturnBookDto getReturnBookDto(ReturnBookEntity entity) {
            return new ReturnBookDto(
                    entity.getTransactionId(),
                    entity.getBorrowDate(),
                    entity.getDuedate(), 
                    entity.getReturnDate(),
                    entity.getFine(),
                    entity.getBookId(),
                    entity.getQty()
            );
    }

    private ReturnBookEntity getReturnBookEntity(ReturnBookDto returnBookDto) {
        return new ReturnBookEntity(
                returnBookDto.getTransactionId(), 
                returnBookDto.getBorrowDate(), 
                returnBookDto.getDuedate(),
                returnBookDto.getReturnDate(), 
                returnBookDto.getFine(),
                returnBookDto.getBookId(),
                returnBookDto.getQty()
        );
    }
    
}

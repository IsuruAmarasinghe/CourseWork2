/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.courseWork2.service.custom.impl;

import edu.ijse.courseWork2.dao.DaoFactory;
import edu.ijse.courseWork2.dao.custom.BookDao;
import edu.ijse.courseWork2.dao.custom.TransactionDao;
import edu.ijse.courseWork2.db.DBConnection;
import edu.ijse.courseWork2.dto.TransactionDto;
import edu.ijse.courseWork2.entity.BookEntity;
import edu.ijse.courseWork2.entity.TransactionEntity;
import edu.ijse.courseWork2.service.custom.TransactionService;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author Isuru Manchanayake
 */
public class TransactionServiceImpl implements TransactionService{
    
     private TransactionDao transactionDao = (TransactionDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.TRANSACTION);
     private BookDao bookDao = (BookDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.BOOK);

    @Override
    public String save(TransactionDto transactionDto) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();

        try {
            connection.setAutoCommit(false);
            
            TransactionEntity transactionEntity = new TransactionEntity(
                    transactionDto.getTransactionId(),
                    transactionDto.getMemberId(),
                    transactionDto.getBookId(),
                    transactionDto.getBorrowDate(),
                    transactionDto.getDueDate(),
                    transactionDto.getNoOfBook());

            // Save the transaction
            if (transactionDao.create(transactionEntity)) {
                BookEntity bookEntity = bookDao.get(transactionDto.getBookId());
                
                if (bookEntity != null) {
                    // Update the book quantity
                    bookEntity.setQty(bookEntity.getQty() - transactionDto.getNoOfBook());
                    
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
    public String update(TransactionDto transactionDto) throws Exception {
        TransactionEntity entity = getTransactionEntity(transactionDto);
        return transactionDao.update(entity)? "Success" : "Fail";
    }

    @Override
    public String delete(String transactionId) throws Exception {
        return transactionDao.delete(transactionId)? "Success" : "Fail";
    }

    @Override
    public TransactionDto get(String transactionId) throws Exception {
        TransactionEntity entity = transactionDao.get(transactionId);
         if(entity != null){
           return getTransactionDto(entity);
         }
         return null;
    }

    @Override
    public ArrayList<TransactionDto> getAll() throws Exception {
         ArrayList<TransactionEntity>transactionEntitys = transactionDao.getAll();
      if(transactionEntitys != null && !transactionEntitys.isEmpty()){
        ArrayList<TransactionDto>transactionDtos = new ArrayList<>();
        
          for (TransactionEntity entity : transactionEntitys) {
           transactionDtos.add(getTransactionDto(entity));
              
          }
           return transactionDtos;   
          }
        return null;
      }

    private TransactionEntity getTransactionEntity(TransactionDto transactionDto) {
        return new TransactionEntity(
                transactionDto.getTransactionId(),
                transactionDto.getMemberId(),
                transactionDto.getBookId(),
                transactionDto.getBorrowDate(),
                transactionDto.getDueDate(),
                transactionDto.getNoOfBook());
    }

    private TransactionDto getTransactionDto(TransactionEntity entity) {
        return new TransactionDto(
                entity.getTransactionId(),
                entity.getMemberId(),
                entity.getBookId(),
                entity.getBorrowDate(),
                entity.getDueDate(),
                entity.getNoOfBook());
    }
    
}

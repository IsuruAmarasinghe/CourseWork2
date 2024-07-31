/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.courseWork2.dao.custom.impl;

import edu.ijse.courseWork2.dao.CrudUtil;
import edu.ijse.courseWork2.dao.custom.ReturnBookDao;
import edu.ijse.courseWork2.entity.ReturnBookEntity;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Isuru Manchanayake
 */
public class ReturnBookDaoImpl implements ReturnBookDao{

    @Override
    public boolean create(ReturnBookEntity t) throws Exception {
       return CrudUtil.executeUpdate("INSERT INTO returnBook VALUES (?,?,?,?,?,?,?)",
                t.getTransactionId(), t.getBorrowDate(), t.getDuedate(), t.getReturnDate(), t.getFine(),t.getBookId(),t.getQty()
                );
    }

    @Override
    public boolean update(ReturnBookEntity t) throws Exception {
        return  false;
    }

    @Override
    public boolean delete(String id) throws Exception {
         return CrudUtil.executeUpdate("DELETE FROM returnBook WHERE transactionId = ?",id);
    }

    @Override
    public ReturnBookEntity get(String id) throws Exception {
       ResultSet rst = CrudUtil.executeQuery("SELECT * FROM returnBook WHERE transactionId=?", id);
        if(rst.next()){
         ReturnBookEntity entity;
           entity = new ReturnBookEntity(
                   rst.getString("transactionId"),
                   rst.getString("borrowDate"),
                   rst.getString("dueDate"),
                   rst.getString("returnDate"),
                   rst.getInt("fine"),
                   rst.getString("bookId"),
                   rst.getInt("qty")
                   );
             return entity;
        }
        return null;
    }

    @Override
    public ArrayList<ReturnBookEntity> getAll() throws Exception {
         ArrayList<ReturnBookEntity>returnBookEntitys=new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM returnBook");
        while(rst.next()){
       ReturnBookEntity entity;
            entity = new ReturnBookEntity(
                   rst.getString("transactionId"),
                   rst.getString("borrowDate"),
                   rst.getString("dueDate"),
                   rst.getString("returnDate"),
                   rst.getInt("fine"),
                   rst.getString("bookId"),
                   rst.getInt("qty"));
        
       returnBookEntitys.add(entity);
    }
        return returnBookEntitys;
    }
    
}

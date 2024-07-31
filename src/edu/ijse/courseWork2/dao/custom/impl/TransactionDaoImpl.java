/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.courseWork2.dao.custom.impl;

import edu.ijse.courseWork2.dao.CrudUtil;
import edu.ijse.courseWork2.dao.custom.TransactionDao;
import edu.ijse.courseWork2.entity.TransactionEntity;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author Isuru Manchanayake
 */
public class TransactionDaoImpl implements TransactionDao{

    @Override
    public boolean create(TransactionEntity t) throws Exception {
       return CrudUtil.executeUpdate("INSERT INTO transaction VALUES (?,?,?,?,?,?)",
               t.getTransactionId(),t.getMemberId(),t.getBookId(),t.getBorrowDate(),t.getDueDate(),t.getNoOfBook());
    }

    @Override
    public boolean update(TransactionEntity t) throws Exception {
        return CrudUtil.executeUpdate("UPDATE transaction SET memberId=?, bookId=?, borrowDate=?,  dueDate=?,  numOfBook=?  WHERE transactionId=?",
               t.getMemberId(),t.getBookId(),t.getBorrowDate(),t.getDueDate(),t.getNoOfBook(),t.getTransactionId());
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM transaction WHERE transactionId = ?",id);
    }

    @Override
    public TransactionEntity get(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM transaction WHERE transactionId=?", id);
        if(rst.next()){
          TransactionEntity entity;
           entity = new TransactionEntity(
                   rst.getString("transactionId"),
                   rst.getString("memberId"),
                   rst.getString("bookId"),
                   rst.getString("borrowDate"),
                   rst.getString("dueDate"),
                   rst.getInt("numOfBook"));
             return entity;
        }
        return null;
    }

    @Override
    public ArrayList<TransactionEntity> getAll() throws Exception {
       ArrayList<TransactionEntity>transactionEntitys=new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM transaction");
        while(rst.next()){
       TransactionEntity entity;
            entity = new TransactionEntity(
                  rst.getString("transactionId"),
                   rst.getString("memberId"),
                   rst.getString("bookId"),
                   rst.getString("borrowDate"),
                   rst.getString("dueDate"),
                   rst.getInt("numOfBook"));
        
       transactionEntitys.add(entity);
    }
        return transactionEntitys;
    }
    
}

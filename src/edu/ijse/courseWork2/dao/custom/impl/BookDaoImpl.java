/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.courseWork2.dao.custom.impl;

import edu.ijse.courseWork2.dao.CrudUtil;
import edu.ijse.courseWork2.dao.custom.BookDao;
import edu.ijse.courseWork2.entity.BookEntity;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Isuru Manchanayake
 */
public class BookDaoImpl implements BookDao{

    @Override
    public boolean create(BookEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO book VALUES (?,?,?,?,?,?,?)",
                t.getBookID(), t.getBookName(), t.getAuthor(), t.getPublisher(), t.getPublicationYear(), t.getCategoryID(),
                t.getQty());
    }

    @Override
    public boolean update(BookEntity t) throws Exception {
        return CrudUtil.executeUpdate("UPDATE book SET bookName=?, author=?, publisher=?,  publicationYear=?,  categoryID=?, qtyOnHand=?  WHERE bookID=?",
                 t.getBookID(), t.getBookName(), t.getAuthor(), t.getPublisher(), t.getPublicationYear(), t.getCategoryID(),
                t.getQty());
    }

    @Override
    public boolean delete(String id) throws Exception {
       return CrudUtil.executeUpdate("DELETE FROM book WHERE bookID = ?",id);
    }

    @Override
    public BookEntity get(String id) throws Exception {
       ResultSet rst = CrudUtil.executeQuery("SELECT * FROM book WHERE bookID=?", id);
        if(rst.next()){
          BookEntity entity;
           entity = new BookEntity(rst.getString("bookID"),
                   rst.getString("bookName"),
                   rst.getString("author"),
                   rst.getString("publisher"),
                   rst.getInt("publicationYear"),
                   rst.getString("categoryID"),
                   rst.getInt("qtyOnHand"));
             return entity;
        }
        return null;
    }

    @Override
    public ArrayList<BookEntity> getAll() throws Exception {
        ArrayList<BookEntity>bookEntitys=new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM book");
        while(rst.next()){
       BookEntity entity;
            entity = new BookEntity(rst.getString("bookID"),
                   rst.getString("bookName"),
                   rst.getString("author"),
                   rst.getString("publisher"),
                   rst.getInt("publicationYear"),
                   rst.getString("categoryID"),
                   rst.getInt("qtyOnHand"));
        
       bookEntitys.add(entity);
    }
        return bookEntitys;
    }
    
}

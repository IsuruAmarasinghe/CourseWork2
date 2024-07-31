/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.courseWork2.dao.custom.impl;

import edu.ijse.courseWork2.dao.CrudUtil;
import edu.ijse.courseWork2.dao.custom.BCategoryDao;
import edu.ijse.courseWork2.entity.BCategoryEntity;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Isuru Manchanayake
 */
public class BCategoryDaoImpl implements BCategoryDao{

    @Override
    public boolean create(BCategoryEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO bookCategory VALUES (?,?)", t.getCategoryId(),t.getCategoryName());
    }

    @Override
    public boolean update(BCategoryEntity t) throws Exception {
        return CrudUtil.executeUpdate("UPDATE bookCategory SET categoryName=? WHERE categoryId=?",
                t.getCategoryName(), t.getCategoryId());
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM bookCategory WHERE categoryId=?", id);
    }

    @Override
    public BCategoryEntity get(String id) throws Exception {
          ResultSet rst = CrudUtil.executeQuery("SELECT * FROM bookCategory WHERE categoryId=?", id);
        if(rst.next()){
          BCategoryEntity entity;
           entity = new BCategoryEntity(
                   rst.getString("categoryId"),
                   rst.getString("categoryName")
                   );
             return entity;
        }
        return null;
    }

    @Override
    public ArrayList<BCategoryEntity> getAll() throws Exception {
        ArrayList<BCategoryEntity>bCategoryEntitys=new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM bookCategory");
        while(rst.next()){
       BCategoryEntity entity;
            entity = new BCategoryEntity(
                   rst.getString("categoryID"),
                   rst.getString("categoryName")
                   );
        
       bCategoryEntitys.add(entity);
    }
        return bCategoryEntitys;
    }
    
}

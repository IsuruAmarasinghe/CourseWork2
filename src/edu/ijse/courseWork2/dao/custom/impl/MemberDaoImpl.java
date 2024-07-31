/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.courseWork2.dao.custom.impl;

import edu.ijse.courseWork2.dao.CrudUtil;
import edu.ijse.courseWork2.dao.custom.MemberDao;
import edu.ijse.courseWork2.entity.MemberEntity;
import java.sql.ResultSet;
import java.util.ArrayList;


/**
 *
 * @author Isuru Manchanayake
 */
public class MemberDaoImpl implements MemberDao{

    @Override
    public boolean create(MemberEntity t) throws Exception {
       return CrudUtil.executeUpdate("INSERT INTO member VALUES (?,?,?,?,?,?,?)", 
               t.getMemberId(),
               t.getMemberName(),
               t.getDob(),
               t.getAddress(),
               t.getPhone(),
               t.getMemShipDate(),
               t.getMemExDate());
    }

    @Override
    public boolean update(MemberEntity t) throws Exception {
         return CrudUtil.executeUpdate("Update member Set memberName=?, Dob=?, adress=?, phoneNumber=?, membershipDate=?, membershipExpireDate=? where memberID=? ", 
               t.getMemberId(),
               t.getMemberName(),
               t.getDob(),
               t.getAddress(),
               t.getPhone(),
               t.getMemShipDate(),
               t.getMemExDate());  
                 
                 
   }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM member WHERE memberID = ?",id);
    }

    @Override
    public MemberEntity get(String id) throws Exception {
         ResultSet rst = CrudUtil.executeQuery("SELECT * FROM member WHERE memberID=?", id);
        if(rst.next()){
          MemberEntity entity;
           entity = new MemberEntity(
                   rst.getString("memberID"),
                   rst.getString("memberName"),
                   rst.getString("DOB"),
                   rst.getString("address"),
                   rst.getString("phoneNumber"),
                   rst.getString("membershipDate"),
                   rst.getString("membershipExpireDate"));
             return entity;
        }
        return null;
    }

    @Override
    public ArrayList<MemberEntity> getAll() throws Exception {
        ArrayList<MemberEntity>memberEntitys=new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM member");
        while(rst.next()){
       MemberEntity entity;
            entity = new MemberEntity(
                   rst.getString("memberID"),
                   rst.getString("memberName"),
                   rst.getString("DOB"),
                   rst.getString("address"),
                   rst.getString("phoneNumber"),
                   rst.getString("membershipDate"),
                   rst.getString("membershipExpireDate"));
        
       memberEntitys.add(entity);
    }
        return memberEntitys;
    }

    
    
}

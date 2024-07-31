/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.courseWork2.dao;

import edu.ijse.courseWork2.dao.custom.impl.BCategoryDaoImpl;
import edu.ijse.courseWork2.dao.custom.impl.BookDaoImpl;
import edu.ijse.courseWork2.dao.custom.impl.MemberDaoImpl;
import edu.ijse.courseWork2.dao.custom.impl.ReturnBookDaoImpl;
import edu.ijse.courseWork2.dao.custom.impl.TransactionDaoImpl;

/**
 *
 * @author Isuru Manchanayake
 */
public class DaoFactory {
    private static DaoFactory daoFactory;
    
    private DaoFactory(){}
    
    public static DaoFactory getInstance(){
        if(daoFactory==null){
           daoFactory=new DaoFactory();
        }
        return daoFactory;
    }
    
    public SuperDao getDao(DaoTypes daotype){
        switch (daotype) {
            case BOOK:
                return new BookDaoImpl();
            case MEMBER:
                return new MemberDaoImpl();
            case BOOKCATEGORY:
                return new BCategoryDaoImpl();
            case TRANSACTION:
                return new TransactionDaoImpl();
            case RETURNBOOK:
                return new ReturnBookDaoImpl();
            
            default:
                return null;
        }
    }
    
    
    public enum DaoTypes{
      BOOK,MEMBER,BOOKCATEGORY,TRANSACTION,RETURNBOOK;
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.courseWork2.service;

import edu.ijse.courseWork2.service.custom.impl.BookServiceImpl;
import edu.ijse.courseWork2.service.custom.impl.MemberServiceImpl;

/**
 *
 * @author Isuru Manchanayake
 */
public class ServiceFactory {
    private static ServiceFactory serviceFactory;

    private ServiceFactory() {
    }
    
    public static ServiceFactory getInstance(){
       if(serviceFactory==null){
           serviceFactory=new ServiceFactory();
       }
       return serviceFactory;
    }
    
    public SuperService getService(ServiceType serviceType){
        switch (serviceType) {
            case BOOK:
                return new BookServiceImpl();
            case MEMBER:
                return new MemberServiceImpl();
            case BOOKCATEGORY:
                return null;
            default:
               return null;
        }
    
    }
    
    
    public enum ServiceType{
       BOOK,MEMBER,BOOKCATEGORY;
    }
}

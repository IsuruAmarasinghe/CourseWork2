/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.courseWork2.controller;

import edu.ijse.courseWork2.service.ServiceFactory;
import edu.ijse.courseWork2.service.custom.ReturnBookService;
import edu.ijse.courseWork2.dto.ReturnBookDto;
import java.util.ArrayList;

/**
 *
 * @author Isuru Manchanayake
 */
public class ReturnBookController {
     private ReturnBookService returnBookService = (ReturnBookService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.RETURNBOOK);
    
      public String save(ReturnBookDto returnBookDto)throws Exception{
       return returnBookService.save(returnBookDto);
    }
      
       public String delete(String transactionId)throws Exception{
       return returnBookService.delete(transactionId);
    }
      
       public ArrayList<ReturnBookDto>getAll()throws Exception{
      return returnBookService.getAll();
    }
    
    public ReturnBookDto get(String transactionId)throws Exception{
      return returnBookService.get(transactionId);
    }
    
}

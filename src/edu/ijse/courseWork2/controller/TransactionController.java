/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.courseWork2.controller;

import edu.ijse.courseWork2.dto.TransactionDto;
import edu.ijse.courseWork2.service.ServiceFactory;
import edu.ijse.courseWork2.service.custom.TransactionService;
import java.util.ArrayList;

/**
 *
 * @author Isuru Manchanayake
 */
public class TransactionController {
    private TransactionService transactionService = (TransactionService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.TRANSACTION);
    
     public String save(TransactionDto transactionDto)throws Exception{
       return transactionService.save(transactionDto);
    }
     
      public String update(TransactionDto transactionDto)throws Exception{
       return transactionService.update(transactionDto);
    }
    
    public String delete(String transactionId)throws Exception{
       return transactionService.delete(transactionId);
    }
    
     public ArrayList<TransactionDto>getAll()throws Exception{
      return transactionService.getAll();
    }
    
    public TransactionDto get(String transactionId)throws Exception{
      return transactionService.get(transactionId);
    }
}

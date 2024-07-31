/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.ijse.courseWork2.service.custom;

import edu.ijse.courseWork2.dto.TransactionDto;
import edu.ijse.courseWork2.service.SuperService;
import java.util.ArrayList;

/**
 *
 * @author Isuru Manchanayake
 */
public interface TransactionService extends SuperService {
    String save(TransactionDto transactionDto)throws Exception;
    String update(TransactionDto transactionDto)throws Exception;
    String delete(String transactionId)throws Exception;
    TransactionDto get(String transactionId)throws Exception;
    ArrayList<TransactionDto>getAll()throws Exception;
    
}

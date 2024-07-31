/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.ijse.courseWork2.service.custom;

import edu.ijse.courseWork2.service.SuperService;
import edu.ijse.courseWork2.dto.ReturnBookDto;
import java.util.ArrayList;

/**
 *
 * @author Isuru Manchanayake
 */
public interface ReturnBookService extends SuperService{
    String save(ReturnBookDto returnBookDto )throws Exception;
    String update(ReturnBookDto returnBookDto )throws Exception;
    String delete(String transactionId)throws Exception;
    ReturnBookDto get(String bookID)throws Exception;
    ArrayList<ReturnBookDto>getAll()throws Exception;
    
    
}

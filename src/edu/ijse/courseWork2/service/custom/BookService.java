/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.ijse.courseWork2.service.custom;

import edu.ijse.courseWork2.dto.BookDto;
import edu.ijse.courseWork2.service.SuperService;
import java.util.ArrayList;

/**
 *
 * @author Isuru Manchanayake
 */
public interface BookService extends SuperService{
    String save(BookDto bookDto)throws Exception;
    String update(BookDto bookDto)throws Exception;
    String delete(String bookID)throws Exception;
    BookDto get(String bookID)throws Exception;
    ArrayList<BookDto>getAll()throws Exception;
}

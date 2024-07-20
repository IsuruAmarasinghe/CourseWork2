/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.ijse.courseWork2.service.custom;

import edu.ijse.courseWork2.dto.BCategoryDto;
import edu.ijse.courseWork2.service.SuperService;
import java.util.ArrayList;

/**
 *
 * @author Isuru Manchanayake
 */
public interface BCategoryService extends SuperService{
    String save(BCategoryDto bCategoryDto)throws Exception;
    String update(BCategoryDto bCategoryDto)throws Exception;
    String delete(String categoryId)throws Exception;
    BCategoryDto get(String categoryId)throws Exception;
    ArrayList<BCategoryDto>getAll()throws Exception;
}

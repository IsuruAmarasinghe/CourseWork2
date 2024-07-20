/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.courseWork2.controller;

import edu.ijse.courseWork2.dto.BCategoryDto;
import edu.ijse.courseWork2.service.ServiceFactory;
import edu.ijse.courseWork2.service.custom.BCategoryService;
import java.util.ArrayList;

/**
 *
 * @author Isuru Manchanayake
 */
public class BCategoryController {
    private BCategoryService bCategoryService = (BCategoryService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.BOOKCATEGORY);
    
    
    public String save(BCategoryDto bCategoryDto)throws Exception{
       return bCategoryService.save(bCategoryDto);
    }
     
      public String update(BCategoryDto bCategoryDto)throws Exception{
       return bCategoryService.update(bCategoryDto);
    }
    
    public String delete(String categoryId)throws Exception{
       return bCategoryService.delete(categoryId);
    }
    
     public ArrayList<BCategoryDto>getAll()throws Exception{
      return bCategoryService.getAll();
    }
    
    public BCategoryDto get(String bookID)throws Exception{
      return bCategoryService.get(bookID);
    }
}

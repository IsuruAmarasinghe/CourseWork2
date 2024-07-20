/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.courseWork2.service.custom.impl;

import edu.ijse.courseWork2.dao.DaoFactory;
import edu.ijse.courseWork2.dao.custom.BCategoryDao;
import edu.ijse.courseWork2.dto.BCategoryDto;
import edu.ijse.courseWork2.entity.BCategoryEntity;
import edu.ijse.courseWork2.service.custom.BCategoryService;
import java.util.ArrayList;

/**
 *
 * @author Isuru Manchanayake
 */
public class BCategoryServiceImpl implements BCategoryService{
    private BCategoryDao bCategoryDao = (BCategoryDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.BOOK);

    @Override
    public String save(BCategoryDto bCategoryDto) throws Exception {
           BCategoryEntity entity = getCategoryEntity(bCategoryDto);
           return bCategoryDao.create(entity)? "Success" : "Fail";
    }

    @Override
    public String update(BCategoryDto bCategoryDto) throws Exception {
           BCategoryEntity entity = getCategoryEntity(bCategoryDto);
           return bCategoryDao.update(entity)? "Success" : "Fail";
    }

    @Override
    public String delete(String categoryId) throws Exception {
         return bCategoryDao.delete(categoryId)? "Success" : "Fail";
    }

    @Override
    public BCategoryDto get(String categoryId) throws Exception {
        BCategoryEntity entity = bCategoryDao.get(categoryId);
         if(entity != null){
           return getCategoryDto(entity);
         }
         return null;
    }

    @Override
    public ArrayList<BCategoryDto> getAll() throws Exception {
         ArrayList<BCategoryEntity>bCategoryEntitys = bCategoryDao.getAll();
      if(bCategoryEntitys != null && !bCategoryEntitys.isEmpty()){
        ArrayList<BCategoryDto>bCategoryDtos = new ArrayList<>();
        
          for (BCategoryEntity entity : bCategoryEntitys) {
            bCategoryDtos.add(getCategoryDto(entity));
              
          }
           return bCategoryDtos;   
          }
        return null;
      }

    private BCategoryEntity getCategoryEntity(BCategoryDto bCategoryDto) {
         return new BCategoryEntity(
                 bCategoryDto.getCategoryId(),
                 bCategoryDto.getCategoryName());
    
    }

    private BCategoryDto getCategoryDto(BCategoryEntity entity) {
        return new BCategoryDto(entity.getCategoryId(), entity.getCategoryName());
    }

    
    
}

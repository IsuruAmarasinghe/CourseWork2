/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.courseWork2.service.custom.impl;

import edu.ijse.courseWork2.dao.DaoFactory;
import edu.ijse.courseWork2.dao.custom.MemberDao;
import edu.ijse.courseWork2.dto.MemberDto;
import edu.ijse.courseWork2.entity.MemberEntity;
import edu.ijse.courseWork2.service.custom.MemberService;
import java.util.ArrayList;

/**
 *
 * @author Isuru Manchanayake
 */
public class MemberServiceImpl implements MemberService{
    private MemberDao memberDao = (MemberDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.MEMBER);

    @Override
    public String save(MemberDto memberDto) throws Exception {
        MemberEntity entity=getMemberEntity(memberDto);
        return  memberDao.create(entity)? "Success" : "Fail";
    }

    @Override
    public String update(MemberDto memberDto) throws Exception {
       MemberEntity entity=getMemberEntity(memberDto);
        return  memberDao.update(entity)? "Success" : "Fail";
    }
    
    @Override
    public String delete(String memberId) throws Exception {
       return memberDao.delete(memberId)? "Success" : "Fail";
    }

    @Override
    public MemberDto get(String memberID) throws Exception {
        MemberEntity entity = memberDao.get(memberID);
        if(entity != null){
           return getMemberDto(entity);
         }
         return null;
    }

    @Override
    public ArrayList<MemberDto> getAll() throws Exception {
        ArrayList<MemberEntity>memberEntitys = memberDao.getAll();
      if(memberEntitys != null && !memberEntitys.isEmpty()){
        ArrayList<MemberDto>memberDtos = new ArrayList<>();
        
          for (MemberEntity entity : memberEntitys) {
            memberDtos.add(getMemberDto(entity));
              
          }
           return memberDtos;   
          }
        return null;
      }

    private MemberEntity getMemberEntity(MemberDto memberDto) {
       return new MemberEntity(
              memberDto.getMemberId(),
              memberDto.getMemberName(),
              memberDto.getDob(),
              memberDto.getAddress(),
              memberDto.getPhone(),
              memberDto.getMemShipDate(),
              memberDto.getMemExDate()
       );
    }

    private MemberDto getMemberDto(MemberEntity entity) {
      return new MemberDto(
              entity.getMemberId(),
              entity.getMemberName(),
              entity.getDob(),
              entity.getAddress(),
              entity.getPhone(),
              entity.getMemShipDate(),
              entity.getMemExDate());
    
    }
    
}

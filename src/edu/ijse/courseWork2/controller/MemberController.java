/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.courseWork2.controller;



import edu.ijse.courseWork2.dto.MemberDto;
import edu.ijse.courseWork2.service.ServiceFactory;
import edu.ijse.courseWork2.service.custom.MemberService;
import java.util.ArrayList;

/**
 *
 * @author Isuru Manchanayake
 */
public class MemberController {
    private MemberService memberService = (MemberService)ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.MEMBER);
    
    public String save(MemberDto memberDto)throws Exception{
        return memberService.save(memberDto);
    }
    
     public String delete(String memberId)throws Exception{
        return memberService.delete(memberId);
    }
     
     public String update(MemberDto memberDto)throws Exception{
        return memberService.update(memberDto);
    } 
    
     public ArrayList<MemberDto>getAll()throws Exception{
      return memberService.getAll();
    }
    
    public MemberDto get(String memberID)throws Exception{
      return memberService.get(memberID);
    }
    
    
}

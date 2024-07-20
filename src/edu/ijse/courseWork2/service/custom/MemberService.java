/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.ijse.courseWork2.service.custom;

import edu.ijse.courseWork2.dto.MemberDto;
import edu.ijse.courseWork2.service.SuperService;
import java.util.ArrayList;

/**
 *
 * @author Isuru Manchanayake
 */
public interface MemberService extends SuperService{
    String save(MemberDto memberDto)throws Exception;
    String update(MemberDto memberDto)throws Exception;
    String delete(String memberId)throws Exception;
    MemberDto get(String memberId)throws Exception;
    ArrayList<MemberDto>getAll()throws Exception;
}

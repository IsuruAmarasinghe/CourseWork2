/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.courseWork2.entity;

/**
 *
 * @author Isuru Manchanayake
 */
public class MemberEntity {
    private String memberId;
    private String memberName;
    private String dob;
    private String address;
    private String phone;
    private String memShipDate;
    private String memExDate;

    public MemberEntity() {
    }

    public MemberEntity(String memberId, String memberName, String dob, String address, String phone, String memShipDate, String memExDate) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.dob = dob;
        this.address = address;
        this.phone = phone;
        this.memShipDate = memShipDate;
        this.memExDate = memExDate;
    }

    /**
     * @return the memberId
     */
    public String getMemberId() {
        return memberId;
    }

    /**
     * @param memberId the memberId to set
     */
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    /**
     * @return the memberName
     */
    public String getMemberName() {
        return memberName;
    }

    /**
     * @param memberName the memberName to set
     */
    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    /**
     * @return the dob
     */
    public String getDob() {
        return dob;
    }

    /**
     * @param dob the dob to set
     */
    public void setDob(String dob) {
        this.dob = dob;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the memShipDate
     */
    public String getMemShipDate() {
        return memShipDate;
    }

    /**
     * @param memShipDate the memShipDate to set
     */
    public void setMemShipDate(String memShipDate) {
        this.memShipDate = memShipDate;
    }

    /**
     * @return the memExDate
     */
    public String getMemExDate() {
        return memExDate;
    }

    /**
     * @param memExDate the memExDate to set
     */
    public void setMemExDate(String memExDate) {
        this.memExDate = memExDate;
    }

    @Override
    public String toString() {
        return "MemberEntity{" + "memberId=" + memberId + ", memberName=" + memberName + ", dob=" + dob + ", address=" + address + ", phone=" + phone + ", memShipDate=" + memShipDate + ", memExDate=" + memExDate + '}';
    }
    
    
}

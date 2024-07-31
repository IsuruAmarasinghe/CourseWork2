/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.courseWork2.dto;

/**
 *
 * @author Isuru Manchanayake
 */
public class ReturnBookDto {
    private String transactionId;
    private String borrowDate;
    private String duedate;
    private String returnDate;
    private int fine;
    private String bookId;
    private int qty;

    public ReturnBookDto() {
    }

    public ReturnBookDto(String transactionId, String borrowDate, String duedate, String returnDate, int fine, String bookId, int qty) {
        this.transactionId = transactionId;
        this.borrowDate = borrowDate;
        this.duedate = duedate;
        this.returnDate = returnDate;
        this.fine = fine;
        this.bookId = bookId;
        this.qty = qty;
    }

    /**
     * @return the transactionId
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * @param transactionId the transactionId to set
     */
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    /**
     * @return the borrowDate
     */
    public String getBorrowDate() {
        return borrowDate;
    }

    /**
     * @param borrowDate the borrowDate to set
     */
    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    /**
     * @return the duedate
     */
    public String getDuedate() {
        return duedate;
    }

    /**
     * @param duedate the duedate to set
     */
    public void setDuedate(String duedate) {
        this.duedate = duedate;
    }

    /**
     * @return the returnDate
     */
    public String getReturnDate() {
        return returnDate;
    }

    /**
     * @param returnDate the returnDate to set
     */
    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    /**
     * @return the fine
     */
    public int getFine() {
        return fine;
    }

    /**
     * @param fine the fine to set
     */
    public void setFine(int fine) {
        this.fine = fine;
    }

    /**
     * @return the bookId
     */
    public String getBookId() {
        return bookId;
    }

    /**
     * @param bookId the bookId to set
     */
    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    /**
     * @return the qty
     */
    public int getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "ReturnBookDto{" + "transactionId=" + transactionId + ", borrowDate=" + borrowDate + ", duedate=" + duedate + ", returnDate=" + returnDate + ", fine=" + fine + ", bookId=" + bookId + ", qty=" + qty + '}';
    }
    
    

   
    
    
    
}

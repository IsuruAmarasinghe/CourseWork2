/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.courseWork2.entity;

/**
 *
 * @author Isuru Manchanayake
 */
public class TransactionEntity {
     private String transactionId;
    private String memberId;
    private String bookId;
    private String borrowDate;
    private String dueDate;
    private int noOfBook;

    public TransactionEntity() {
    }

    public TransactionEntity(String transactionId, String memberId, String bookId, String borrowDate, String dueDate, int noOfBook) {
        this.transactionId = transactionId;
        this.memberId = memberId;
        this.bookId = bookId;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.noOfBook = noOfBook;
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
     * @return the dueDate
     */
    public String getDueDate() {
        return dueDate;
    }

    /**
     * @param dueDate the dueDate to set
     */
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * @return the noOfBook
     */
    public int getNoOfBook() {
        return noOfBook;
    }

    /**
     * @param noOfBook the noOfBook to set
     */
    public void setNoOfBook(int noOfBook) {
        this.noOfBook = noOfBook;
    }

    @Override
    public String toString() {
        return "TransactionEntity{" + "transactionId=" + transactionId + ", memberId=" + memberId + ", bookId=" + bookId + ", borrowDate=" + borrowDate + ", dueDate=" + dueDate + ", noOfBook=" + noOfBook + '}';
    }
    
    
    
}

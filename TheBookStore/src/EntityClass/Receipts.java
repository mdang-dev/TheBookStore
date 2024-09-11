/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EntityClass;

import java.util.Date;

/**
 *
 * @author LENOVO
 */
public class Receipts {

    private String ID;
    private int EmployeeID;
    private float TotalCost;
    private float moneyReceived;
    private float moneyReturned;

    public float getMoneyReceived() {
        return moneyReceived;
    }

    public void setMoneyReceived(float moneyReceived) {
        this.moneyReceived = moneyReceived;
    }

    public float getMoneyReturned() {
        return moneyReturned;
    }

    public void setMoneyReturned(float moneyReturned) {
        this.moneyReturned = moneyReturned;
    }
    private String CurrentStatus;
    private Date CreateDate;
    private String MoreInfo;

    public float getTotalCost() {
        return TotalCost;
    }

    public void setTotalCost(float TotalCost) {
        this.TotalCost = TotalCost;
    }

    
    
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int EmployeeID) {
        this.EmployeeID = EmployeeID;
    }
    
    public String getCurrentStatus() {
        return CurrentStatus;
    }

    public void setCurrentStatus(String CurrentStatus) {
        this.CurrentStatus = CurrentStatus;
    }

    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date CreateDate) {
        this.CreateDate = CreateDate;
    }

    public String getMoreInfo() {
        return MoreInfo;
    }

    public void setMoreInfo(String MoreInfo) {
        this.MoreInfo = MoreInfo;
    }
    

}

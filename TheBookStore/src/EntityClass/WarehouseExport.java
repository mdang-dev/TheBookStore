package EntityClass;


import java.util.Date;


public class WarehouseExport {
    
    String ID;
    Integer customerID;
    Integer employeeID;
    Date deliveringDate;
    Double totalCost;
    String currentStatus;
    String moreInfo;
    String ReceiptID;
    
    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public Date getDeliveringDate() {
        return deliveringDate;
    }

    public void setDeliveringDate(Date deliveringDate) {
        this.deliveringDate = deliveringDate;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public String getMoreInfo() {
        return moreInfo;
    }

    public void setMoreInfo(String moreInfo) {
        this.moreInfo = moreInfo;
    }

    public String getReceiptID() {
        return ReceiptID;
    }

    public void setReceiptID(String ReceiptID) {
        this.ReceiptID = ReceiptID;
    }   
    
}

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
public class Customer {
    int ID;
    String CustomerName;
    String PhoneNumber;
    String AddressCustomers;
    Date ContractDate;
    String Email;
    String MoreInfo;

    public Customer() {
    }

    public Customer(int ID, String CustomerName, String PhoneNumber, String AddressCustomers, Date ContractDate, String Email, String MoreInfo) {
        this.ID = ID;
        this.CustomerName = CustomerName;
        this.PhoneNumber = PhoneNumber;
        this.AddressCustomers = AddressCustomers;
        this.ContractDate = ContractDate;
        this.Email = Email;
        this.MoreInfo = MoreInfo;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getAddressCustomers() {
        return AddressCustomers;
    }

    public void setAddressCustomers(String AddressCustomers) {
        this.AddressCustomers = AddressCustomers;
    }

    public Date getContractDate() {
        return ContractDate;
    }

    public void setContractDate(Date ContractDate) {
        this.ContractDate = ContractDate;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getMoreInfo() {
        return MoreInfo;
    }

    public void setMoreInfo(String MoreInfo) {
        this.MoreInfo = MoreInfo;
    }

    public Customer get(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}

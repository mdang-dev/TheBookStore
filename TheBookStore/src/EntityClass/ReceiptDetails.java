/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EntityClass;

/**
 *
 * @author LENOVO
 */
public class ReceiptDetails {
    private String ID;
    private String ReceiptID;
    private String InventoryID;
    private int Quantity;
    private float  SellingPrice;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getReceiptID() {
        return ReceiptID;
    }

    public void setReceiptID(String ReceiptID) {
        this.ReceiptID = ReceiptID;
    }

    public String getInventoryID() {
        return InventoryID;
    }

    public void setInventoryID(String InventoryID) {
        this.InventoryID = InventoryID;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public float getSellingPrice() {
        return SellingPrice;
    }

    public void setSellingPrice(float SellingPrice) {
        this.SellingPrice = SellingPrice;
    }
    
    
    
}

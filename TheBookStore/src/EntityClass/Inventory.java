package EntityClass;

import java.security.SecureRandom;


public class Inventory {
    
    private static final String randomCharacter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    
    String ID = randomInventoryID();
    String productID;
    String WarehouseReceiptID;
    int avaiableQuantity;
    double sellingPrice;
    String currentStatus;
    String area;
    String MoreInfo;
    
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getWarehouseReceiptID() {
        return WarehouseReceiptID;
    }

    public void setWarehouseReceiptID(String WarehouseReceiptID) {
        this.WarehouseReceiptID = WarehouseReceiptID;
    }

    public int getAvaiableQuantity() {
        return avaiableQuantity;
    }

    public void setAvaiableQuantity(int avaiableQuantity) {
        this.avaiableQuantity = avaiableQuantity;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getMoreInfo() {
        return MoreInfo;
    }

    public void setMoreInfo(String MoreInfo) {
        this.MoreInfo = MoreInfo;
    }
    
    String randomInventoryID(){
        int codeLength = 20;
        String randomID = gennerateRandomCode(codeLength);
        return randomID;
    }
    
    String gennerateRandomCode(int length){
        SecureRandom random = new SecureRandom();
        StringBuilder str = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(randomCharacter.length());
            str.append(randomCharacter.charAt(index));
        }
        return str.toString();
    }

    
    
}

package EntityClass;

import java.security.SecureRandom;

public class WarehouseExportDetails {
    
   private static final String randomCharacter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    
    String ID = randomID();
    String warehouseExportID;
    String inventoryID;
    Integer Quantity;
    Double sellingPrice;
    String currentStatus;
    String moreInfo;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getWarehouseExportID() {
        return warehouseExportID;
    }

    public void setWarehouseExportID(String warehouseExportID) {
        this.warehouseExportID = warehouseExportID;
    }

    public String getInventoryID() {
        return inventoryID;
    }

    public void setInventoryID(String inventoryID) {
        this.inventoryID = inventoryID;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer Quantity) {
        this.Quantity = Quantity;
    }

    public Double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Double sellingPrice) {
        this.sellingPrice = sellingPrice;
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
    
     String randomID(){
        int codeLength = 5;
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

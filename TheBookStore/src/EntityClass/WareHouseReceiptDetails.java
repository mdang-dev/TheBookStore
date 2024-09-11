package EntityClass;

import java.security.SecureRandom;

/**
 *
 * @author Minh Đang
 */
public class WareHouseReceiptDetails {
    
    private static final String randomCharacter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    
    String ID  = randomID();
    String productID;
    String wareHouseReceiptID;
    Integer quantity;
    Double receivingPrice;
    String currentStatus;
    String moreInfo;

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

    public String getWareHouseReceiptID() {
        return wareHouseReceiptID;
    }

    public void setWareHouseReceiptID(String wareHouseReceiptID) {
        this.wareHouseReceiptID = wareHouseReceiptID;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getReceivingPrice() {
        return receivingPrice;
    }

    public void setReceivingPrice(Double receivingPrice) {
        this.receivingPrice = receivingPrice;
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
        int codeLength = 8;
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

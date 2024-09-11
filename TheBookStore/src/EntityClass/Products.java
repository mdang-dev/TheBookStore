/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EntityClass;

/**
 *
 * @author Admin
 */
public class Products {

    private String ID;
    private String productName;
    private int typeOfProductID;
    private String author;
    private String publisher;
    private String genre;
    private String moreInfo;
    private String barCode;
    private int employeeID;
    private String imagePath;

    public Products(String ID, String productName, int typeOfProductID, String author, String publisher, String genre, String moreInfo, String barCode, int employeeID, String imagePath) {
        this.ID = ID;
        this.productName = productName;
        this.typeOfProductID = typeOfProductID;
        this.author = author;
        this.publisher = publisher;
        this.genre = genre;
        this.moreInfo = moreInfo;
        this.barCode = barCode;
        this.employeeID = employeeID;
        this.imagePath = imagePath;
    }

    public Products() {
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getTypeOfProductID() {
        return typeOfProductID;
    }

    public void setTypeOfProductID(int typeOfProductID) {
        this.typeOfProductID = typeOfProductID;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getMoreInfo() {
        return moreInfo;
    }

    public void setMoreInfo(String moreInfo) {
        this.moreInfo = moreInfo;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    
}

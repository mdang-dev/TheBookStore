/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import EntityClass.ReceiptDetails;
import ExtentionLibrary.XJdbc;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class ReceiptsDetailsDAO  {
     String INSERT_SQL = "INSERT INTO ReceiptDetails (ID, ReceiptID, InventoryID, Quantity, SellingPrice) VALUES (?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE  ReceiptDetails SET ReceiptID = ?, InventoryID = ?,  Quantity = ?, SellingPrice = ? WHERE ID =?";
    String DELETE_SQL = "DELETE FROM ReceiptDetails WHERE ID = ?";
    String SELECT_ALL = "SELECT * FROM ReceiptDetails WHERE ReceiptID = ? ";
    String SELECT_BY_ID = "SELECT * FROM ReceiptDetails WHERE ID = ? AND ReceiptID = ?";

  
    public void insert(ReceiptDetails entity) {
      XJdbc.update(INSERT_SQL, entity.getID(), entity.getReceiptID(),
                entity.getInventoryID(), entity.getQuantity(), entity.getSellingPrice());
    }

    
    public void update(ReceiptDetails entity) {
        XJdbc.update(UPDATE_SQL, entity.getReceiptID(),
                entity.getInventoryID(), entity.getQuantity(), entity.getSellingPrice(), entity.getID());
              
    }

    public void delete(String id) {
       XJdbc.update(DELETE_SQL, id);
    }
    
    public List<String> receiptsHaveNoProduct() throws SQLException
    {
        String sql = "SELECT R.ID FROM ReceiptDetails RD RIGHT JOIN Receipts R ON R.ID = RD.ReceiptID GROUP BY R.ID "
                + "HAVING NOT COUNT(RD.ID) > 0";
        List<String> receiptID = new ArrayList<>();
        ResultSet rs = XJdbc.query(sql);
        while (rs.next())
        {
            receiptID.add(rs.getString("ID"));
        }
        return receiptID;
    }
    
    public boolean isDuplicate(String inventoryID, String fromReceipt) throws SQLException
    {
        String sql = "{CALL CheckDuplicate (?, ?)}";
        int check = (int) XJdbc.value(sql, inventoryID, fromReceipt);
        return check == 1;
    }
    
    public String getPreviousID(String inventoryID, String fromReceipt) throws SQLException
    {
        String sql = "SELECT ID FROM ReceiptDetails WHERE InventoryID = ? AND ReceiptID = ?";
        return (String) XJdbc.value(sql, inventoryID, fromReceipt);
    }
    
    public ReceiptDetails selectById(String id, String receiptID) throws SQLException {
        return this.selectBySql(SELECT_BY_ID, id, receiptID).get(0);
    }
    
    
    public List<ReceiptDetails> selectAll(String ID) throws SQLException {
             return this.selectBySql(SELECT_ALL, ID);
    }
    
    public String fromInventoryToProduct(String inventoryID) throws SQLException
    {
        String sql = "SELECT ProductID FROM Inventory WHERE ID = ?;";
        return (String) XJdbc.value(sql, inventoryID);
    }
    
    public String toProductName(String inventoryID) throws SQLException
    {
        String sql = "SELECT ProductName FROM Products WHERE ID = (SELECT ProductID FROM Inventory I WHERE I.ID = ?);";
        return (String) XJdbc.value(sql, inventoryID);
    }


    protected List<ReceiptDetails> selectBySql(String sql, Object... args) throws SQLException {
        List<ReceiptDetails> list = new ArrayList<>();
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next())
            {
                ReceiptDetails receiptsdetails = new ReceiptDetails();
                receiptsdetails.setID(rs.getString("ID"));
                receiptsdetails.setReceiptID(rs.getString("ReceiptID"));
                receiptsdetails.setInventoryID(rs.getString("InventoryID"));
                receiptsdetails.setQuantity(rs.getInt("Quantity"));
                receiptsdetails.setSellingPrice(rs.getFloat("SellingPrice"));
                list.add(receiptsdetails);
            }
            rs.getStatement().getConnection().close();
         return list;
    }
}

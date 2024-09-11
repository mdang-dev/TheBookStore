package DAO;

import EntityClass.Inventory;
import ExtentionLibrary.XJdbc;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import EntityClass.WareHouseReceiptDetails;
import java.sql.PreparedStatement;
/**
 *
 * @author Minh Đang
 */
public class ReceiveIntoInventoryDAO extends TheBookStoreDAO<Inventory, String>{

    String INSERT_SQL = "INSERT INTO Inventory (ID, ProductID, WarehouseReceiptID, AvailableQuantity, SellingPrice, CurrentStatus, Area, MoreInfo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    String UPDATE_SQL = "UPDATE Inventory SET ProductID = ?, WarehouseReceiptID = ?, AvailableQuantity = ?, SellingPrice = ?, CurrentStatus = ?, Area = ?, MoreInfo = ? WHERE ID = ?";
    String SELECT_ALL_SQL = "SELECT * FROM Inventory";
    String DELETE_SQL = "DELETE Inventory WHERE ID=?";
    String SELECT_BY_ID_SQL = "SELECT * FROM Inventory WHERE WarehouseReceiptID=?";
    String SELECT_ID = "SELECT * FROM Inventory WHERE ID=?";
    
    @Override
    public void insert(Inventory entity) {
        XJdbc.update(INSERT_SQL, entity.getID(), entity.getProductID(), entity.getWarehouseReceiptID(), entity.getAvaiableQuantity(), entity.getSellingPrice(), entity.getCurrentStatus(), entity.getArea(), entity.getMoreInfo());
    }

    public void insertAll(WareHouseReceiptDetails entity, String area){
            XJdbc.update(INSERT_SQL, entity.getID(), entity.getProductID(), entity.getWareHouseReceiptID(),  entity.getQuantity(), entity.getReceivingPrice() + entity.getReceivingPrice() * 0.1, entity.getCurrentStatus(), area, entity.getMoreInfo());
        
    }
    
    @Override
    public void update(Inventory entity) {
        XJdbc.update(UPDATE_SQL,  entity.getProductID(), entity.getWarehouseReceiptID(), entity.getAvaiableQuantity(), entity.getSellingPrice(), entity.getCurrentStatus(), entity.getArea(), entity.getMoreInfo(), entity.getID());
    }

    @Override
    public void delete(String id) {
       XJdbc.update(DELETE_SQL, id);
    }

    @Override
    public Inventory selectById(String id) {
        List<Inventory> list = this.selectBySql(SELECT_ID, id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    public List<Inventory> selectByIdAll(String id) {
        List<Inventory> list = this.selectBySql(SELECT_BY_ID_SQL, id);
        if(list.isEmpty()){
            return null;
        }
        return list;
    }
    
    @Override
    public List<Inventory> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    protected List<Inventory> selectBySql(String sql, Object... args) {
        try {
            List<Inventory> list = new ArrayList<>();
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next()) {
                Inventory inventory = new Inventory();
                inventory.setID(rs.getString("ID"));
                inventory.setProductID(rs.getString("ProductID"));
                inventory.setWarehouseReceiptID(rs.getString("WarehouseReceiptID"));
                inventory.setAvaiableQuantity(rs.getInt("AvailableQuantity"));
                inventory.setSellingPrice(rs.getDouble("SellingPrice"));
                inventory.setCurrentStatus(rs.getString("CurrentStatus"));
                inventory.setArea(rs.getString("Area"));
                inventory.setMoreInfo(rs.getString("MoreInfo"));
                list.add(inventory);
            }
            rs.getStatement().getConnection().close();;
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ReceiveIntoInventoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Object[]> getViewInventory(){
        try {
            List<Object[]> list  = new ArrayList<>();
            String sql = "{CALL InventoryData}";
            PreparedStatement stmt = XJdbc.getStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {                
                Object[] inventory =   new Object[12];
                inventory[0] = rs.getString("InventoryID");
                inventory[1] = rs.getString("ProductID");
                inventory[2] = rs.getString("ProductName");
                inventory[3] = rs.getString("WarehouseReceiptID");
                inventory[4] = rs.getDate("ReceivingDate");
                inventory[5] = rs.getInt("AvailableQuantity");
                inventory[6] = rs.getDouble("ReceivingPrice");
                inventory[7] = rs.getDouble("SellingPrice");
                inventory[8] = rs.getString("CurrentStatus");
                inventory[9] = rs.getString("Area");
                inventory[10] = rs.getString("ImagePath");
                inventory[11] = rs.getString("MoreInfo");
                list.add(inventory);
            }
            stmt.getConnection().close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ReceiveIntoInventoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public String selectArea(String id, String productID){
        try {
            ResultSet rs = XJdbc.query("SELECT Area FROM Inventory WHERE WarehouseReceiptID =? AND ProductID=?", id, productID);
            if(rs.next()){
                return rs.getString("Area");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReceiveIntoInventoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Object[]> getProductInventory(){
        try {
            List<Object[]> list  = new ArrayList<>();

            ResultSet rs = XJdbc.query("SELECT iv.ID, pr.ID AS ProductID, pr.ProductName, iv.AvailableQuantity, iv.SellingPrice, pr.ImagePath FROM Inventory iv JOIN Products pr ON iv.ProductID = pr.ID");
            while (rs.next()) {                
                Object[] inventory =   new Object[6];
                inventory[0] = rs.getString("ID");
                inventory[1] = rs.getString("ProductID");
                inventory[2] = rs.getString("ProductName");
                inventory[3] = rs.getInt("AvailableQuantity");
                inventory[4] = rs.getDouble("SellingPrice");
                inventory[5] = rs.getString("ImagePath");
                list.add(inventory);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ReceiveIntoInventoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
     public List<Object[]> getDataInventory(String name){
        try {
            List<Object[]> list  = new ArrayList<>();
            String sql = "{CALL InventoryDataSearch(?)}";
            PreparedStatement stmt = XJdbc.getStatement(sql, name);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {                
                Object[] inventory =   new Object[12];
                inventory[0] = rs.getString("InventoryID");
                inventory[1] = rs.getString("ProductID");
                inventory[2] = rs.getString("ProductName");
                inventory[3] = rs.getString("WarehouseReceiptID");
                inventory[4] = rs.getDate("ReceivingDate");
                inventory[5] = rs.getInt("AvailableQuantity");
                inventory[6] = rs.getDouble("ReceivingPrice");
                inventory[7] = rs.getDouble("SellingPrice");
                inventory[8] = rs.getString("CurrentStatus");
                inventory[9] = rs.getString("Area");
                inventory[10] = rs.getString("ImagePath");
                inventory[11] = rs.getString("MoreInfo");
                list.add(inventory);
            }
            stmt.getConnection().close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ReceiveIntoInventoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static void main(String[] args) {
        ReceiveIntoInventoryDAO dao = new ReceiveIntoInventoryDAO();
        List<Object[]> list = dao.getViewInventory();
        for (int i = 0; i < list.size(); i++) {
           Object[] entity = list.get(i);
            System.out.println(entity[0]);
            System.out.println(entity[1]);
            System.out.println(entity[2]);
            System.out.println(entity[3]);
            System.out.println(entity[4]);
            System.out.println(entity[5]);
            System.out.println(entity[6]);
            System.out.println(entity[7]);
            System.out.println(entity[8]);
            System.out.println(entity[9]);
            System.out.println(entity[10]);
            System.out.println("----------------------");
        }
    }
}

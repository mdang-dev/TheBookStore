package DAO;
import EntityClass.WareHouseReceiptDetails;
import ExtentionLibrary.XJdbc;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Minh Đang
 */
public class WareHouseReceiptDetailsDAO extends TheBookStoreDAO<WareHouseReceiptDetails, String>{

    String INSERT_SQL = "INSERT INTO WareHouseReceiptDetails VALUES (?, ?, ?, ?, ?, ?, ?)";
    String UPDARE_SQL = "UPDATE WareHouseReceiptDetails SET ProductID=?, WareHouseReceiptID =?, Quantity=?, ReceivingPrice=?, CurrentStatus=?, MoreInfo=? WHERE ID =?";
    String DELETE_SQL = "DELETE WareHouseReceiptDetails WHERE ID =?";
    String SELECT_BY_ID_WareHouseReceipts = "SELECT * FROM WareHouseReceiptDetails WHERE WareHouseReceiptID =?";
    String SELECT_WarehouseReceiptDetails_Edit = "SELECT whd.WarehouseReceiptID, whd.ProductID, prd.ProductName, whd.Quantity, whd.ReceivingPrice, whd.CurrentStatus, whd.MoreInfo FROM WarehouseReceiptDetails whd JOIN Products prd ON whd.ProductID = prd.ID WHERE whd.WarehouseReceiptID =?";

    
    @Override
    public void insert(WareHouseReceiptDetails entity) {
        XJdbc.update(INSERT_SQL, entity.getID(),entity.getProductID(), entity.getWareHouseReceiptID(), entity.getQuantity(), entity.getReceivingPrice(), entity.getCurrentStatus(), entity.getMoreInfo());
    }

    @Override
    public void update(WareHouseReceiptDetails entity) {
        XJdbc.update(UPDARE_SQL, entity.getProductID(), entity.getWareHouseReceiptID(), entity.getQuantity(), entity.getReceivingPrice(), entity.getCurrentStatus(), entity.getMoreInfo());
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public WareHouseReceiptDetails selectById(String id) {
              List<WareHouseReceiptDetails> list =  this.selectBySql(SELECT_BY_ID_WareHouseReceipts, id);
       if(list.isEmpty()){
           return null;
       }
       return list.get(0);
    }



    public List<WareHouseReceiptDetails> selectByIdAll(String id) {
              List<WareHouseReceiptDetails> list =  this.selectBySql(SELECT_BY_ID_WareHouseReceipts, id);
       if(list.isEmpty()){
           return null;
       }
       return list;
    }

    
    @Override
    public List<WareHouseReceiptDetails> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected List<WareHouseReceiptDetails> selectBySql(String sql, Object... args) {
        try {
            List<WareHouseReceiptDetails> list = new ArrayList<>();
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next()) {                
                WareHouseReceiptDetails wareHouseReceiptDetails = new WareHouseReceiptDetails();
                wareHouseReceiptDetails.setID(rs.getString("ID"));
                wareHouseReceiptDetails.setProductID(rs.getString("ProductID"));
                wareHouseReceiptDetails.setWareHouseReceiptID(rs.getString("WareHouseReceiptID"));
                wareHouseReceiptDetails.setQuantity(rs.getInt("Quantity"));
                wareHouseReceiptDetails.setReceivingPrice(rs.getDouble("ReceivingPrice"));
                wareHouseReceiptDetails.setCurrentStatus(rs.getString("CurrentStatus"));
                wareHouseReceiptDetails.setMoreInfo(rs.getString("MoreInfo"));
                list.add(wareHouseReceiptDetails);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(WareHouseReceiptDetailsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<WareHouseReceiptDetails> selectByIdWareHouseReceipt(String id){
       List<WareHouseReceiptDetails> list =  this.selectBySql(SELECT_BY_ID_WareHouseReceipts, id);
       if(list.isEmpty()){
           return null;
       }
       return list;
    }
    
    public List<Object[]> selectEdit(String id) {
        try {
            List<Object[]> list = new ArrayList<>();
            ResultSet rs = XJdbc.query(SELECT_WarehouseReceiptDetails_Edit, id);
            while (rs.next()) {                
                Object[] entity = new Object[7];
                entity[0] = rs.getString("ProductID");
                entity[1] = rs.getString("ProductName");
                entity[2] = rs.getInt("Quantity");
                entity[3] = rs.getDouble("ReceivingPrice");
                entity[4] = rs.getString("CurrentStatus");
                entity[5] = rs.getString("MoreInfo");
                entity[6] = rs.getString("WarehouseReceiptID");
                list.add(entity);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(WareHouseReceiptDetailsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}

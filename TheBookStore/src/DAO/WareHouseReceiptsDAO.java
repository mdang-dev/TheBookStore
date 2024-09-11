package DAO;

import EntityClass.WareHouseReceipts;
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
public class WareHouseReceiptsDAO extends TheBookStoreDAO<WareHouseReceipts, String>{

    String INSERT_SQL = "INSERT INTO WareHouseReceipts VALUES (?, ?, ?, ?, ?, ?)";
    String UPDATE_SQL = "UPDATE WarehouseReceipts SET ProviderID = ?, ReceivingDate = ?, TotalCost = ?, CurrentStatus = ?, MoreInfo = ? WHERE ID = ? ";
    String DELETE_SQL = "DELETE Inventory WHERE WareHouseReceiptID =? DELETE WarehouseReceiptDetails WHERE WarehouseReceiptID =? DELETE WarehouseReceipts WHERE ID=?";
    String SELECT_ALL_SQL = "SELECT * FROM WareHouseReceipts";
    String SELECT_SQL_BY_ID = "SELECT * FROM WareHouseReceipts WHERE ID=?";
    
    @Override
    public void insert(WareHouseReceipts entity) {
        XJdbc.update(INSERT_SQL, entity.getID(), entity.getProviderID(),entity.getReceivingDate(), entity.getTotalCost(), entity.getCurrentStatus(), entity.getMoreInfo());
    }

    @Override
    public void update(WareHouseReceipts entity) {
        XJdbc.update(UPDATE_SQL, entity.getProviderID(), entity.getReceivingDate(), entity.getTotalCost(), entity.getCurrentStatus(), entity.getMoreInfo(), entity.getID());
    }

    @Override
    public void delete(String id) {
       XJdbc.update(DELETE_SQL, id);
    }

    public void deleteAll(String id1, String id2, String id3) {
       XJdbc.update(DELETE_SQL, id1, id2, id3);
    }

    
    @Override
    public WareHouseReceipts selectById(String id) {
       List<WareHouseReceipts> list = this.selectBySql(SELECT_SQL_BY_ID, id);
       if(list.isEmpty()){
           return null;
       }
       return list.get(0);
    }

    @Override
    public List<WareHouseReceipts> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    protected List<WareHouseReceipts> selectBySql(String sql, Object... args) {
        List<WareHouseReceipts> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.query(sql, args);
            while(rs.next()){
                WareHouseReceipts wareHouseReceipts = new WareHouseReceipts();
                wareHouseReceipts.setID(rs.getString("ID"));
                wareHouseReceipts.setProviderID(rs.getInt("ProviderID"));
                wareHouseReceipts.setReceivingDate(rs.getDate("ReceivingDate"));
                wareHouseReceipts.setTotalCost(rs.getDouble("TotalCost"));
                wareHouseReceipts.setCurrentStatus(rs.getString("CurrentStatus"));
                wareHouseReceipts.setMoreInfo(rs.getString("MoreInfo"));
                list.add(wareHouseReceipts);
            }
            return  list;
        } catch (SQLException ex) {
            Logger.getLogger(WareHouseReceiptsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       return null;
    }  
    
    public String IDtoName(Integer id){
        try {
            String name;
            ResultSet rs = XJdbc.query("SELECT ProviderName FROM Providers WHERE ID =?", id);
            if(rs.next()){
                name = rs.getString("ProviderName");
                return name;
            }
        } catch (SQLException ex) {
            Logger.getLogger(WareHouseReceipts.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
      }
    
    public List<WareHouseReceipts> searchIDWarehouseReceipts(String id){
          List<WareHouseReceipts> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.query("{CALL searchWarehouseReceiptID(?)}", id);
            while(rs.next()){
                WareHouseReceipts wareHouseReceipts = new WareHouseReceipts();
                wareHouseReceipts.setID(rs.getString("ID"));
                wareHouseReceipts.setProviderID(rs.getInt("ProviderID"));
                wareHouseReceipts.setReceivingDate(rs.getDate("ReceivingDate"));
                wareHouseReceipts.setTotalCost(rs.getDouble("TotalCost"));
                wareHouseReceipts.setCurrentStatus(rs.getString("CurrentStatus"));
                wareHouseReceipts.setMoreInfo(rs.getString("MoreInfo"));
                list.add(wareHouseReceipts);
            }
            return  list;
        } catch (SQLException ex) {
            Logger.getLogger(WareHouseReceiptsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       return null;
    }
    
}

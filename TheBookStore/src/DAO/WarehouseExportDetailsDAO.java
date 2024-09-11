package DAO;
import EntityClass.WarehouseExportDetails;
import ExtentionLibrary.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.block.Arrangement;
public class WarehouseExportDetailsDAO extends TheBookStoreDAO<WarehouseExportDetails, String>{

    
    String INSERT_SQL = "INSERT INTO WarehouseExportDetails VALUES (?, ?, ?, ?, ?, ?, ?)";
    String UPDARE_SQL = "UPDATE WareHouseExportDetails SET WarehouseExportID =?, InventoryID =?, Quantity =?, SellingPrice =?, CurrentStatus =?, MoreInfo =? WHERE ID =?";
    String DELETE_SQL = "DELETE WareHouseReceiptDetails WHERE ID =?";
    String SELECT_BY_ID_WareHouseReceipts = "SELECT * FROM WarehouseExportDetails WHERE WareHouseReceiptID =?";
    String SELECT_WarehouseExportDetails_Edit = "SELECT * FROM WarehouseExportDetails WHERE WarehouseExportID = ?";
    
    
    @Override
    public void insert(WarehouseExportDetails entity) {
        XJdbc.update(INSERT_SQL, entity.getID(), entity.getWarehouseExportID(), entity.getInventoryID(), entity.getQuantity(), entity.getSellingPrice(), entity.getCurrentStatus(), entity.getMoreInfo());
    }

    @Override
    public void update(WarehouseExportDetails entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public WarehouseExportDetails selectById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<WarehouseExportDetails> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<WarehouseExportDetails> selectAllEdit(String id) {
       return this.selectBySql(SELECT_WarehouseExportDetails_Edit, id);
    }
    
    @Override
    protected List<WarehouseExportDetails> selectBySql(String sql, Object... args) {
        
        try {
            List<WarehouseExportDetails> list  = new ArrayList<>();
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next()) {
                WarehouseExportDetails warehouseExportDetails = new WarehouseExportDetails();
                warehouseExportDetails.setID(rs.getString("ID"));
                warehouseExportDetails.setWarehouseExportID(rs.getString("WarehouseExportID"));
                warehouseExportDetails.setInventoryID(rs.getString("InventoryID"));
                warehouseExportDetails.setQuantity(rs.getInt("Quantity"));
                warehouseExportDetails.setSellingPrice(rs.getDouble("SellingPrice"));
                warehouseExportDetails.setCurrentStatus(rs.getString("CurrentStatus"));
                warehouseExportDetails.setMoreInfo(rs.getString("MoreInfo"));
                list.add(warehouseExportDetails);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(WarehouseExportDetailsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}

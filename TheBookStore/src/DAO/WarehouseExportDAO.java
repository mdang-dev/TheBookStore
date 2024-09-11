package DAO;

import EntityClass.WarehouseExport;
import ExtentionLibrary.XJdbc;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
public class WarehouseExportDAO  extends TheBookStoreDAO<WarehouseExport, String>{

    
    String INSERT_SQL = "INSERT INTO WarehouseExports VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    String UPDATE_SQL = "UPDATE WarehouseExports SET CustomerID =?, EmployeeID =?, DeliveringDate =?, TotalCost =?, CurrentStatus =?, MoreInfo =?, ReceiptID =? WHERE ID =? ";
    String DELETE_SQL = "DELETE WarehouseExportDetails  WHERE WarehouseExportID =? DELETE WarehouseExports WHERE ID =?";
    String SELECT_ALL_SQL = "SELECT * FROM WarehouseExports";
    String SELECT_SQL_BY_ID = "SELECT * FROM WarehouseExports WHERE ID=?";
    
    @Override
    public void insert(WarehouseExport entity) {
        XJdbc.update(INSERT_SQL, entity.getID(), entity.getCustomerID(), entity.getEmployeeID(), entity.getDeliveringDate(), entity.getTotalCost(), entity.getCurrentStatus(), entity.getMoreInfo(), entity.getReceiptID());
    }

    @Override
    public void update(WarehouseExport entity) {
        XJdbc.update(UPDATE_SQL, entity.getCustomerID(), entity.getEmployeeID(), entity.getDeliveringDate(), entity.getTotalCost(), entity.getCurrentStatus(), entity.getMoreInfo(), entity.getReceiptID(), entity.getID());
    }

    @Override
    public void delete(String id1) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

     public void deleteAll(String id1, String id2) {
         XJdbc.update(DELETE_SQL, id1, id2);
     }
    
    @Override
    public WarehouseExport selectById(String id) {
        List<WarehouseExport> list = this.selectBySql(SELECT_SQL_BY_ID, id);
        return list.get(0);
    }

    @Override
    public List<WarehouseExport> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    protected List<WarehouseExport> selectBySql(String sql, Object... args) {
        List<WarehouseExport> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next()) {
                WarehouseExport warehouseExport = new WarehouseExport();
                warehouseExport.setID(rs.getString("ID"));
                warehouseExport.setCustomerID(rs.getInt("CustomerID"));
                warehouseExport.setEmployeeID(rs.getInt("EmployeeID"));
                warehouseExport.setDeliveringDate(rs.getDate("DeliveringDate"));
                warehouseExport.setTotalCost(rs.getDouble("TotalCost"));
                warehouseExport.setCurrentStatus(rs.getString("CurrentStatus"));
                warehouseExport.setMoreInfo(rs.getString("MoreInfo"));
                warehouseExport.setReceiptID(rs.getString("ReceiptID"));
                list.add(warehouseExport);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(WarehouseExportDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public String selectName(String id){
        try {
            ResultSet rs = XJdbc.query("SELECT * FROM WarehouseExports WHERE ID =?", id);
            if(rs.next()){
                return rs.getString("ID");
            }
        } catch (SQLException ex) {
            Logger.getLogger(WarehouseExportDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
          return null;
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import EntityClass.Customer;
import EntityClass.Receipts;
import ExtentionLibrary.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class ReceiptsDAO {
    String INSERT_SQL = "INSERT INTO Receipts (ID, EmployeeID, TotalCost, MoneyReceived, MoneyReturned, CurrentStatus, CreatedDate, MoreInfo) VALUES (?,?,?,?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE Receipts SET EmployeeID = ?, TotalCost = ?, MoneyReceived = ?, MoneyReturned = ?, CurrentStatus = ?, CreatedDate = ?, MoreInfo = ? WHERE ID =?";
    String DELETE_SQL = "{CALL DeleteReceipt (?)}";
    String SELECT_ALL = "SELECT * FROM Receipts";
    String SELECT_BY_ID = "SELECT * FROM Receipts  WHERE ID = ?";

    
    public void insert(Receipts entity) {
       XJdbc.update(INSERT_SQL, entity.getID(), entity.getEmployeeID(),
               entity.getTotalCost(), entity.getMoneyReceived(),
                entity.getMoneyReturned(), entity.getCurrentStatus(), entity.getCreateDate(),
                entity.getMoreInfo());
    }

 
    public void update(Receipts entity) {
        XJdbc.update(UPDATE_SQL,   entity.getEmployeeID(),
                entity.getTotalCost(), entity.getMoneyReceived(), entity.getMoneyReturned(), entity.getCurrentStatus(), entity.getCreateDate(), entity.getMoreInfo(), entity.getID());
    }


    public void delete(String id) {
         XJdbc.update(DELETE_SQL, id);
    }

 
    public Receipts selectById(String id) throws SQLException {
         return this.selectBySql(SELECT_BY_ID, id).get(0);
    }


    public List<Receipts> selectAll() throws SQLException {
        return this.selectBySql(SELECT_ALL);
    }
    
    public String lastestReceipts() throws SQLException
    {
        String sql = "SELECT MAX(ID) FROM Receipts";
        return (String) XJdbc.value(sql);
    }

   
    protected List<Receipts> selectBySql(String sql, Object... args)  throws SQLException  {
         List<Receipts> list = new ArrayList<>();
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next())
            {
                Receipts receipts = new Receipts();
                receipts.setID(rs.getString("ID"));
                receipts.setEmployeeID(rs.getInt("EmployeeID"));
                receipts.setTotalCost(rs.getFloat("TotalCost"));
                receipts.setMoneyReceived(rs.getFloat("MoneyReceived"));
                receipts.setMoneyReturned(rs.getFloat("MoneyReturned"));
                receipts.setCurrentStatus(rs.getString("CurrentStatus"));
                receipts.setCreateDate(rs.getDate("CreatedDate"));
                receipts.setMoreInfo(rs.getString("MoreInfo"));


                list.add(receipts);
            }
            rs.getStatement().getConnection().close();
         return list;
    }
}

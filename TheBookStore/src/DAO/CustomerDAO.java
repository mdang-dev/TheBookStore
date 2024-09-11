/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import EntityClass.Customer;
import java.sql.ResultSet;
import ExtentionLibrary.XJdbc;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class CustomerDAO {
    String INSERT_SQL = "INSERT INTO Customers (CustomerName, PhoneNumber, addressCustomers, ContractDate, Email, MoreInfo) VALUES (?,?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE Customers SET CustomerName = ?, PhoneNumber = ?, addressCustomers = ?, ContractDate = ?, Email = ?, MoreInfo = ? WHERE ID =?";
    String DELETE_SQL = "DELETE FROM Customers WHERE ID = ?";
    String SELECT_ALL = "SELECT * FROM Customers";
    String SELECT_BY_ID = "SELECT * FROM Customers WHERE ID = ?";
    
    

    public void insert(Customer entity) {
        XJdbc.update(INSERT_SQL, entity.getCustomerName(), entity.getPhoneNumber(),
                entity.getAddressCustomers(), entity.getContractDate(), entity.getEmail(), entity.getMoreInfo());
    }

    public void update(Customer entity) {
      XJdbc.update(UPDATE_SQL,  entity.getCustomerName(), entity.getPhoneNumber(),
                entity.getAddressCustomers(), entity.getContractDate(), entity.getEmail(), entity.getMoreInfo(), entity.getID());
    }

    public void delete(Integer id) {
        
       XJdbc.update(DELETE_SQL, id);
    }

    public List<Customer> selectById(Integer id) throws SQLException {
        
            return this.selectBySql(SELECT_BY_ID, id);
    }

    public List<Customer> selectAll() throws SQLException {
         return this.selectBySql(SELECT_ALL);
    }
    
    public String selectName(Integer id){
        try {
            ResultSet rs = XJdbc.query("SELECT CustomerName FROM Customers WHERE ID =?" , id);
            if(rs.next()){
                return rs.getString("CustomerName");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
                    return null;
    }

   
    protected List<Customer> selectBySql(String sql, Object... args) throws SQLException {
      
            List<Customer> list = new ArrayList<>();
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next())
            {
                Customer customer = new Customer();
                customer.setID(rs.getInt("ID"));
                customer.setCustomerName(rs.getString("CustomerName"));
                customer.setPhoneNumber(rs.getString("PhoneNumber"));
                customer.setAddressCustomers(rs.getString("addressCustomers"));
                customer.setContractDate(rs.getDate("ContractDate"));
                customer.setEmail(rs.getString("Email"));
                customer.setMoreInfo(rs.getString("MoreInfo"));
                list.add(customer);
            }
            rs.getStatement().getConnection().close();
         return list;
    }
    public List<Customer> selectByKeyWord(String keyWord) throws SQLException {
        String sql = "SELECT * FROM Customers WHERE (ID LIKE ? OR CustomerName LIKE ? OR PhoneNumber LIKE ? OR Email LIKE ? OR addressCustomers LIKE ?)";
        return this.selectBySql(sql, "%" + keyWord + "%", "%" + keyWord + "%", "%" + keyWord + "%", "%" + keyWord + "%", "%" + keyWord + "%");
    }
    
    }

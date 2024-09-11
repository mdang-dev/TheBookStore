/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import EntityClass.Products;
import ExtentionLibrary.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class ProductDAO {

    String INSERT_SQL = "INSERT INTO Products (ID, ProductName, TypeOfProductID, Author, Publisher, Genre, MoreInfo, BarCode, EmployeeID, ImagePath) VALUES (?,?,?,?,?,?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE Products SET ProductName = ?, TypeOfProductID = ?, Author = ?, Publisher = ?, Genre = ?, MoreInfo = ?, BarCode = ?, EmployeeID = ?, ImagePath = ? WHERE ID =?";
    String DELETE_SQL = "DELETE FROM Products WHERE ID = ?";
    String SELECT_ALL = "SELECT * FROM Products";
    String SELECT_BY_ID = "SELECT * FROM Products WHERE ID = ?";

    public void insert(Products p) throws SQLException {
        XJdbc.update(INSERT_SQL, p.getID(), p.getProductName(), p.getTypeOfProductID(), p.getAuthor(),
                p.getPublisher(), p.getGenre(), p.getMoreInfo(), p.getBarCode(),
                p.getEmployeeID(), p.getImagePath());
    }

    public void update(Products p) throws SQLException {
        XJdbc.update(UPDATE_SQL, p.getProductName(), p.getTypeOfProductID(), p.getAuthor(),
                p.getPublisher(), p.getGenre(), p.getMoreInfo(), p.getBarCode(),
                p.getEmployeeID(), p.getImagePath(), p.getID());
    }

    public void delete(String ID) throws SQLException {
        XJdbc.update(DELETE_SQL, ID);
    }

    public List<Products> selectAll() throws SQLException {
        return this.selectBySql(SELECT_ALL);
    }

    public List<Products> selectById(String ID) throws SQLException {
        return this.selectBySql(SELECT_BY_ID, ID);
    }
    
    public boolean isRemained(String id) throws SQLException
    {
        String sql = "SELECT AvailableQuantity FROM Inventory WHERE ProductID = ?";
        ResultSet rs = XJdbc.query(sql, id);
        while (rs.next())
        {
            if (rs.getInt("AvailableQuantity") > 0)
            {
                return true;
            }
        }
        
        return false;
    }

    public List<Products> selectBookByIdOrName(String id, String bookName) throws SQLException {
        String sql = "SELECT * FROM Products WHERE (ID LIKE '%" + id + "%' OR ProductName LIKE N'%" + bookName + "%') AND TypeOfProductID = 1";
        return this.selectBySql(sql);
    }

    public Map<Integer, String[]> selectByTypeOfProduct(int id) throws SQLException {
        String sql = "";
        if (id == 1 || id == 2) {
            sql = "SELECT P.ID, P.ProductName, P.TypeOfProductID, P.Genre, I.AvailableQuantity,"
                    + " I.SellingPrice, I.ID FROM Products P LEFT JOIN Inventory I ON I.ProductID = P.ID WHERE P.TypeOfProductID=" + id;
        } else {
            sql = "SELECT P.ID, P.ProductName, P.TypeOfProductID, P.Genre, I.AvailableQuantity,"
                    + " I.SellingPrice, I.ID FROM Products P LEFT JOIN Inventory I ON I.ProductID = P.ID";
        }

        ResultSet rs = XJdbc.query(sql);
        Map<Integer, String[]> map = new HashMap<>();
        int i = 0;
        while (rs.next()) {
            String myString[] = new String[7];
            myString[0] = rs.getString(1);
            myString[1] = rs.getString(2);
            myString[2] = rs.getInt(3) == 1 ? "Sách" : "Văn Phòng Phẩm";
            myString[3] = rs.getString(4);
            myString[4] = rs.getString(5);
            myString[5] = rs.getString(6);
            myString[6] = rs.getString(7);
            map.put(i, myString);
            i++;
        }
        return map;
    }

    public Map<Integer, String[]> selectByProductId(String id) throws SQLException {
        String sql = "SELECT P.ID, P.ProductName, P.TypeOfProductID, P.Genre, I.AvailableQuantity,"
                + " I.SellingPrice, I.ID FROM Products P LEFT JOIN Inventory I ON I.ProductID = P.ID"
                + " WHERE P.ID LIKE '%" + id + "%'";
        ResultSet rs = XJdbc.query(sql);
        Map<Integer, String[]> map = new HashMap<>();
        int i = 0;
        while (rs.next()) {
            String myString[] = new String[7];
            myString[0] = rs.getString(1);
            myString[1] = rs.getString(2);
            myString[2] = rs.getInt(3) == 1 ? "Sách" : "Văn Phòng Phẩm";
            myString[3] = rs.getString(4);
            myString[4] = rs.getString(5);
            myString[5] = rs.getString(6);
            myString[6] = rs.getString(7);
            map.put(i, myString);
            i++;
        }
        return map;
    }

    public List<Products> SelectByIdTypeOfProduct() throws SQLException {
        String sql = "SELECT * FROM Products WHERE TypeOfProductID = 2";
        return this.selectBySql(sql);
    }

    public List<Products> SelectByKeyWord(String keyWord) throws SQLException {
        String sql = "SELECT * FROM Products WHERE (ID LIKE ? OR ProductName LIKE ? OR Genre LIKE ?) AND TypeOfProductID = 2";
        return this.selectBySql(sql, keyWord + "%", keyWord + "%", keyWord + "%");
    }

    public List<Products> spSearchProduct(String name) {
        try {
            List<Products> list = new ArrayList<>();
            ResultSet rs = XJdbc.query("{CALL SearchProductWarehouse(?)}", name);
            while (rs.next()) {
                Products product = new Products();
                product.setID(rs.getString("ID"));
                product.setProductName(rs.getString("ProductName"));
                product.setTypeOfProductID(rs.getInt("TypeOfProductID"));
                product.setAuthor(rs.getString("Author"));
                product.setPublisher(rs.getString("Publisher"));
                product.setGenre(rs.getString("Genre"));
                product.setMoreInfo(rs.getString("MoreInfo"));
                product.setBarCode(rs.getString("Barcode"));
                product.setEmployeeID(rs.getInt("EmployeeID"));
                product.setImagePath(rs.getString("ImagePath"));
                list.add(product);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String selectName(String id) {
        try {
            ResultSet rs = XJdbc.query("SELECT * FROM Products WHERE ID =?", id);
            if (rs.next()) {
                return rs.getString("ProductName");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Products selectByIdSQL(String ID) throws SQLException {
        Products product = new Products();
        ResultSet rs = XJdbc.query(SELECT_BY_ID, ID);
        if (rs.next()) {
            product.setID(rs.getString("ID"));
            product.setProductName(rs.getString("ProductName"));
            product.setTypeOfProductID(rs.getInt("TypeOfProductID"));
            product.setAuthor(rs.getString("Author"));
            product.setPublisher(rs.getString("Publisher"));
            product.setGenre(rs.getString("Genre"));
            product.setMoreInfo(rs.getString("MoreInfo"));
            product.setBarCode(rs.getString("Barcode"));
            product.setEmployeeID(rs.getInt("EmployeeID"));
            product.setImagePath(rs.getString("ImagePath"));
        }
        rs.getStatement().getConnection().close();
        return product;
    }

    protected List<Products> selectBySql(String sql, Object... args) throws SQLException {
        List<Products> list = new ArrayList<>();
        ResultSet rs = XJdbc.query(sql, args);
        while (rs.next()) {
            Products product = new Products();
            product.setID(rs.getString("ID"));
            product.setProductName(rs.getString("ProductName"));
            product.setTypeOfProductID(rs.getInt("TypeOfProductID"));
            product.setAuthor(rs.getString("Author"));
            product.setPublisher(rs.getString("Publisher"));
            product.setGenre(rs.getString("Genre"));
            product.setMoreInfo(rs.getString("MoreInfo"));
            product.setBarCode(rs.getString("Barcode"));
            product.setEmployeeID(rs.getInt("EmployeeID"));
            product.setImagePath(rs.getString("ImagePath"));
            list.add(product);
        }
        rs.getStatement().getConnection().close();
        return list;
    }
}

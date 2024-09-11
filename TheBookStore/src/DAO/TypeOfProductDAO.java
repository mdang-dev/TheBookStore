package DAO;

import java.util.List;
import ExtentionLibrary.XJdbc;
import EntityClass.TypeOfProduct;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;

public class TypeOfProductDAO extends TheBookStoreDAO<TypeOfProduct, Integer>{
    
    
        String INSERT_SQL = "INSERT INTO TypeOfProduct VALUES (?)";
        String UPDATE_SQL = "UPDATE  TypeOfProduct SET TypeOfProduct=? WHERE ID =?";
        String DELETE_SQL = "DELETE TypeOfProduct WHERE ID =?";
        String SELECT_ALL_SQL = "SELECT * FROM TypeOfProduct";
        String SELECT_BY_ID_SQL = "SELECT * FROM TypeOfProduct WHERE ID =?";

    @Override
    public void insert(TypeOfProduct entity) {
       XJdbc.update(INSERT_SQL, entity.getTypeOfProductName());
    }

    @Override
    public void update(TypeOfProduct entity) {
        XJdbc.update(UPDATE_SQL, entity.getTypeOfProductName(), entity.getID());
    }

    @Override
    public void delete(Integer id) {
        XJdbc.update(DELETE_SQL, id);
    }

    @Override
    public TypeOfProduct selectById(Integer id) {
        List<TypeOfProduct> list = this.selectBySql(SELECT_BY_ID_SQL, id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<TypeOfProduct> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    protected List<TypeOfProduct> selectBySql(String sql, Object... args) {
        List<TypeOfProduct> list = new ArrayList<>();
            try {
                ResultSet rs = XJdbc.query(sql, args);
                while (rs.next()) {                    
                    TypeOfProduct typeOfProduct = new TypeOfProduct();
                    typeOfProduct.setID(rs.getInt("ID"));
                    typeOfProduct.setTypeOfProductName(rs.getString("TypeOfProduct"));
                    list.add(typeOfProduct);
                }
                   rs.getStatement().getConnection().close();
                return list;
            } catch (SQLException ex) {
                Logger.getLogger(TypeOfProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
    }
    
    public List<TypeOfProduct> seachTypeOfProduct(String key) {
            try {
                List<TypeOfProduct> list = new ArrayList<>();
                String sql = "{CALL sp_SeachTypeOfProduct(?)}";
                PreparedStatement stmt = XJdbc.getStatement(sql, key);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {                    
                    TypeOfProduct typeOfProduct = new TypeOfProduct();
                    typeOfProduct.setID(rs.getInt("ID"));
                    typeOfProduct.setTypeOfProductName(rs.getString("TypeOfProduct"));
                    list.add(typeOfProduct);
                }
                rs.getStatement().getConnection().close();
                return  list;
            } catch (SQLException ex) {
                Logger.getLogger(TypeOfProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
    }
    
}

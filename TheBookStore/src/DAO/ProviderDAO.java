package DAO;

import EntityClass.Providers;
import ExtentionLibrary.XJdbc;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nguye
 */

public class ProviderDAO {

    String INSERT_SQL = "INSERT INTO Providers(ProviderName, PhoneNumber, addressProviders, ContractDate, Email, MoreInfo) VALUES (?,?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE  Providers SET ProviderName = ?, PhoneNumber = ?, addressProviders = ?, ContractDate = ?, Email = ?, MoreInfo = ? WHERE ID = ?";
    String DELETE_SQL = "DELETE Providers WHERE ID = ?";
    String SELECT_ALL_SQL = "SELECT * FROM Providers";
    String SELECT_BY_ID_SQL = "SELECT * FROM Providers WHERE ID = ?";

    public void insert(Providers en) throws SQLException {
        XJdbc.update(INSERT_SQL, en.getProvidersName(), en.getPhoneNumber(), en.getAddressProviders(), en.getContractDate(), en.getEmail(), en.getMoreInfo());
    }

    public void update(Providers en) throws SQLException {
        XJdbc.update(UPDATE_SQL, en.getProvidersName(), en.getPhoneNumber(), en.getAddressProviders(), en.getContractDate(), en.getEmail(), en.getMoreInfo(), en.getProvidersID());
    }

    public void delete(Integer id) throws SQLException {
        XJdbc.update(DELETE_SQL, id);
    }

    public Providers selectById(Integer id) throws SQLException {
        return this.selectBySql(SELECT_BY_ID_SQL, id).get(0);
    }

    public List<Providers> selectAll() throws SQLException {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    
    public List<Providers> selectByKeyWord(String keyWord) throws SQLException {
        String sql = "SELECT * FROM Providers WHERE (ID LIKE ? OR ProviderName LIKE ? OR PhoneNumber LIKE ? OR Email LIKE ? OR addressProviders LIKE ?)";
        return this.selectBySql(sql, "%" + keyWord + "%", "%" + keyWord + "%", "%" + keyWord + "%", "%" + keyWord + "%", "%" + keyWord + "%");
    }
    
//    public List<Providers> selectByIdProv(String idprov) throws SQLException {
//        String sql = "SELECT * FROM Providers WHERE ID LIKE ?";
//        return this.selectBySql(sql, "%" + idprov + "%");
//    }
//    
//    public List<Providers> selectByNameProv(String nameprov) throws SQLException {
//        String sql = "SELECT * FROM Providers WHERE ProviderName LIKE ?";
//        return this.selectBySql(sql, "%" + nameprov + "%");
//    }

    protected List<Providers> selectBySql(String sql, Object... args) {
        List<Providers> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next()) {
                Providers providers = new Providers();
                providers.setProvidersID(rs.getInt("ID"));
                providers.setProvidersName(rs.getString("ProviderName"));
                providers.setPhoneNumber(rs.getString("PhoneNumber"));
                providers.setAddressProviders(rs.getString("addressProviders"));
                providers.setContractDate(rs.getDate("ContractDate"));
                providers.setEmail(rs.getString("Email"));
                providers.setMoreInfo(rs.getString("MoreInfo"));
                list.add(providers);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public String selectName(Integer id){
        try {
            ResultSet rs = XJdbc.query("SELECT ProviderName FROM Providers WHERE ID=?", id);
            if(rs.next()){
                return rs.getString("ProviderName");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProviderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

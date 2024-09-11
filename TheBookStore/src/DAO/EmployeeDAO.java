package DAO;

import EntityClass.Employees;
import ExtentionLibrary.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;

public class EmployeeDAO extends TheBookStoreDAO<Employees, Integer> {
//    ID INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
//	EmployeeName VARCHAR(100) NOT NULL,
//	Username VARCHAR(50) NOT NULL,
//	Password VARCHAR(50) NOT NULL,
//	Gender BIT NOT NULL,
//	DateOfBirth DATE NOT NULL,
//	EmployeeRole BIT NOT NULL, 
//	Email VARCHAR(200),
//	PhoneNumber VARCHAR(20) NOT NULL,
//	MoreInfo NVARCHAR(MAX)

    String INSERT_SQL = "INSERT INTO Employees (EmployeeName, Username, EmployeePassword, Gender, DateOfBirth, EmployeeRole, Email, PhoneNumber, MoreInfo) VALUES (?,?,?,?,?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE Employees SET EmployeeName = ?, Username = ?, EmployeePassword = ?, Gender = ?, DateOfBirth = ?, EmployeeRole = ?, Email = ?, PhoneNumber = ?, MoreInfo = ? WHERE ID = ?";
    String DELETE_SQL = "DELETE FROM Employees WHERE ID = ?";
    String SELECT_ALL_SQL = "SELECT * FROM Employees";
    String SELECT_BY_ID_SQL = "SELECT * FROM Employees WHERE ID = ?";
    String SELECT_BY_USERNAME_SQL = "SELECT * FROM Employees WHERE Username = ?";
    String SELECT_BY_KEYWORD_SQL = "SELECT * FROM Employees WHERE (EmployeeName LIKE ? OR PhoneNumber LIKE ? OR Email LIKE ?)";

    @Override
    public void insert(Employees e) {
        XJdbc.update(INSERT_SQL, e.getEmployeeName(), e.getUserName(), e.getEmployeePassword(), e.isGender(), e.getDateOfBirth(), e.isEmployeeRole(), e.getEmail(), e.getPhoneNumber(), e.getMoreInfo());
    }

    @Override
    public void update(Employees e) {
        XJdbc.update(UPDATE_SQL, e.getEmployeeName(), e.getUserName(), e.getEmployeePassword(), e.isGender(), e.getDateOfBirth(), e.isEmployeeRole(), e.getEmail(), e.getPhoneNumber(), e.getMoreInfo(), e.getIdEmployee());
    }

    @Override
    public void delete(Integer id) {
        XJdbc.update(DELETE_SQL, id);
    }

    @Override
    public Employees selectById(Integer id) {
        List<Employees> list = this.selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public List<Employees> selectByName(String name) {
//        return this.selectBySql(SELECT_BY_USERNAME_SQL, name);

        List<Employees> list = this.selectBySql(SELECT_BY_USERNAME_SQL, name);
        if (list.isEmpty()) {
            return null;
        }
        return  list;
//        List<Employees> list = this.selectBySql(SELECT_BY_ID_SQL, name);
//        if (list.isEmpty()) {
//            return null;
//        }
//        return list.get(0);
    }

    @Override
    public List<Employees> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }
//    public List<Employees> selectByNameEmp(String empName) throws SQLException{
//        String sql = "SELECT * FROM Employees WHERE EmployeeName LIKE ? OR PhoneNumber LIKE ?";
//        return this.selectBySql(sql, "%" + empName + "%");
//    }

    public List<Employees> selectByNameEmp(String empName) throws SQLException {
        return this.selectBySql(SELECT_BY_KEYWORD_SQL, "%" + empName + "%", "%" + empName + "%", "%" + empName + "%");
    }

    public String selectName(Integer id) {
        try {
            ResultSet rs = XJdbc.query("SELECT EmployeeName FROM Employees WHERE ID = ?", id);
            if (rs.next()) {
                return rs.getString("EmployeeName");
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    protected List<Employees> selectBySql(String sql, Object... args) {
        List<Employees> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next()) {
                Employees employees = new Employees();
                employees.setIdEmployee(rs.getInt("ID"));
                employees.setEmployeeName(rs.getString("EmployeeName"));
                employees.setUserName(rs.getString("Username"));
                employees.setEmployeePassword(rs.getString("EmployeePassword"));
                employees.setGender(rs.getBoolean("Gender"));
                employees.setDateOfBirth(rs.getDate("DateOfBirth"));
                employees.setEmployeeRole(rs.getBoolean("EmployeeRole"));
                employees.setEmail(rs.getString("Email"));
                employees.setPhoneNumber(rs.getString("PhoneNumber"));
                employees.setMoreInfo(rs.getString("MoreInfo"));
                list.add(employees);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

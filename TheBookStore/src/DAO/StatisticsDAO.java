package DAO;

import ExtentionLibrary.XJdbc;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author nguye
 */
public class StatisticsDAO {

    // Hàm hỗ trợ lấy dữ liệu từ cơ sở dữ liệu và trả về dưới dạng danh sách các mảng đối tượng
    private List<Object[]> getListOfArray(String sql, String[] cols, Object... args) {
        List<Object[]> list = new ArrayList<>();
        try (PreparedStatement stmt = XJdbc.getStatement(sql, args);
             ResultSet rs = stmt.executeQuery()) {

            // Xử lý kết quả
            while (rs.next()) {
                Object[] vals = new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    vals[i] = rs.getObject(cols[i]);
                }
                list.add(vals);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error while executing SQL query: " + sql, e);
        }
        return list;
    }

    // Hàm lấy doanh thu dựa trên khoảng thời gian
    public List<Object[]> getDoanhThu(Date startDate, Date endDate) {
        String sql = "{CALL RevenueStatistics (?,?)}";
        String[] cols = {"Date", "Total_Revenue"};

        // Chuyển đổi Date thành java.sql.Date
//        java.sql.Date sqlStartDate = startDate != null ? new java.sql.Date(startDate.getTime()) : null;
//        java.sql.Date sqlEndDate = endDate != null ? new java.sql.Date(endDate.getTime()) : null;

        return this.getListOfArray(sql, cols, startDate, endDate);
    }
}

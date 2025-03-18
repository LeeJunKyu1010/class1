import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class P_skuDAO {
	

	// DB 연결하기
   public Connection getConnection() throws SQLException {
        try {
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
            return ds.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("데이터베이스 연결 실패");
        }
    }
   // 내가 입력한거 삽입
   // id는 1씩 오르고 SYSDATE로 지금날짜를 나오게했고 수정날짜는 일단 null로 해놨다 
    public int insertsku(P_skuDTO p_skuDTO) throws SQLException {
        int result = -1;
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = getConnection();
            String query = "INSERT INTO p_sku VALUES (seq_p_sku.nextval, ?, ?, ?, ?, ?, SYSDATE, NULL, ?)";
            ps = con.prepareStatement(query);
            ps.setString(1, p_skuDTO.getSku_code());
            ps.setString(2, p_skuDTO.getSku_name());
            ps.setString(3, p_skuDTO.getSku_size());
            ps.setString(4, p_skuDTO.getVendor_name());
            ps.setInt(5, p_skuDTO.getPrice());
            ps.setString(6, p_skuDTO.getSku_category());
            result = ps.executeUpdate();
        } finally {
            if (ps != null) ps.close();
            if (con != null) con.close();
        }
        return result;
    }
    
 // 내가 등록한 테이블 전체 가져오기
    public List<P_skuDTO> selectP_skuList() throws SQLException {
        List<P_skuDTO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = getConnection();
            String query = "SELECT * FROM p_sku";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                P_skuDTO dto = new P_skuDTO();
                dto.setSku_id(rs.getInt("sku_id"));
                dto.setSku_code(rs.getString("sku_code"));
                dto.setSku_name(rs.getString("sku_name"));
                dto.setSku_size(rs.getString("sku_size"));
                dto.setVendor_name(rs.getString("vendor_name"));
                dto.setPrice(rs.getInt("price"));
                dto.setCreate_date(rs.getDate("create_date"));
                dto.setModify_date(rs.getDate("modify_date"));
                dto.setSku_category(rs.getString("sku_category"));
                list.add(dto);
            }
        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (con != null) con.close();
        }
        return list;
    }
    
    // 삭제할때 쓰이는 것
    public int deleteSkus(String[] skuIds) throws SQLException {
        int result = 0;
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = getConnection();
            String query = "DELETE FROM p_sku WHERE sku_id = ?";
            ps = con.prepareStatement(query);
            for (String skuId : skuIds) {
                ps.setInt(1, Integer.parseInt(skuId));
                result += ps.executeUpdate();
            }
        } finally {
            if (ps != null) ps.close();
            if (con != null) con.close();
        }
        return result;
    }
    // 이건 수정할때 쓰이는 업데이트 
    public int updateSku(P_skuDTO p_skuDTO) throws SQLException {
        int result = 0;
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = getConnection();
            String query = "UPDATE p_sku SET sku_code = ?, sku_name = ?, sku_size = ?, vendor_name = ?, price = ?, modify_date = SYSDATE, sku_category = ? WHERE sku_id = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, p_skuDTO.getSku_code());
            ps.setString(2, p_skuDTO.getSku_name());
            ps.setString(3, p_skuDTO.getSku_size());
            ps.setString(4, p_skuDTO.getVendor_name());
            ps.setInt(5, p_skuDTO.getPrice());
            ps.setString(6, p_skuDTO.getSku_category());
            ps.setInt(7, p_skuDTO.getSku_id());
            result = ps.executeUpdate();
        } finally {
            if (ps != null) ps.close();
            if (con != null) con.close();
        }
        return result;
    }
    
    // 조회할때 쓰이는 것
    public List<P_skuDTO> searchP_skuList(String searchKeyword) throws SQLException {
        List<P_skuDTO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = getConnection();
            String query = "SELECT * FROM p_sku WHERE sku_code LIKE ? OR sku_name LIKE ?";
            ps = con.prepareStatement(query);
            ps.setString(1, "%" + searchKeyword + "%");
            ps.setString(2, "%" + searchKeyword + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                P_skuDTO dto = new P_skuDTO();
                dto.setSku_id(rs.getInt("sku_id"));
                dto.setSku_code(rs.getString("sku_code"));
                dto.setSku_name(rs.getString("sku_name"));
                dto.setSku_size(rs.getString("sku_size"));
                dto.setVendor_name(rs.getString("vendor_name"));
                dto.setPrice(rs.getInt("price"));
                dto.setCreate_date(rs.getDate("create_date"));
                dto.setModify_date(rs.getDate("modify_date"));
                dto.setSku_category(rs.getString("sku_category"));
                list.add(dto);
            }
        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (con != null) con.close();
        }
        return list;
    }
}
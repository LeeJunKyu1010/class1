import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class P_material_in_out2DAO {

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

	// 내가 등록한 테이블 전체 가져오기
	// 상품정보관리에서 상품코드,상품명,규격도 가져왔음
	public List<P_material_in_out2DTO> selectP_skuList() throws SQLException {
		List<P_material_in_out2DTO> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String query = "SELECT pmio.*, ps.sku_code, ps.sku_name, ps.sku_size "
					+ "FROM P_MATERIAL_IN_OUT pmio LEFT JOIN P_SKU ps ON pmio.sku_id = ps.sku_id";
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				P_material_in_out2DTO dto = new P_material_in_out2DTO();
				dto.setIb_id(rs.getInt("ib_id"));
				dto.setMaterial_count(rs.getInt("material_count")); // 데이터 타입 수정
				dto.setMaterial_price(rs.getInt("material_price")); // 데이터 타입 수정
				dto.setSku_code(rs.getString("sku_code"));
				dto.setSku_name(rs.getString("sku_name"));
				dto.setSku_size(rs.getString("sku_size"));
				dto.setSku_type(rs.getString("sku_type"));
				dto.setCreate_date(rs.getDate("create_date"));
				dto.setModify_date(rs.getDate("modify_date"));
				dto.setRemarks(rs.getString("remarks"));
				dto.setSku_id(rs.getInt("sku_id"));
				dto.setBill_id(rs.getInt("bill_id"));
				list.add(dto);
			}
		} finally {
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
			if (con != null)
				con.close();
		}
		return list;
	}
	 // 조회할때 쓰이는 것
	public List<P_material_in_out2DTO> searchP_skuList(String searchKeyword) throws SQLException {
	    List<P_material_in_out2DTO> list = new ArrayList<>();
	    Connection con = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    try {
	        con = getConnection();
	        String query = "SELECT pmio.*, ps.sku_code, ps.sku_name, ps.sku_size " +
	                       "FROM P_MATERIAL_IN_OUT pmio LEFT JOIN P_SKU ps ON pmio.sku_id = ps.sku_id " +
	                       "WHERE UPPER(ps.sku_code) LIKE UPPER(?) OR UPPER(ps.sku_name) LIKE UPPER(?)";
	        ps = con.prepareStatement(query);
	        ps.setString(1, "%" + searchKeyword + "%");
	        ps.setString(2, "%" + searchKeyword + "%");
	        rs = ps.executeQuery();
	        while (rs.next()) {
	            P_material_in_out2DTO dto = new P_material_in_out2DTO();
	            dto.setIb_id(rs.getInt("ib_id"));
	            dto.setMaterial_count(rs.getInt("material_count"));
	            dto.setMaterial_price(rs.getInt("material_price"));
	            dto.setSku_code(rs.getString("sku_code") != null ? rs.getString("sku_code") : "");
	            dto.setSku_name(rs.getString("sku_name") != null ? rs.getString("sku_name") : "");
	            dto.setSku_size(rs.getString("sku_size") != null ? rs.getString("sku_size") : "");
	            dto.setSku_type(rs.getString("sku_type"));
	            dto.setCreate_date(rs.getDate("create_date"));
	            dto.setModify_date(rs.getDate("modify_date"));
	            dto.setRemarks(rs.getString("remarks") != null ? rs.getString("remarks") : "");
	            dto.setSku_id(rs.getInt("sku_id"));
	            dto.setBill_id(rs.getInt("bill_id"));
	            list.add(dto);
	        }
	    } finally {
	        if (rs != null) try { rs.close(); } catch (SQLException e) {}
	        if (ps != null) try { ps.close(); } catch (SQLException e) {}
	        if (con != null) try { con.close(); } catch (SQLException e) {}
	    }
	    return list;
	}
}


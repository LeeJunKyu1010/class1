import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;





public class P_work_methodDAO {

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
			public int insertsku(P_work_methodDTO p_skuDTO) throws SQLException {
			        int result = -1;
			        Connection con = null;
			        PreparedStatement ps = null;
			        try {
			            con = getConnection();
			            String query = "INSERT INTO p_work_method (work_method,work,consumption,sku_id) "
			                     + " VALUES (seq_p_material_in_out.nextval, ?, ?, ?)";
			            ps = con.prepareStatement(query);
			            ps.setString(1, p_skuDTO.getWork()); 
			            ps.setInt(2, p_skuDTO.getConsumption());              
			            ps.setInt(3, p_skuDTO.getSku_id()); 
			            
			            result = ps.executeUpdate();
			        } finally {
			            if (ps != null) ps.close();
			            if (con != null) con.close();
			        }
			        return result;
			    }
		    
			// 내가 등록한 테이블 전체 가져오기
			// 상품정보관리에서 상품코드,상품명,규격도 가져왔음
			public List<P_work_methodDTO> selectP_skuList() throws SQLException {
			    List<P_work_methodDTO> list = new ArrayList<>();
			    Connection con = null;
			    PreparedStatement ps = null;
			    ResultSet rs = null;
			    try {
			        con = getConnection();
			        String query = " SELECT pmio.*, ps.sku_code, ps.sku_name" +
			                       " FROM P_WORK_METHOD pmio LEFT JOIN P_SKU ps ON pmio.sku_id = ps.sku_id";
			        ps = con.prepareStatement(query);
			        rs = ps.executeQuery();
			        while (rs.next()) {
			        	P_work_methodDTO dto = new P_work_methodDTO();
			            dto.setWork_method(rs.getString("work_method"));
			            dto.setSku_code(rs.getString("sku_code")); // 데이터 타입 수정
			            dto.setSku_name(rs.getString("sku_name")); // 데이터 타입 수정
			            dto.setWork(rs.getString("work"));
			            dto.setConsumption(rs.getInt("consumption"));
			            dto.setSku_id(rs.getInt("sku_id"));
			            
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
		            String query = "DELETE FROM p_work_method WHERE work_method = ?";
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
		    public int updateSku(P_work_methodDTO p_skuDTO) throws SQLException {
		        int result = 0;
		        Connection con = null;
		        PreparedStatement ps = null;
		        try {
		            con = getConnection();
		            String query = "UPDATE p_work_method SET work=?, consumption=? WHERE work_method = ?";
		            ps = con.prepareStatement(query);
		            ps.setString(1, p_skuDTO.getWork());
		            ps.setInt(2, p_skuDTO.getConsumption());
		            ps.setString(3, p_skuDTO.getWork_method());
		            result = ps.executeUpdate();
		        } finally {
		            if (ps != null) ps.close();
		            if (con != null) con.close();
		        }
		        return result;
		    }
		    
		    // 조회할때 쓰이는 것
			public List<P_work_methodDTO> searchP_skuList(String searchKeyword) throws SQLException {
			    List<P_work_methodDTO> list = new ArrayList<>();
			    Connection con = null;
			    PreparedStatement ps = null;
			    ResultSet rs = null;
			    try {
			        con = getConnection();
			        String query = " SELECT pmio.*, ps.sku_code, ps.sku_name" +
			                       " FROM p_work_method pmio LEFT JOIN P_SKU ps ON pmio.sku_id = ps.sku_id " +
			                       " WHERE UPPER(ps.sku_code) LIKE UPPER(?) OR UPPER(ps.sku_name) LIKE UPPER(?)";
			        ps = con.prepareStatement(query);
			        ps.setString(1, "%" + searchKeyword + "%");
			        ps.setString(2, "%" + searchKeyword + "%");
			        rs = ps.executeQuery();
			        while (rs.next()) {
			        	P_work_methodDTO dto = new P_work_methodDTO();
			            dto.setWork_method(rs.getString("work_method"));			            
			            dto.setSku_code(rs.getString("sku_code") != null ? rs.getString("sku_code") : "");
			            dto.setSku_name(rs.getString("sku_name") != null ? rs.getString("sku_name") : "");			            
			            dto.setWork(rs.getString("work") != null ? rs.getString("work") : "");
			            dto.setConsumption(rs.getInt("consumption"));
			            dto.setSku_id(rs.getInt("sku_id"));
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

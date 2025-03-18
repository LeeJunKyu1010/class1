import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class EqDAO {

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

	// 등록
	public int insertEq(EqDTO eqDTO) throws SQLException {
		int result = -1;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = getConnection();
			String query = "INSERT INTO P_FACILITY VALUES (?,?,?,?,?,?,?)";
			ps = con.prepareStatement(query);
			if (eqDTO.getFacility_code() == null || eqDTO.getFacility_code().isEmpty()) {
				throw new SQLException("FACILITY_CODE cannot be null");
			}

			ps.setString(1, eqDTO.getFacility_code());
			ps.setString(2, eqDTO.getFacility_manager());
			ps.setDate(3, eqDTO.getInstallation_date());
			ps.setString(4, eqDTO.getFacility_name());
			ps.setString(5, eqDTO.getFacility_location());
			ps.setString(6, eqDTO.getInspection_cycle());
			ps.setString(7, eqDTO.getRemarks());

			result = ps.executeUpdate();
		} finally {
			if (ps != null)
				ps.close();
			if (con != null)
				con.close();
		}
		return result;
	}

	// 내가 등록한 테이블 전체 가져오기
	public List<EqDTO> selectEqList() throws SQLException {
		List<EqDTO> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String query = "SELECT * FROM P_FACILITY";
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				EqDTO dto = new EqDTO();
				dto.setFacility_code(rs.getString("FACILITY_CODE"));
				dto.setFacility_manager(rs.getString("FACILLITY_MANAGER"));
				dto.setInstallation_date(rs.getDate("INSTALLATION_DATE"));
				dto.setFacility_name(rs.getString("FACILITY_NAME"));
				dto.setFacility_location(rs.getString("FACILITY_LOCATION"));
				dto.setInspection_cycle(rs.getString("INSPECTION_CYCLE"));
				dto.setRemarks(rs.getString("REMARKS"));

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

	// 삭제할때 쓰이는 것
	public int deleteEq(String[] eqid) throws SQLException {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = getConnection();
			String query = "DELETE FROM p_sku WHERE P_FACILITY = ?";
			ps = con.prepareStatement(query);
//			for (String skuId : eqid) {
//				ps.setInt(1, Integer.parseInt(skuId));
//				result += ps.executeUpdate();
//			}
		} finally {
			if (ps != null)
				ps.close();
			if (con != null)
				con.close();
		}
		return result;
	}

	// 이건 수정할때 쓰이는 업데이트
	public int updateEq(EqDTO eqDTO) throws SQLException {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = getConnection();
			String query = "UPDATE P_FACILITY SET FACILITY_CODE = ?, FACILLITY_MANAGER = ?, INSTALLATION_DATE = SYSDATE, FACILITY_NAME = ?, FACILITY_LOCATION = ?, INSPECTION_CYCLE = ?, REMARKS = ?";
			ps = con.prepareStatement(query);
			ps.setString(1, eqDTO.getFacility_code());
			ps.setString(2, eqDTO.getFacility_manager());
			ps.setDate(3, eqDTO.getInstallation_date());
			ps.setString(4, eqDTO.getFacility_name());
			ps.setString(5, eqDTO.getFacility_location());
			ps.setString(6, eqDTO.getInspection_cycle());
			ps.setString(7, eqDTO.getRemarks());
			result = ps.executeUpdate();
		} finally {
			if (ps != null)
				ps.close();
			if (con != null)
				con.close();
		}
		return result;
	}

	// 조회할때 쓰이는 것
	public List<EqDTO> searchEqList(String searchKeyword) throws SQLException {
		List<EqDTO> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String query = "SELECT * FROM P_FACILITY WHERE FACILITY_CODE LIKE ? OR FACILITY_NAME LIKE ?";
			ps = con.prepareStatement(query);
			ps.setString(1, "%" + searchKeyword + "%");
			ps.setString(2, "%" + searchKeyword + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				EqDTO dto = new EqDTO();
				dto.setFacility_code(rs.getString("facility_code"));
				dto.setFacility_manager(rs.getString("facility_manager"));
				dto.setInstallation_date(rs.getDate("installation_date"));
				dto.setFacility_name(rs.getString("facility_name"));
				dto.setFacility_location(rs.getString("facility_location"));
				dto.setInspection_cycle(rs.getString("inspection_cycle"));
				dto.setRemarks(rs.getString("remarks"));
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
}

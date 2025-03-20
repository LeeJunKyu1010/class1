import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class EqDAO {

	// 등록 메서드
	public int insertEq(EqDTO eqDTO) throws SQLException {
		int result = -1;
		Connection con = null;
		PreparedStatement ps = null;

		try {
			Context ctn = new InitialContext();
			DataSource ds = (DataSource) ctn.lookup("java:/comp/env/jdbc/oracle");
			con = ds.getConnection();

			// 중복 검사
			String checkQuery = "SELECT COUNT(*) FROM P_FACILITY WHERE FACILITY_CODE = ?";
			ps = con.prepareStatement(checkQuery);
			ps.setString(1, eqDTO.getFacility_code());
			ResultSet rs = ps.executeQuery();
			if (rs.next() && rs.getInt(1) > 0) {
				return -2; // 중복 코드 존재
			}

			// 중복이 없으면 삽입 진행
			String insertQuery = "INSERT INTO P_FACILITY VALUES (?, ?, ?, ?, ?, ?, ?)";
			ps = con.prepareStatement(insertQuery);
			ps.setString(1, eqDTO.getFacility_code());
			ps.setString(2, eqDTO.getFacility_manager());
			ps.setDate(3, eqDTO.getInstallation_date());
			ps.setString(4, eqDTO.getFacility_name());
			ps.setString(5, eqDTO.getFacility_location());
			ps.setString(6, eqDTO.getInspection_cycle());
			ps.setString(7, eqDTO.getRemarks());

			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException("설비 등록 중 오류 발생", e);
		} finally {
			if (ps != null)
				try {
					ps.close();
				} catch (SQLException e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
				}
		}

		return result;
	}


	// 조회 메서드 (전체 목록)
	public List<EqDTO> selectEqList() throws SQLException {

		List<EqDTO> list = new ArrayList<>();

		try {
			Context ctn = new InitialContext();
			DataSource ds = (DataSource) ctn.lookup("java:/comp/env/jdbc/oracle");
			Connection con = ds.getConnection();

			String query = "SELECT * FROM P_FACILITY";
			PreparedStatement ps = con.prepareStatement(query);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				EqDTO dto = new EqDTO();
				dto.setFacility_code(rs.getString("FACILITY_CODE"));
				dto.setFacility_manager(rs.getString("FACILITY_MANAGER"));
				dto.setInstallation_date(rs.getDate("INSTALLATION_DATE"));
				dto.setFacility_name(rs.getString("FACILITY_NAME"));
				dto.setFacility_location(rs.getString("FACILITY_LOCATION"));
				dto.setInspection_cycle(rs.getString("INSPECTION_CYCLE"));
				dto.setRemarks(rs.getString("REMARKS"));
				list.add(dto);
			}

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	};

	// 수정 메서드
	public void updateEq(EqDTO eqDTO) throws SQLException {
		String query = "UPDATE P_FACILITY SET FACILITY_MANAGER = ?, INSTALLATION_DATE = ?, FACILITY_NAME = ?, FACILITY_LOCATION = ?, INSPECTION_CYCLE = ?, REMARKS = ? WHERE FACILITY_CODE = ?";

		try {

			Context ctn = new InitialContext();
			DataSource ds = (DataSource) ctn.lookup("java:/comp/env/jdbc/oracle");
			Connection con = ds.getConnection();
			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, eqDTO.getFacility_manager());
			ps.setDate(2, eqDTO.getInstallation_date());
			ps.setString(3, eqDTO.getFacility_name());
			ps.setString(4, eqDTO.getFacility_location());
			ps.setString(5, eqDTO.getInspection_cycle());
			ps.setString(6, eqDTO.getRemarks());
			ps.setString(7, eqDTO.getFacility_code());

			int rowsAffected = ps.executeUpdate();
			if (rowsAffected == 0) {
				throw new SQLException("설비 수정 실패: 해당 코드의 설비가 존재하지 않습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 삭제 메서드
	public void deleteEq(String facilityCode) throws SQLException {
		try {
			Context ctn = new InitialContext();
			DataSource ds = (DataSource) ctn.lookup("java:/comp/env/jdbc/oracle");
			Connection con = ds.getConnection();
			String query = "DELETE FROM P_FACILITY WHERE FACILITY_CODE = ?";
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, facilityCode);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException("삭제 중 오류 발생", e);
		}
	}

	// 검색 메서드
	public List<EqDTO> searchEqList(String searchKeyword) throws SQLException {
		List<EqDTO> list = new ArrayList<>();

		try {
			Context ctn = new InitialContext();
			DataSource ds = (DataSource) ctn.lookup("java:/comp/env/jdbc/oracle");
			Connection con = ds.getConnection();

			String query = "SELECT * FROM P_FACILITY WHERE FACILITY_CODE LIKE ? OR FACILITY_NAME LIKE ?";

			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, "%" + searchKeyword + "%");
			ps.setString(2, "%" + searchKeyword + "%");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				EqDTO dto = new EqDTO();
				dto.setFacility_code(rs.getString("FACILITY_CODE"));
				dto.setFacility_manager(rs.getString("FACILITY_MANAGER"));
				dto.setInstallation_date(rs.getDate("INSTALLATION_DATE"));
				dto.setFacility_name(rs.getString("FACILITY_NAME"));
				dto.setFacility_location(rs.getString("FACILITY_LOCATION"));
				dto.setInspection_cycle(rs.getString("INSPECTION_CYCLE"));
				dto.setRemarks(rs.getString("REMARKS"));
				list.add(dto);
			}
			rs.close();
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class P_reDAO {

	// 데이터베이스 연결을 위한 메서드
	private Connection getConnection() throws Exception {
		Context ctn = new InitialContext();
		DataSource ds = (DataSource) ctn.lookup("java:/comp/env/jdbc/oracle");
		return ds.getConnection();
	}

	// 설비등록에서 설비코드, 설비명 조회
	public List<P_reDTO> getFacilityCodeAndName() throws SQLException {
		List<P_reDTO> list = new ArrayList<>();
		try (Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement("SELECT FACILITY_CODE, FACILITY_NAME FROM P_FACILITY");
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				P_reDTO dto = new P_reDTO();
				dto.setFacility_code(rs.getString("FACILITY_CODE"));
				dto.setFacility_name(rs.getString("FACILITY_NAME"));
				list.add(dto);
			}
		} catch (Exception e) {
			throw new SQLException("설비 코드와 이름 조회 중 오류 발생", e);
		}
		return list;
	}

	// 수리 기록 등록
	public int insertRe(P_reDTO dto) throws SQLException {
		String sql = "INSERT INTO P_REPAIR (REPAIR_ID, FACILITY_CODE, REPAIR_REQUEST_DATE, REPAIR_DETAILS, REPAIR_REQUESTER, REPAIR_ITEM, REMARKS) VALUES (SEQ_REPAIR.NEXTVAL, ?, ?, ?, ?, ?, ?)";
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, dto.getFacility_code());
			ps.setDate(2, dto.getRepair_request_date());
			ps.setString(3, dto.getRepair_details());
			ps.setString(4, dto.getRepair_requester());
			ps.setString(5, dto.getRepair_item());
			ps.setString(6, dto.getRemarks());

			return ps.executeUpdate();
		} catch (Exception e) {
			throw new SQLException("수리 정보 등록 중 오류 발생", e);
		}
	}

	// 수리 기록 전체 조회
	public List<P_reDTO> getAllRepairs() throws SQLException {
		List<P_reDTO> list = new ArrayList<>();
		String sql = "SELECT r.*, f.FACILITY_NAME FROM P_REPAIR r JOIN P_FACILITY f ON r.FACILITY_CODE = f.FACILITY_CODE";
		try (Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				P_reDTO dto = new P_reDTO();
				dto.setRepair_id(rs.getInt("REPAIR_ID"));
				dto.setFacility_code(rs.getString("FACILITY_CODE"));
				dto.setFacility_name(rs.getString("FACILITY_NAME"));
				dto.setRepair_request_date(rs.getDate("REPAIR_REQUEST_DATE"));
				dto.setRepair_details(rs.getString("REPAIR_DETAILS"));
				dto.setRepair_requester(rs.getString("REPAIR_REQUESTER"));
				dto.setRepair_item(rs.getString("REPAIR_ITEM"));
				dto.setRemarks(rs.getString("REMARKS"));
				list.add(dto);
			}
		} catch (Exception e) {
			throw new SQLException("수리 정보 조회 중 오류 발생", e);
		}
		return list;
	}

	// 검색 기능 메서드
	public List<P_reDTO> searchRepairs(String keyword) throws SQLException {
		List<P_reDTO> list = new ArrayList<>();
		String sql = "SELECT r.*, f.FACILITY_NAME FROM P_REPAIR r "
				+ "JOIN P_FACILITY f ON r.FACILITY_CODE = f.FACILITY_CODE "
				+ "WHERE REPAIR_DETAILS LIKE ? OR REPAIR_ITEM LIKE ?";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, "%" + keyword + "%");
			ps.setString(2, "%" + keyword + "%");

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					P_reDTO dto = new P_reDTO();
					// ... (기존 매핑 로직)
					list.add(dto);
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	// 수리 기록 수정
	public int updateRe(P_reDTO dto) throws SQLException {
		String sql = "UPDATE P_REPAIR SET FACILITY_CODE=?, REPAIR_REQUEST_DATE=?, REPAIR_DETAILS=?, REPAIR_REQUESTER=?, REPAIR_ITEM=?, REMARKS=? WHERE REPAIR_ID=?";
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, dto.getFacility_code());
			ps.setDate(2, dto.getRepair_request_date());
			ps.setString(3, dto.getRepair_details());
			ps.setString(4, dto.getRepair_requester());
			ps.setString(5, dto.getRepair_item());
			ps.setString(6, dto.getRemarks());
			ps.setInt(7, dto.getRepair_id());

			return ps.executeUpdate();
		} catch (Exception e) {
			throw new SQLException("수리 정보 수정 중 오류 발생", e);
		}
	}

	// 수리 기록 삭제
	public int deleteRe(int repairId) throws SQLException {
		System.out.println("deleteRe 실행");
		String sql = "DELETE FROM P_REPAIR WHERE REPAIR_ID = ?";
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
		
			ps.setInt(1, repairId);
			return ps.executeUpdate();
		} catch (Exception e) {
			throw new SQLException("수리 정보 삭제 중 오류 발생", e);
		}
	}
}

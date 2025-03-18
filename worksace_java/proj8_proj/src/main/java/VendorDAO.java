import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class VendorDAO {

	public int insertVendor(VendorDTO dto) {

		int result = -1;

		try {
			Context ctn = new InitialContext();
			DataSource ds = (DataSource) ctn.lookup("java:/comp/env/jdbc/oracle");
			Connection con = ds.getConnection();

			String query = "INSERT INTO P_VENDOR VALUES(SEQ.NEXTVAL, ?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, dto.getC_n());
			ps.setString(2, dto.getC_m());
			ps.setString(3, dto.getC_p());
			ps.setString(4, dto.getC_a());
			ps.setInt(5, dto.getC_i());

			result = ps.executeUpdate();

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public List all_selectVendor() {

		List list = new ArrayList();

		try {
			Context ctn = new InitialContext();
			DataSource ds = (DataSource) ctn.lookup("java:/comp/env/jdbc/oracle");
			Connection con = ds.getConnection();

			String query = "SELECT * FROM P_VENDOR";
			PreparedStatement ps = con.prepareStatement(query);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				VendorDTO all = new VendorDTO();

				all.setC_c(rs.getInt("VENDOR_ID"));
				all.setC_n(rs.getString("VENDOR_NAME"));
				all.setC_m(rs.getString("MGR"));
				all.setC_p(rs.getString("VENDOR_PHONE"));
				all.setC_a(rs.getString("EMAIL"));
				all.setC_i(rs.getInt("SKU_ID"));

				list.add(all);
			}

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	};

	public List selectVendor(VendorDTO dto) {

		List list = new ArrayList();

		try {
			Context ctn = new InitialContext();
			DataSource ds = (DataSource) ctn.lookup("java:/comp/env/jdbc/oracle");
			Connection con = ds.getConnection();

			String query = "SELECT * FROM P_VENDOR";
			PreparedStatement ps = con.prepareStatement(query);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				boolean c_n = !dto.getC_n().isEmpty() && rs.getString("VENDOR_NAME").contains(dto.getC_n());
				boolean c_m = !dto.getC_m().isEmpty() && rs.getString("MGR").contains(dto.getC_m());
				boolean c_p = !dto.getC_p().isEmpty() && rs.getString("VENDOR_PHONE").contains(dto.getC_p());
				boolean c_a = !dto.getC_a().isEmpty() && rs.getString("EMAIL").contains(dto.getC_a());

				if (rs.getInt("VENDOR_ID") == dto.getC_c() || c_n || c_m || c_p || c_a
						|| rs.getInt("SKU_ID") == dto.getC_i()) {
					VendorDTO all = new VendorDTO();

					all.setC_c(rs.getInt("VENDOR_ID"));
					all.setC_n(rs.getString("VENDOR_NAME"));
					all.setC_m(rs.getString("MGR"));
					all.setC_p(rs.getString("VENDOR_PHONE"));
					all.setC_a(rs.getString("EMAIL"));
					all.setC_i(rs.getInt("SKU_ID"));

					list.add(all);
				}

			}

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public void deleteVendor(VendorDTO dto) {

		try {

			Context ctn = new InitialContext();
			DataSource ds = (DataSource) ctn.lookup("java:/comp/env/jdbc/oracle");
			Connection con = ds.getConnection();

			// 체크된 값을 동적으로 추가하는 방법
			StringBuilder query = new StringBuilder();
			query.append("DELETE FROM P_VENDOR WHERE VENDOR_ID IN (");
			for (int i = 0; dto.getCheck().size() > i; i++) {
				query.append(dto.getCheck().get(i));
				if (dto.getCheck().size() - 1 > i) {
					query.append(",");
				}
			}
			;
			query.append(")");

			System.out.println(query);

			PreparedStatement ps = con.prepareStatement(query.toString());

			System.out.println("여기가진 왔나?");

			Integer result = ps.executeUpdate();

			if (result == 0) {
				System.out.println("삭제할 행이 없음");
			} else {
				System.out.println(result + "개의 행 삭제 완료");
			}

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateVendor(VendorDTO dto) {

		try {
			Context ctn = new InitialContext();
			DataSource ds = (DataSource) ctn.lookup("java:/comp/env/jdbc/oracle");
			Connection con = ds.getConnection();

			// 체크된 값을 동적으로 추가하는 방법
			String query = "UPDATE P_VENDOR "; 
			query += " SET VENDOR_NAME = ?, ";
			query += " MGR = ?, ";
			query += " VENDOR_PHONE = ?, ";
			query += " EMAIL = ?, ";
			query += " SKU_ID = ? WHERE VENDOR_ID = ?";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, dto.getC_n());
			ps.setString(2, dto.getC_m());
			ps.setString(3, dto.getC_p());
			ps.setString(4, dto.getC_a());
			ps.setInt(5, dto.getC_i());
			ps.setInt(6, dto.getC_c());
			
			ps.executeUpdate();
			
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

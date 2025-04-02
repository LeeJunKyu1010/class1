import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BillDAO {

	public int insertBill(BillDTO dto) {

		int result = -1;

		try {
			Context ctn = new InitialContext();
			DataSource ds = (DataSource) ctn.lookup("java:/comp/env/jdbc/oracle");
			Connection con = ds.getConnection();

			String query = "INSERT INTO P_BILL VALUES(SEQ.NEXTVAL, ?, ?, ?, ?, SYSDATE)";
			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, dto.getC_q());
			ps.setInt(2, dto.getC_b());
			ps.setString(3, dto.getC_a());
			ps.setInt(4, dto.getC_i());

			result = ps.executeUpdate();

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public List all_selectBill() {

		List list = new ArrayList();

		try {
			Context ctn = new InitialContext();
			DataSource ds = (DataSource) ctn.lookup("java:/comp/env/jdbc/oracle");
			Connection con = ds.getConnection();

			String query = " SELECT PB.BILL_DATE, PB.BILL_ID, PB.BILL_COUNT, PB.PRICE, PB.VENDOR_ID, PV.VENDOR_NAME, PV.VENDOR_PHONE, PV.EMAIL, PB.STATUS ";
			query += " FROM P_BILL PB ";
			query += " JOIN P_VENDOR PV ON PB.VENDOR_ID = PV.VENDOR_ID ";
			PreparedStatement ps = con.prepareStatement(query);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				BillDTO all = new BillDTO();

				all.setC_d(rs.getDate("BILL_DATE"));
				all.setC_c(rs.getInt("BILL_ID"));
				all.setC_q(rs.getInt("BILL_COUNT"));
				all.setC_b(rs.getInt("PRICE"));
				all.setC_i(rs.getInt("VENDOR_ID"));
				all.setC_n(rs.getString("VENDOR_NAME"));
				all.setC_p(rs.getString("VENDOR_PHONE"));
				all.setC_j(rs.getString("EMAIL"));
				all.setC_a(rs.getString("STATUS"));

				System.out.println("가격 확인: " + rs.getInt("PRICE"));
				System.out.println("가격 확인: " + all.getC_b());

				list.add(all);
			}

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List selectBill(BillDTO dto) {

		List list = new ArrayList();

		try {
			Context ctn = new InitialContext();
			DataSource ds = (DataSource) ctn.lookup("java:/comp/env/jdbc/oracle");
			Connection con = ds.getConnection();

			String query = " SELECT PB.BILL_DATE, PB.BILL_ID, PB.BILL_COUNT, PB.PRICE, PB.VENDOR_ID, PV.VENDOR_NAME, PV.VENDOR_PHONE, PV.EMAIL, PB.STATUS ";
			query += " FROM P_BILL PB ";
			query += " JOIN P_VENDOR PV ON PB.VENDOR_ID = PV.VENDOR_ID ";
			PreparedStatement ps = con.prepareStatement(query);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				boolean c_n = !dto.getC_n().isEmpty() && rs.getString("VENDOR_NAME").contains(dto.getC_n());
				boolean c_p = !dto.getC_p().isEmpty() && rs.getString("VENDOR_PHONE").contains(dto.getC_p());
				boolean c_j = !dto.getC_a().isEmpty() && rs.getString("EMAIL").contains(dto.getC_j());
				boolean c_a = !dto.getC_a().isEmpty() && rs.getString("STATUS").contains(dto.getC_a());

				if (rs.getDate("BILL_DATE") == dto.getC_d() || rs.getInt("BILL_ID") == dto.getC_c()
						|| rs.getInt("BILL_COUNT") == dto.getC_q() || rs.getInt("PRICE") == dto.getC_b()
						|| rs.getInt("VENDOR_ID") == dto.getC_i() || c_n || c_p || c_a) {
					BillDTO all = new BillDTO();

					all.setC_d(rs.getDate("BILL_DATE"));
					all.setC_c(rs.getInt("BILL_ID"));
					all.setC_n(rs.getString("VENDOR_NAME"));
					all.setC_p(rs.getString("VENDOR_PHONE"));
					all.setC_j(rs.getString("EMAIL"));
					all.setC_b(rs.getInt("PRICE"));
					all.setC_i(rs.getInt("VENDOR_ID"));
					all.setC_q(rs.getInt("BILL_COUNT"));
					all.setC_a(rs.getString("STATUS"));

					list.add(all);
				}

			}

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public void deleteBill(BillDTO dto) {

		try {

			Context ctn = new InitialContext();
			DataSource ds = (DataSource) ctn.lookup("java:/comp/env/jdbc/oracle");
			Connection con = ds.getConnection();

			// 체크된 값을 동적으로 추가하는 방법
			StringBuilder query = new StringBuilder();
			query.append("DELETE FROM P_BILL WHERE BILL_ID IN (");
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

	public void updateBill(BillDTO dto) {

		try {
			Context ctn = new InitialContext();
			DataSource ds = (DataSource) ctn.lookup("java:/comp/env/jdbc/oracle");
			Connection con = ds.getConnection();

			// 체크된 값을 동적으로 추가하는 방법
			String query = "UPDATE P_BILL ";
			query += " SET BILL_COUNT = ?, ";
			query += " PRICE = ?, ";
			query += " STATUS = ?, ";
			query += " VENDOR_ID = ?, ";
			query += " BILL_DATE = ? WHERE BILL_ID = ?";

			PreparedStatement ps = con.prepareStatement(query);
			
			System.out.println(dto.getC_d());

			ps.setInt(1, dto.getC_q());
			ps.setInt(2, dto.getC_b());
			ps.setString(3, dto.getC_a());
			ps.setInt(4, dto.getC_i());
			ps.setDate(5, new java.sql.Date(dto.getC_d().getTime()));
			ps.setInt(6, dto.getC_c());

			ps.executeUpdate();

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class WeekDAO {

	public List code_select() {

		List list = new ArrayList();

		try {
			Context ctn = new InitialContext();
			DataSource ds = (DataSource) ctn.lookup("java:/comp/env/jdbc/oracle");
			Connection con = ds.getConnection();

			String query = "SELECT P_SKU.SKU_CODE, P_SKU.SKU_ID FROM P_SKU";

			PreparedStatement ps = con.prepareStatement(query);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				WeekDTO dto = new WeekDTO();

				dto.setP_code(rs.getString("SKU_CODE"));
				dto.setP_id(rs.getInt("SKU_ID"));

				list.add(dto);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public int insertPlan(WeekDTO dto) {

		int result = -1;

		try {
			Context ctn = new InitialContext();
			DataSource ds = (DataSource) ctn.lookup("java:/comp/env/jdbc/oracle");
			Connection con = ds.getConnection();

			String query = "INSERT INTO P_WEEK_PLAN VALUES(SEQ.NEXTVAL, ?, ?, SYSDATE, ?, ?)";
			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, dto.getP_y());
			ps.setInt(2, dto.getP_w());
			ps.setInt(3, dto.getP_id());
			ps.setInt(4, dto.getP_c());

			result = ps.executeUpdate();

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public List all_selectPlan() {

		List list = new ArrayList();

		try {
			Context ctn = new InitialContext();
			DataSource ds = (DataSource) ctn.lookup("java:/comp/env/jdbc/oracle");
			Connection con = ds.getConnection();

			String query = " select pp.week_plan_id, pp.SKU_ID, ps.sku_name, PS.SKU_CODE, pp.plan_count, pp.plan_year, pp.week ";
			query += " from P_WEEK_PLAN PP ";
			query += " join P_SKU PS ON PP.SKU_ID = PS.SKU_ID ";
			PreparedStatement ps = con.prepareStatement(query);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				WeekDTO all = new WeekDTO();

				all.setP_id(rs.getInt("week_plan_id"));
				all.setP_name(rs.getString("sku_name"));
				all.setP_code(rs.getString("SKU_CODE"));
				all.setP_c(rs.getInt("plan_count"));
				all.setP_y(rs.getInt("plan_year"));
				all.setP_w(rs.getInt("week"));
				all.setP_i(rs.getInt("SKU_ID"));

				list.add(all);
			}

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List selectWeek(WeekDTO dto) {

		List list = new ArrayList();

		try {
			Context ctn = new InitialContext();
			DataSource ds = (DataSource) ctn.lookup("java:/comp/env/jdbc/oracle");
			Connection con = ds.getConnection();

			String query = " select pp.week_plan_id, pp.SKU_ID, ps.sku_name, PS.SKU_CODE, pp.plan_count, pp.plan_year, pp.week ";
			query += " from P_WEEK_PLAN PP ";
			query += " join P_SKU PS ON PP.SKU_ID = PS.SKU_ID ";
			PreparedStatement ps = con.prepareStatement(query);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				if (rs.getInt("week_plan_id") == dto.getP_i() || rs.getInt("plan_count") == dto.getP_c()
						|| rs.getString("SKU_CODE") == dto.getP_code() || rs.getInt("plan_year") == dto.getP_y()
						|| rs.getInt("week") == dto.getP_w()) {
					WeekDTO all = new WeekDTO();

					all.setP_id(rs.getInt("week_plan_id"));
					all.setP_c(rs.getInt("plan_count"));
					all.setP_name(rs.getString("sku_name"));
					all.setP_code(rs.getString("SKU_CODE"));
					all.setP_y(rs.getInt("plan_year"));
					all.setP_w(rs.getInt("week"));
					all.setP_i(rs.getInt("SKU_ID"));

					list.add(all);
				}

			}

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public void deletePlan(WeekDTO dto) {

		try {

			Context ctn = new InitialContext();
			DataSource ds = (DataSource) ctn.lookup("java:/comp/env/jdbc/oracle");
			Connection con = ds.getConnection();

			// 체크된 값을 동적으로 추가하는 방법
			StringBuilder query = new StringBuilder();
			query.append("DELETE FROM P_WEEK_PLAN WHERE WEEK_PLAN_ID IN (");
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
	
	public void updatePlan(WeekDTO dto) {

		try {
			Context ctn = new InitialContext();
			DataSource ds = (DataSource) ctn.lookup("java:/comp/env/jdbc/oracle");
			Connection con = ds.getConnection();

			// 체크된 값을 동적으로 추가하는 방법
			String query = "UPDATE P_WEEK_PLAN ";
			query += " SET plan_count = ?, ";
			query += " SKU_ID = ?, ";
			query += " plan_year = ?, ";
			query += " week = ? WHERE week_plan_id = ?";

			PreparedStatement ps = con.prepareStatement(query);
			
			System.out.println(dto.getP_c());
			System.out.println(dto.getP_id());
			System.out.println(dto.getP_y());
			System.out.println(dto.getP_w());
			System.out.println(dto.getP_i());
			
			ps.setInt(1, dto.getP_c());
			ps.setInt(2, dto.getP_id());
			ps.setInt(3, dto.getP_y());
			ps.setInt(4, dto.getP_w());
			ps.setInt(5, dto.getP_i());

			ps.executeUpdate();

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

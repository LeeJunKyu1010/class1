import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class WorkDAO {

	public Set code_select() {

		Set set = new HashSet<>();

		try {
			Context ctn = new InitialContext();
			DataSource ds = (DataSource) ctn.lookup("java:/comp/env/jdbc/oracle");
			Connection con = ds.getConnection();

			String query = "SELECT PLAN_YEAR, WEEK FROM P_WEEK_PLAN GROUP BY PLAN_YEAR, WEEK";

			PreparedStatement ps = con.prepareStatement(query);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				WorkDTO dto = new WorkDTO();

				dto.setYear(rs.getInt("PLAN_YEAR"));
				dto.setWeek(rs.getInt("WEEK"));

				set.add(dto);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return set;
	}

	public Set code_option(WorkDTO value) {

		Set set = new HashSet<>();

		try {
			Context ctn = new InitialContext();
			DataSource ds = (DataSource) ctn.lookup("java:/comp/env/jdbc/oracle");
			Connection con = ds.getConnection();

			System.out.println("응 오류내봐~ 안 하면 그만이야");
			System.out.println(value.getYear());
			System.out.println(value.getWeek());

			String query = " select pp.week_plan_id, pp.SKU_ID, ps.sku_name, PS.SKU_CODE, pp.plan_count, pp.plan_year, pp.week ";
			query += " from P_WEEK_PLAN PP ";
			query += " join P_SKU PS ON PP.SKU_ID = PS.SKU_ID ";
			query += " where plan_year = ? and week = ? ";

			System.out.println("응 오류내봐~ 안 하면 그만이야");

			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, value.getYear());
			ps.setInt(2, value.getWeek());

			System.out.println("응 오류내봐~ 안 하면 그만이야");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				WorkDTO dto = new WorkDTO();

				dto.setSku_name(rs.getString("sku_name"));

				set.add(dto);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return set;
	}

	public Set name_option(WorkDTO value) {

		Set set = new HashSet<>();

		try {
			Context ctn = new InitialContext();
			DataSource ds = (DataSource) ctn.lookup("java:/comp/env/jdbc/oracle");
			Connection con = ds.getConnection();

			System.out.println("상품명조건 검색");
			System.out.println(value.getYear());
			System.out.println(value.getWeek());
			System.out.println(value.getSku_name());

			String query = " select pp.week_plan_id, pp.SKU_ID, ps.sku_name, PS.SKU_CODE, pp.plan_count, pp.plan_year, pp.week ";
			query += " from P_WEEK_PLAN PP ";
			query += " join P_SKU PS ON PP.SKU_ID = PS.SKU_ID ";
			query += " where plan_year = ? and week = ? and sku_name = ? ";

			System.out.println("상품명조건 검색");

			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, value.getYear());
			ps.setInt(2, value.getWeek());
			ps.setString(3, value.getSku_name());

			System.out.println("상품명조건 검색");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				WorkDTO dto = new WorkDTO();

				dto.setPlan_id(rs.getInt("week_plan_id"));

				set.add(dto);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return set;
	}

	public Set id_option(WorkDTO value) {

		Set set = new HashSet<>();

		try {
			Context ctn = new InitialContext();
			DataSource ds = (DataSource) ctn.lookup("java:/comp/env/jdbc/oracle");
			Connection con = ds.getConnection();

			System.out.println("마지막으로 id다");
			System.out.println(value.getYear());
			System.out.println(value.getWeek());
			System.out.println(value.getPlan_id());

			String query = " select pW.work_order_id, pW.modify_date, pp.week_plan_id, ps.sku_name, PS.SKU_CODE, pp.plan_count, pW.quantity, pW.bom_id, pp.plan_year, pp.week, SPW.QSUM ";
			query += " from P_WEEK_PLAN PP ";
			query += " join P_SKU PS ON PP.SKU_ID = PS.SKU_ID ";
			query += " left join P_BOM PB ON PS.SKU_ID = PB.SKU_ID ";
			query += " left join P_WORK_ORDER PW ON PP.WEEK_PLAN_ID = PW.WEEK_PLAN_ID ";
			query += " LEFT JOIN (SELECT SUM(QUANTITY) AS QSUM, WEEK_PLAN_ID FROM P_WORK_ORDER GROUP BY WEEK_PLAN_ID) SPW ON PP.WEEK_PLAN_ID = SPW.WEEK_PLAN_ID ";
			query += " where pp.week_plan_id = ?  ";

			System.out.println("마지막으로 id다");

			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, value.getPlan_id());

			System.out.println("마지막으로 id다");

			System.out.println("쿼리 실행전");

			ResultSet rs = ps.executeQuery();

			System.out.println("쿼리 실행후");

			while (rs.next()) {
				System.out.println(rs.getObject("bom_id"));

				WorkDTO dto = new WorkDTO();

				dto.setPlan_id(rs.getInt("week_plan_id"));
				dto.setSku_code(rs.getInt("SKU_CODE"));
				dto.setSku_name(rs.getString("sku_name"));
				dto.setPlan_count(rs.getInt("plan_count"));
				dto.setBom(rs.getInt("bom_id"));
				dto.setPlan_s(rs.getInt("QSUM"));

				System.out.println(dto.getPlan_id());

				set.add(dto);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return set;
	}

	public int insertWork(WorkDTO dto) {

		int result = -1;

		try {
			Context ctn = new InitialContext();
			DataSource ds = (DataSource) ctn.lookup("java:/comp/env/jdbc/oracle");
			Connection con = ds.getConnection();

			String query = "INSERT INTO P_WORK_ORDER VALUES(SEQ.NEXTVAL, ?, SYSDATE, ?, ?)";
			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, dto.getPlan_id());
			ps.setInt(2, dto.getQnt());
			ps.setInt(3, dto.getBom());

			result = ps.executeUpdate();

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public List all_selectWork() {

		List list = new ArrayList();

		try {
			Context ctn = new InitialContext();
			DataSource ds = (DataSource) ctn.lookup("java:/comp/env/jdbc/oracle");
			Connection con = ds.getConnection();

			String query = " select pW.work_order_id, pW.modify_date, pp.week_plan_id, ps.sku_name, PS.SKU_CODE, pp.plan_count, pW.quantity, pW.bom_id, pp.plan_year, pp.week, SPW.QSUM, pw.compl ";
			query += " from P_WEEK_PLAN PP ";
			query += " join P_SKU PS ON PP.SKU_ID = PS.SKU_ID ";
			query += " left join P_BOM PB ON PS.SKU_ID = PB.SKU_ID ";
			query += " left join P_WORK_ORDER PW ON PP.WEEK_PLAN_ID = PW.WEEK_PLAN_ID ";
			query += " LEFT JOIN (SELECT SUM(QUANTITY) AS QSUM, WEEK_PLAN_ID FROM P_WORK_ORDER GROUP BY WEEK_PLAN_ID) SPW ON PP.WEEK_PLAN_ID = SPW.WEEK_PLAN_ID ";
			query += " group by pW.work_order_id, pW.modify_date, pp.week_plan_id, ps.sku_name, PS.SKU_CODE, pp.plan_count, pW.quantity, pW.bom_id, pp.plan_year, pp.week, SPW.QSUM, pw.compl ";

			PreparedStatement ps = con.prepareStatement(query);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				if (rs.getInt("work_order_id") > 0 || rs.getDate("modify_date") != null) {
					WorkDTO all = new WorkDTO();

					all.setWork_id(rs.getInt("work_order_id"));
					all.setDate(rs.getDate("modify_date"));
					all.setPlan_id(rs.getInt("week_plan_id"));
					all.setSku_name(rs.getString("sku_name"));
					all.setSku_code(rs.getInt("SKU_CODE"));
					all.setPlan_count(rs.getInt("plan_count"));
					all.setQnt(rs.getInt("quantity"));
					all.setComl(rs.getString("compl"));

					list.add(all);
				}

			}

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List selectWork(WorkDTO dto) {

		List list = new ArrayList();

		try {
			Context ctn = new InitialContext();
			DataSource ds = (DataSource) ctn.lookup("java:/comp/env/jdbc/oracle");
			Connection con = ds.getConnection();

			String query = " select pW.work_order_id, pW.modify_date, pp.week_plan_id, ps.sku_name, PS.SKU_CODE, pp.plan_count, pW.quantity, pW.bom_id, pp.plan_year, pp.week, SPW.QSUM, pw.compl ";
			query += " from P_WEEK_PLAN PP ";
			query += " join P_SKU PS ON PP.SKU_ID = PS.SKU_ID ";
			query += " left join P_BOM PB ON PS.SKU_ID = PB.SKU_ID ";
			query += " left join P_WORK_ORDER PW ON PP.WEEK_PLAN_ID = PW.WEEK_PLAN_ID ";
			query += " left join p_defect pd on pw.work_order_id = pd.work_order_id; ";
			query += " LEFT JOIN (SELECT SUM(QUANTITY) AS QSUM, WEEK_PLAN_ID FROM P_WORK_ORDER GROUP BY WEEK_PLAN_ID) SPW ON PP.WEEK_PLAN_ID = SPW.WEEK_PLAN_ID ";

			PreparedStatement ps = con.prepareStatement(query);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				boolean name = !dto.getSku_name().isEmpty() && rs.getString("sku_name").contains(dto.getSku_name());
				boolean date = !dto.getSku_name().isEmpty() && rs.getString("sku_name").contains(dto.getSku_name());

				if (rs.getInt("work_order_id") > 0 || rs.getInt("week_plan_id") == dto.getPlan_id()
						|| rs.getInt("plan_year") == dto.getYear() || rs.getInt("week") == dto.getWeek()
						|| rs.getDate("modify_date") != null || name) {
					WorkDTO all = new WorkDTO();

					all.setDate(rs.getDate("modify_date"));
					all.setPlan_id(rs.getInt("week_plan_id"));
					all.setSku_name(rs.getString("sku_name"));
					all.setSku_code(rs.getInt("SKU_CODE"));
					all.setPlan_count(rs.getInt("plan_count"));
					all.setQnt(rs.getInt("quantity"));
					all.setComl(rs.getString("compl"));

					list.add(all);
				}

			}

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public void defectWork(WorkDTO dto) {

		List list = new ArrayList();
		
		System.out.println(dto.getWork_id());

		try {
			Context ctn = new InitialContext();
			DataSource ds = (DataSource) ctn.lookup("java:/comp/env/jdbc/oracle");
			Connection con = ds.getConnection();

			String query = "INSERT INTO P_defect VALUES(SYSDATE, ?, ?, SEQ.NEXTVAL)";
			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, dto.getQnt());
			ps.setInt(2, dto.getWork_id());

			ps.executeUpdate();

			query = "UPDATE P_WORK_ORDER SET compl = ? WHERE work_order_id = ?";
			ps = con.prepareStatement(query);

			ps.setString(1, "Y");
			ps.setInt(2, dto.getWork_id());

			ps.executeUpdate();

			query = " select * ";
			query += " from p_work_order pw ";
			query += " left join p_defect pd on pw.work_order_id = pd.work_order_id ";

			ps = con.prepareStatement(query);

			ResultSet rs = ps.executeQuery();

			con.close();
		} catch (

		Exception e) {
			e.printStackTrace();
		}
	}

}

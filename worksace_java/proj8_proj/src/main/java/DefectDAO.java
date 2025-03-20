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


public class DefectDAO {

	public List all_selectDefect() {

		List list = new ArrayList();

		try {
			Context ctn = new InitialContext();
			DataSource ds = (DataSource) ctn.lookup("java:/comp/env/jdbc/oracle");
			Connection con = ds.getConnection();

			String query = " select pd.defect_id, ps.sku_code, ps.sku_name, ps.sku_category, pv.vendor_name, pd.defect_count ";
			query += " from p_week_plan pw ";
			query += " left join p_sku ps on  pw.sku_id = ps.sku_id ";
			query += " left join p_work_order pwo on pw.week_plan_id = pwo.week_plan_id ";
			query += " left join p_defect pd on pwo.work_order_id = pd.work_order_id ";
			query += " left join p_vendor pv on ps.sku_id = pv.sku_id  ";

			PreparedStatement ps = con.prepareStatement(query);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				if (rs.getInt("defect_id") > 0) {

					DefectDTO all = new DefectDTO();

					all.setId(rs.getInt("defect_id"));
					all.setCode(rs.getString("sku_code"));
					all.setName(rs.getString("sku_name"));
					all.setType(rs.getString("sku_category"));
					all.setVendor(rs.getString("vendor_name"));
					all.setCount(rs.getInt("defect_count"));

					list.add(all);

				}

			}

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List selectDefect(DefectDTO dto) {

		List list = new ArrayList();

		try {
			Context ctn = new InitialContext();
			DataSource ds = (DataSource) ctn.lookup("java:/comp/env/jdbc/oracle");
			Connection con = ds.getConnection();

			String query = " select pd.defect_id, ps.sku_code, ps.sku_name, ps.sku_category, pv.vendor_name, pd.defect_count ";
			query += " from p_week_plan pw ";
			query += " left join p_sku ps on  pw.sku_id = ps.sku_id ";
			query += " left join p_work_order pwo on pw.week_plan_id = pwo.week_plan_id ";
			query += " left join p_defect pd on pwo.work_order_id = pd.work_order_id ";
			query += " left join p_vendor pv on ps.sku_id = pv.sku_id  ";

			PreparedStatement ps = con.prepareStatement(query);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				boolean code_b = (dto.getCode() != null) && !dto.getCode().isEmpty()
						&& rs.getString("sku_code").contains(dto.getCode());
				boolean name_b = (dto.getName() != null) && !dto.getName().isEmpty()
						&& rs.getString("sku_name").contains(dto.getName());
				boolean type_b = (dto.getType() != null) && !dto.getType().isEmpty()
						&& rs.getString("sku_category").contains(dto.getType());
				boolean vendor_b = (dto.getVendor() != null) && !dto.getVendor().isEmpty()
						&& rs.getString("defect_count").contains(dto.getVendor());

				if (dto.getId() > 0 || code_b || name_b || type_b || vendor_b) {

					DefectDTO all = new DefectDTO();

					all.setId(rs.getInt("defect_id"));
					all.setCode(rs.getString("sku_code"));
					all.setName(rs.getString("sku_name"));
					all.setType(rs.getString("sku_category"));
					all.setVendor(rs.getString("vendor_name"));
					all.setCount(rs.getInt("defect_count"));

					list.add(all);
				}

			}

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public Set code_select() {

		Set set = new HashSet<>();

		try {
			Context ctn = new InitialContext();
			DataSource ds = (DataSource) ctn.lookup("java:/comp/env/jdbc/oracle");
			Connection con = ds.getConnection();

			String query = " select pd.defect_id, ps.sku_code, ps.sku_name, ps.sku_category, pv.vendor_name, pd.defect_count ";
			query += " from p_week_plan pw ";
			query += " left join p_sku ps on  pw.sku_id = ps.sku_id ";
			query += " left join p_work_order pwo on pw.week_plan_id = pwo.week_plan_id ";
			query += " left join p_defect pd on pwo.work_order_id = pd.work_order_id ";
			query += " left join p_vendor pv on ps.sku_id = pv.sku_id  ";

			PreparedStatement ps = con.prepareStatement(query);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				if (rs.getInt("defect_id") > 0) {

					DefectDTO all = new DefectDTO();

					all.setId(rs.getInt("defect_id"));
					all.setCode(rs.getString("sku_code"));
					all.setName(rs.getString("sku_name"));
					all.setType(rs.getString("sku_category"));
					all.setVendor(rs.getString("vendor_name"));

					set.add(all);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return set;
	}

}

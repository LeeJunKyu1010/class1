import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DisableDAO {

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

					System.out.println("불량 수량은: " + all.getCount());

					list.add(all);

				}

			}

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List insertDisable(DisableDTO dto) {
		
		List list = new ArrayList();

		try {
			Context ctn = new InitialContext();
			DataSource ds = (DataSource) ctn.lookup("java:/comp/env/jdbc/oracle");
			Connection con = ds.getConnection();

			String query = "INSERT INTO P_DISPOSAL_REFURB VALUES(SEQ.NEXTVAL, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, dto.getId());
			ps.setInt(2, dto.getCount());
			ps.setInt(3, dto.getCount_2());

			ps.executeUpdate();
			
			query = " SELECT SUM(DISPOSAL_COUNT) as dis, SUM(REFURB_COUNT) as re FORM P_DISPOSAL_REFURB GROUP BY SUM(DISPOSAL_COUNT), SUM(REFURB_COUNT) ";

			ps = con.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				dto.setCount(rs.getInt("dis"));
				dto.setCount_2(rs.getInt("re"));
				
				list.add(dto);
				
			}
			
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}

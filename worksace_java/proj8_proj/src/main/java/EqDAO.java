import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class EqDAO {
    // 데이터베이스 연결 및 쿼리 실행 메서드

    public int insertEq(EqDTO eqDTO) {
        int result = -1;
        try {
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
            Connection con = ds.getConnection();

            String query = "insert into p_facility values (?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, eqDTO.getFacility_code());
            ps.setString(2, eqDTO.getFacility_manager());
            ps.setDate(3, eqDTO.getInstallation_date());
            ps.setString(4, eqDTO.getFacility_name());
            ps.setString(5, eqDTO.getFacility_location());
            ps.setString(6, eqDTO.getInspection_cycle());
            ps.setString(7, eqDTO.getRemarks());

            result = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int updateEq(EqDTO eqDTO) {
        int result = -1;
        try {
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
            Connection con = ds.getConnection();

            String query = "update p_facility set facility_manager = ?, installation_date = ?, facility_name = ?, facility_location = ?, inspection_cycle = ?, remarks = ? where facility_code = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, eqDTO.getFacility_manager());
            ps.setDate(2, eqDTO.getInstallation_date());
            ps.setString(3, eqDTO.getFacility_name());
            ps.setString(4, eqDTO.getFacility_location());
            ps.setString(5, eqDTO.getInspection_cycle());
            ps.setString(6, eqDTO.getRemarks());
            ps.setInt(7, eqDTO.getFacility_code());

            result = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int deleteEq(int facility_code) {
        int result = -1;
        try {
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
            Connection con = ds.getConnection();

            String query = "delete from p_facility where facility_code = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, facility_code);

            result = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public EqDTO getEq(int facility_code) {
        EqDTO eqDTO = null;
        try {
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
            Connection con = ds.getConnection();

            String query = "select * from p_facility where facility_code = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, facility_code);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                eqDTO = new EqDTO();
                eqDTO.setFacility_code(rs.getInt("facility_code"));
                eqDTO.setFacility_manager(rs.getString("facility_manager"));
                eqDTO.setInstallation_date(rs.getDate("installation_date"));
                eqDTO.setFacility_name(rs.getString("facility_name"));
                eqDTO.setFacility_location(rs.getString("facility_location"));
                eqDTO.setInspection_cycle(rs.getString("inspection_cycle"));
                eqDTO.setRemarks(rs.getString("remarks"));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return eqDTO;
    }

    public List<EqDTO> getEqList() {
        List<EqDTO> eqList = new ArrayList<>();
        try {
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
            Connection con = ds.getConnection();

            String query = "select * from p_facility";
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                EqDTO eqDTO = new EqDTO();
                eqDTO.setFacility_code(rs.getInt("facility_code"));
                eqDTO.setFacility_manager(rs.getString("facility_manager"));
                eqDTO.setInstallation_date(rs.getDate("installation_date"));
                eqDTO.setFacility_name(rs.getString("facility_name"));
                eqDTO.setFacility_location(rs.getString("facility_location"));
                eqDTO.setInspection_cycle(rs.getString("inspection_cycle"));
                eqDTO.setRemarks(rs.getString("remarks"));
                eqList.add(eqDTO);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return eqList;
    }
}

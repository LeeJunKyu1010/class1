

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import kr.or.human.dto.EmpDTO;

@WebServlet("/Db")
public class DbServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/db doGet 실행");
		
		try {
			
			// [DB 접속] 시작
			// context.xml의 resource 중에jdbc/oracle 가져오기
			// JNDI 방식으로...
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:/comp/env/jdbc/oracle");
			ds.getConnection();
			// 커넥션 풀에서 접속 정보를 가져오기
			// 접속이 안되면 null이 나옴
			Connection con = ds.getConnection();
			
			// [SQL 준비]
			String query = "select * from";
			query += " emp";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			// [SQL 실행] 및 [결과 확보]
			// 		ResultSet executeQuery() : SQL 중 select 실행
			//		int executeUpdate() : select 외 모든것
			//		ResultSet : select 조회 결과 전체 : 엑셀 테이블 느낌
			ResultSet rs = ps.executeQuery();
			
			// 결과 활용
//			rs.next();	// 다음 줄로 커서를 이동
						// 다음줄이 있으면 true, 없으면 false를 return
			
			List<EmpDTO> list = new ArrayList<EmpDTO>();
			while(rs.next()) {	// 다음줄이 없을 때까지 반복
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				Date hiredate = rs.getDate("hiredate");
			
				System.out.println("---------------------------------------------------");
				System.out.print(" empno : "+empno);
				System.out.print(" ename : "+ename);
				System.out.println(" hiredate : "+hiredate);
				
				
				Map map = new HashMap();
				map.put("empno",empno);
				map.put("ename",ename);
				map.put("hiredate",hiredate);
				
				EmpDTO empDTO = new EmpDTO();
				empDTO.setEmpno(empno);
				empDTO.setEname(ename);
				empDTO.setHiredate(hiredate);
				
//				list.add(map);
//				list.add((Map)empDTO);
				list.add(empDTO);
			}
			
			// View
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			
			response.getWriter().println("<table style>");
			response.getWriter().println("<th>empno</th>");
			response.getWriter().println("<th>ename</th>");
			response.getWriter().println("<th>job</th>");
			response.getWriter().println("<th>mgr</th>");
			response.getWriter().println("<th>hiredate</th>");
			response.getWriter().println("<th>sal</th>");
			for(int i = 0; i<list.size(); i++) {		
				response.getWriter().println("<td>"+list.get(i).getEmpno()+"</td>");
				response.getWriter().println("<td>"+list.get(i).getEname()+"</td>");
				response.getWriter().println("<td>"+list.get(i).getJob()+"</td>");
				response.getWriter().println("<td>"+list.get(i).getMgr()+"</td>");
				response.getWriter().println("<td>"+list.get(i).getHiredate()+"</td>");
				response.getWriter().println("<td>"+list.get(i).getSal()+"</td>");
			}
			response.getWriter().println("</table>");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	


}

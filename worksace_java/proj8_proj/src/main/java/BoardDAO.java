import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {

	public int insertBoard(BoardDTO boardDTO) {
		System.out.println("insertBoard 실행");
		int result = -1;
		int boardId = -1;
		
		try {
			// [DB 접속] 시작
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = ds.getConnection();

			String insertQuery = "INSERT INTO P_BOARD (board_id, empno, title, board_content, notice, create_date, reserve_date, views) "
					+ "VALUES (seq_p_board.NEXTVAL, ?, ?, ?, ?, sysdate, null, 0)";
			PreparedStatement ps = con.prepareStatement(insertQuery);
			ps.setInt(1, boardDTO.getEmpno());
			ps.setString(2, boardDTO.getTitle());
			ps.setString(3, boardDTO.getBoardContent());
			ps.setInt(4, boardDTO.getNotice());

			result = ps.executeUpdate();
			
			if (result > 0) {
				String selectQuery = "SELECT board_id FROM P_BOARD WHERE rownum = 1 ORDER BY board_id DESC";
				PreparedStatement ps2 = con.prepareStatement(selectQuery);
				ResultSet rs = ps2.executeQuery();

				if (rs.next()) {
					boardId = rs.getInt("board_id");
				}
			}

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return boardId;
	}
	
	public List selectBoard(){
		System.out.println("selectBoard 실행");
		List list = new ArrayList();

		
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = ds.getConnection();

			// [SQL 준비]
			String 	query =  " select * from P_BOARD ";
			PreparedStatement ps = con.prepareStatement(query);

			// [SQL 실행] 및 [결과 확보]
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setBoardId(rs.getInt("board_id"));
				dto.setEmpno(rs.getInt("empno"));
				dto.setTitle(rs.getString("title"));
				dto.setBoardContent(rs.getString("board_content"));
				dto.setNotice(rs.getInt("notice"));
				dto.setCreateDate(rs.getDate("create_Date"));
				dto.setReserveDate(rs.getDate("reserve_Date"));
				dto.setViews(rs.getInt("views"));
				
				list.add(dto);
			}

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	public int updateBoard(BoardDTO boardDTO) {
		System.out.println("updateBoard 실행");
		int result = -1;
		
		try {
			// [DB 접속] 시작
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = ds.getConnection();

			// [SQL 준비]
			String 	query =  " update P_BOARD ";
					query += " set title = ?, board_Content = ?, notice = ?, reserve_Date = sysdate  ";
					query += " where board_Id = ? ";
					
			PreparedStatement ps = con.prepareStatement(query);
			// 물음표에 값을 넣어달라
			
			ps.setString(1, boardDTO.getTitle());
			ps.setString(2, boardDTO.getBoardContent());
			ps.setInt(3, boardDTO.getNotice());
			ps.setInt(4, boardDTO.getBoardId());

			result = ps.executeUpdate();

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	
	
	public int deleteBoard(BoardDTO boardDTO) {
		System.out.println("deleteBoard 실행");
		int result = -1;
		
		try {
			// [DB 접속] 시작
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = ds.getConnection();

			// [SQL 준비]
			String 	query =  " delete from P_BOARD ";
					query += " where board_Id = ? ";
			PreparedStatement ps = con.prepareStatement(query);
			
			// 첫번째 물음표에 값을 넣어달라
			ps.setInt(1, boardDTO.getBoardId());
			result = ps.executeUpdate();

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
		
		}
	
	
	public int viewsUpdateBoard(int boardId) {
		System.out.println("viewsUpdateBoard 실행");
		int result = -1;
		
		try {
			// [DB 접속] 시작
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = ds.getConnection();

			// [SQL 준비]
			String 	query =  " update P_BOARD ";
					query += " set views = (select views+1 from p_board ";
					query += " 				where board_id = ?) ";
					query += " where board_Id = ?  ";
					
			PreparedStatement ps = con.prepareStatement(query);
			// 물음표에 값을 넣어달라
			
			ps.setInt(1, boardId);
			ps.setInt(2, boardId);
			
			
			result = ps.executeUpdate();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	
	
	
	public BoardDTO getBoardDetail(int boardId) {
			BoardDTO boardDTO = null;
		
		try {
			// [DB 접속] 시작
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = ds.getConnection();

			// [SQL 준비]
			String 	query =  " select * from P_BOARD ";
					query += " where board_Id = ? ";
					
			PreparedStatement ps = con.prepareStatement(query);
			
			// 첫번째 물음표에 값을 넣어달라
			ps.setInt(1, boardId);
			ResultSet rs = ps.executeQuery();
			
		
			if(rs.next()) {
	            boardDTO = new BoardDTO();
	            boardDTO.setBoardId(rs.getInt("board_id"));
	            boardDTO.setEmpno(rs.getInt("empno"));
	            boardDTO.setTitle(rs.getString("title"));
	            boardDTO.setBoardContent(rs.getString("board_content"));
	            boardDTO.setNotice(rs.getInt("notice"));
	            boardDTO.setCreateDate(rs.getDate("create_date"));
	            boardDTO.setViews(rs.getInt("views"));
	            
			}
			
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return boardDTO;
		}
	
	
}

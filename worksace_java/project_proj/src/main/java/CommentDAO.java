import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;



public class CommentDAO {

	public int insertComment(CommentDTO commentDTO) {
		System.out.println("insertComment 실행");
		int result = -1;
		
		try {
			// [DB 접속] 시작
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = ds.getConnection();

			// [SQL 준비]
			String 	query =  " insert into p_comment ( comment_id, empno, board_id, content, create_date )";
					query += " values ( seq_p_comment.nextval, 1, ?, ?, sysdate )";
			PreparedStatement ps = con.prepareStatement(query);
			
//			ps.setInt(1, commentDTO.getEmpno());
			ps.setInt(1, commentDTO.getBoardId());
			ps.setString(2, commentDTO.getContent());

			// [SQL 실행] 및 [결과 확보]
			result = ps.executeUpdate();

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	
	
	public List selectComment(int boardId){
		System.out.println("selectComment 실행");
		List list = new ArrayList();

		
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = ds.getConnection();

			// [SQL 준비]
			String 	query =  " select c.comment_id, c.board_id, c.empno, e.emp_id as WriterName, c.content, c.create_date ";
					query += " from p_comment c ";
					query += " join p_emp e ON c.empno = e.empno ";
					query += " where c.board_ID = ? ";
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, boardId);
			
			// [SQL 실행] 및 [결과 확보]
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				CommentDTO comment = new CommentDTO();
				comment.setCommentId(rs.getInt("comment_Id"));
				comment.setEmpno(rs.getInt("empno"));
				comment.setWriterName(rs.getString("writerName"));
				comment.setBoardId(rs.getInt("board_Id"));
				comment.setContent(rs.getString("content"));
				comment.setCreateDate(rs.getDate("create_Date"));
				
				
				list.add(comment);
			}

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	public int updateComment(CommentDTO commentDTO) {
		System.out.println("updateComment 실행");
		int result = -1;
		
		try {
			// [DB 접속] 시작
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = ds.getConnection();

			// [SQL 준비]
			String 	query =  " update p_comment ";
					query += " set content = ? ";
					query += " where comment_id = ? ";
					PreparedStatement ps = con.prepareStatement(query);
					 
			// 물음표에 값을 넣어달라
			ps.setString(1, commentDTO.getContent());
			ps.setInt(2, commentDTO.getCommentId());
			
			// [SQL 실행] 및 [결과 확보]
			result = ps.executeUpdate();

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	
	
	public int deleteComment(CommentDTO commentDTO) {
		System.out.println("deleteComment 실행");
		int result = -1;
		
		try {
			// [DB 접속] 시작
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = ds.getConnection();

			// [SQL 준비]
			String 	query =  " delete from p_comment ";
					query += " where comment_Id = ? ";
			PreparedStatement ps = con.prepareStatement(query);
			
			// 첫번째 물음표에 값을 넣어달라
			ps.setInt(1, commentDTO.getCommentId());
			
			// [SQL 실행] 및 [결과 확보]
			result = ps.executeUpdate();

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
		
		}
	
	
	
	
	
	
	
}

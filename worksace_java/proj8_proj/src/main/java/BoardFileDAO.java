import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.Part;
import javax.sql.DataSource;

public class BoardFileDAO {
	
	
	public int uploadBoardFile(BoardFileDTO boardFileDTO) {
		System.out.println("uploadBoardFile 실행");
		int result = -1;
		
		try {
			// [DB 접속] 시작
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = ds.getConnection();

			// [SQL 준비]
			String 	query =  " insert into P_BOARD_File ";
					query += " (File_id, board_id, file_name, file_path, upload_date )";
					query += " values ( seq_p_board_file.nextval, ?, ?, ?, sysdate )";
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setInt(1, boardFileDTO.getBoardId());
			ps.setString(2, boardFileDTO.getFileName());
			ps.setString(3, boardFileDTO.getFilePath());

			// [SQL 실행] 및 [결과 확보]
			result = ps.executeUpdate();

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
		
	
	}
	
	
	public int deleteFileByBoardId(int boardId) {
		System.out.println("deleteFileByBoardId 실행");
		int result = -1;
		
		try {
			// [DB 접속] 시작
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = ds.getConnection();

			// [SQL 준비]
			String 	query =  " delete from P_BOARD_File ";
					query += " where board_id = ? ";
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setInt(1, boardId);

			// [SQL 실행] 및 [결과 확보]
			result = ps.executeUpdate();

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
		
	
	}
	
	
	    public List<BoardFileDTO> getFileById(int boardId) {
	    	List<BoardFileDTO> fileList = new ArrayList<>();
	        try {
	            // [DB 접속] 시작
	            Context ctx = new InitialContext();
	            DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
	            Connection con = ds.getConnection();

	            // [SQL 실행]
	            String query = "SELECT file_id, board_id, file_name, file_path, upload_date FROM P_BOARD_FILE WHERE board_id = ?";
	            PreparedStatement ps = con.prepareStatement(query);
	            ps.setInt(1, boardId);

	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	                BoardFileDTO boardFileDTO = new BoardFileDTO();
	                boardFileDTO.setFileId(rs.getInt("file_id"));
	                boardFileDTO.setBoardId(rs.getInt("board_id"));
	                boardFileDTO.setFileName(rs.getString("file_name"));
	                boardFileDTO.setFilePath(rs.getString("file_path"));
	                boardFileDTO.setUploadDate(rs.getDate("upload_date"));

	                fileList.add(boardFileDTO);
	            }

	            con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return fileList;
	    }
	    
	   
	
	    
	    
	}

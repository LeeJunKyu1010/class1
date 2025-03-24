import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/comment")
public class CommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		System.out.println("select 실행");
		
		CommentDTO commentDTO = new CommentDTO();
		int boardId = Integer.parseInt(request.getParameter("boardId"));
		commentDTO.setBoardId(boardId);
		
		CommentDAO commentDAO = new CommentDAO();
		List resultList = commentDAO.selectComment(boardId);
		
		// JSP에서 사용할 수 있게 request에 저장
		request.setAttribute("resultList", resultList);
		
		// 게시글 상세 페이지로 이동
		String url = "board?action=detail&boardId=" + boardId;
		request.getRequestDispatcher(url).forward(request, response);
		
		
	
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String command = request.getParameter("command");
		System.out.println("command : "+ command);
		
		int boardId = Integer.parseInt(request.getParameter("boardId"));
		System.out.println(boardId);
		
		if("update".equals(command)) {
			// update 장소
			
			int commentId = Integer.parseInt(request.getParameter("commentId"));
			String content = request.getParameter("content");
			
			CommentDTO commentDTO = new CommentDTO();
			commentDTO.setContent(content);
			commentDTO.setCommentId(commentId);
			
			CommentDAO commentDAO = new CommentDAO();
			int result = commentDAO.updateComment(commentDTO);
			System.out.println("result : "+ result);
			
		} else if ("insert".equals(command)) {
			// insert 장소
			
//			int empno = Integer.parseInt(request.getParameter("empno"));
			String content = request.getParameter("content");
			
			CommentDTO commentDTO = new CommentDTO();
//			commentDTO.setEmpno(empno);
			commentDTO.setBoardId(boardId);
			commentDTO.setContent(content);
			
			CommentDAO commentDAO = new CommentDAO();
			int result = commentDAO.insertComment(commentDTO);
			System.out.println("result : "+ result);
			
		} else if ("delete".equals(command)) {
			// delete 장소
			
			int commentId = Integer.parseInt(request.getParameter("commentId"));
			
			CommentDTO commentDTO = new CommentDTO();
			commentDTO.setCommentId(commentId);
			
			CommentDAO commentDAO = new CommentDAO();
			int result = commentDAO.deleteComment(commentDTO);
			System.out.println("result : "+ result);
		
		}
		
		String url = "board?action=detail&boardId=" + boardId;
		response.sendRedirect(url);
	}
		
		
	}


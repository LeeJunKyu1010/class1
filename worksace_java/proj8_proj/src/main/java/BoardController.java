import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.FileItem;


@WebServlet("/board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// board 접속 시, 목록 - 새글 작성 - 상세 보기 구분이 필요하다.
		// action 파라미터를 주어 확인하자.

		String action = request.getParameter("action");
		BoardDAO boardDAO = new BoardDAO();
		BoardFileDAO boardFileDAO = new BoardFileDAO();

		// 새글 작성 요청
		if ("form".equals(action)) {
			String boardIdStr = request.getParameter("boardId");

			if (boardIdStr != null) {

				int boardId = Integer.parseInt(boardIdStr);
				BoardDTO boardDTO = boardDAO.getBoardDetail(boardId);
				request.setAttribute("boardDTO", boardDTO);
			}

			// 새글 작성으로 이동
			request.getRequestDispatcher("form.jsp").forward(request, response);

		}

		// 게시글 상세 보기
		else if ("detail".equals(action)) {

			int boardId = Integer.parseInt(request.getParameter("boardId"));

			// 조회수 메소드
			boardDAO.viewsUpdateBoard(boardId);

			// 상세보기 메소드
			BoardDTO board = boardDAO.getBoardDetail(boardId);

			// 덧글 메소드 영역
			CommentDTO commentDTO = new CommentDTO();
			CommentDAO commentDAO = new CommentDAO();
			List resultList = commentDAO.selectComment(boardId);

			// 첨부파일 리스트
			List<BoardFileDTO> fileList = boardFileDAO.getFileById(boardId);

			request.setAttribute("board", board);
			request.setAttribute("resultList", resultList);
			request.setAttribute("fileList", fileList);

			request.getRequestDispatcher("board_detail.jsp").forward(request, response);

		} else {
			// 게시글 목록 가져오기
			List resultList = boardDAO.selectBoard();

			// JSP에서 사용할 수 있게 request에 저장
			request.setAttribute("resultList", resultList);

			// 게시판 목록 페이지로 이동
			String url = "board_list.jsp";
			request.getRequestDispatcher(url).forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		BoardDTO boardDTO = new BoardDTO();
		BoardDAO boardDAO = new BoardDAO();

		BoardFileDTO boardFileDTO = new BoardFileDTO();
		BoardFileDAO boardFileDAO = new BoardFileDAO();

		try {
			// File : 파일 또는 디렉토리(폴더)를 관리하는 class
			File currentDirPath = new File("C:\\temp\\upload");

			// 세팅
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setRepository(currentDirPath); // 경로 지정
			factory.setSizeThreshold(1024 * 1024); // 임시 파일의 크기를 byte단위로

			ServletFileUpload upload = new ServletFileUpload(factory);
			// 업로드 파일의 최대 크기 지정
			upload.setFileSizeMax(1024 * 1024 * 100); // 100 메가 바이트 100MB

			List<FileItem> items = upload.parseRequest(request);
			List<FileItem> fileItems = new ArrayList<>();
			Map<String, String> formData = new HashMap<>();

			for (int i = 0; i < items.size(); i++) {
				FileItem fileItem = (FileItem) items.get(i);

				if (fileItem.isFormField()) {

					// TRUE : 폼 데이터를 해시맵에 저장
					formData.put(fileItem.getFieldName(), fileItem.getString());

				} else {

					// FALSE : 파일 데이터
					// getSize : 파일 크기
					if (fileItem.getSize() > 0) {
						// 파일명 추출
						String fileName = fileItem.getName();
						fileName = System.currentTimeMillis() + "_" + fileName;

						File uploadFile = new File(currentDirPath + "\\" + fileName);
						String filePath = currentDirPath + "\\" + fileName;

						boardFileDTO.setFileName(fileName);
						boardFileDTO.setFilePath(filePath);

						// 파일 저장
						fileItem.write(uploadFile);

					}
				}
			}

			String command = formData.get("command");
			System.out.println("command : " + command);

			// form 데이터 저장까지 완료.
			if ("insert".equals(command)) {

				boardDTO.setEmpno(Integer.parseInt(formData.get("empno")));
				boardDTO.setTitle(formData.get("title"));
				boardDTO.setBoardContent(formData.get("content"));
				boardDTO.setNotice(Integer.parseInt(formData.get("notice")));

				int boardId = boardDAO.insertBoard(boardDTO);
				boardFileDTO.setBoardId(boardId);
				System.out.println("DAO 후 boardId 전송 : " + boardId);

				int result = boardFileDAO.uploadBoardFile(boardFileDTO);
				System.out.println("게시글 + 첨부 result : " + result);

			} else if ("update".equals(command)) {

				boardDTO.setBoardId(Integer.parseInt(formData.get("boardId")));
				int boardId = boardDTO.getBoardId();

				boardDTO.setTitle(formData.get("title"));
				boardDTO.setBoardContent(formData.get("content"));
				boardDTO.setNotice(Integer.parseInt(formData.get("notice")));

				int result = boardDAO.updateBoard(boardDTO);
				System.out.println("게시글 update result : " + result);

				// 파일 삭제
				boardFileDAO.deleteFileByBoardId(boardId);

				// 새 파일 업로드
				boardFileDTO.setBoardId(boardId);
				boardFileDAO.uploadBoardFile(boardFileDTO);

				String url = "board?action=detail&boardId=" + boardId;
				response.sendRedirect(url);

				return;

			} else if ("delete".equals(command)) {

				boardDTO.setBoardId(Integer.parseInt(formData.get("boardId")));
				int boardId = boardDTO.getBoardId();

				// 파일 유무에 따른 파일 관리 메소드
				List<BoardFileDTO> fileList = boardFileDAO.getFileById(boardId);

				if (fileList != null && !fileList.isEmpty()) {
					boardFileDAO.deleteFileByBoardId(boardId);
				}
				int result = boardDAO.deleteBoard(boardDTO);
				System.out.println("게시글 delete result : " + result);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String url = "board";
		response.sendRedirect(url);
	}
}
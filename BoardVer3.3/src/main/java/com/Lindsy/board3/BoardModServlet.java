package com.Lindsy.board3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.BoardDAO;
import Model.BoardVO;
import Utils.Util;

@WebServlet("/mod")
public class BoardModServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String iboard = request.getParameter("iboard");
		int no = Integer.parseInt(iboard);
		BoardDAO dao = new BoardDAO();
		request.setAttribute("data", dao.selBoard(no));
		
		Util.goToJsp(request, response, "mod");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String iboard = request.getParameter("iboard");
		int no = Integer.parseInt(iboard);
		
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		
		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();
		vo.setIboard(no);
		vo.setTitle(title);
		vo.setCtnt(ctnt);
		
		dao.updateBoard(vo);
		response.sendRedirect("/list");
	}

}

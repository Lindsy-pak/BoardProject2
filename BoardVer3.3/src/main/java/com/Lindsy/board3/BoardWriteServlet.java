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

@WebServlet("/write")
public class BoardWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Util.goToJsp(request, response, "write");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();
		
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		
		vo.setTitle(title);
		vo.setCtnt(ctnt);
		
		dao.insertBoard(vo); 
		
		response.sendRedirect("/list");
	}

}

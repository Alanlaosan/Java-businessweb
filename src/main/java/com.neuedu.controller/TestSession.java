package com.neuedu.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TestSession
 */
@WebServlet("/TestSession")
public class TestSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestSession() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//�ڷ���˴���һ���Ự
		HttpSession session =request.getSession();
		String sessionid=session.getId();
		//���ûỰʱ��
		session.setMaxInactiveInterval(20);
		System.out.println("�Ự Ĭ�ϵ�ʱ�䣺"+session.getMaxInactiveInterval());
		System.out.println("�Ựid="+sessionid);
		
		
		
		
		Object o=request.getAttribute("data");
		if(o==null) {
			session.setAttribute("data", System.currentTimeMillis());
		}
		
		System.out.println("data="+session.getAttribute("data"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

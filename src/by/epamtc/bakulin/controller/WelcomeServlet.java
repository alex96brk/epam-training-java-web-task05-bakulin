package by.epamtc.bakulin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@MultipartConfig
public class WelcomeServlet extends HttpServlet {

	private static final long serialVersionUID = -1362949679853687169L;

	@Override
	protected void doGet(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws ServletException, IOException {
		httpResponse.setContentType("text/html");
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/index.jsp");
		requestDispatcher.forward(httpRequest, httpResponse);
	}
}

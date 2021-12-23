package by.epamtc.bakulin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epamtc.bakulin.controller.command.Command;
import by.epamtc.bakulin.controller.command.Commands;
import by.epamtc.bakulin.controller.command.provider.CommandProvider;

@MultipartConfig
public class GemController extends HttpServlet{

	private static final long serialVersionUID = -3118174965322914877L;

	@Override
	protected void doGet(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws ServletException, IOException {
		httpResponse.setContentType("text/html");
		processRequest(httpRequest, httpResponse);
	}
	
	@Override
	protected void doPost(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws ServletException, IOException {
		httpResponse.setContentType("text/html");
		processRequest(httpRequest, httpResponse);
	}

	private void processRequest(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws ServletException, IOException {
		ServletContext servletContext = getServletContext();
		String xsdPath = servletContext.getRealPath("/gems-validation-schema.xsd");
		httpRequest.setAttribute("xsd", xsdPath);
		CommandProvider commandProvider = new CommandProvider();
		Command command = commandProvider.getCommand(httpRequest, httpResponse);
		String page = command.execute(httpRequest, httpResponse);
		boolean isPage = page != null;
		if (isPage) {
			RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(page);
			requestDispatcher.forward(httpRequest, httpResponse);
		}
		if (!isPage) {
			command = Commands.ERROR.getCommand();
			RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(command.execute(httpRequest, httpResponse));
			requestDispatcher.forward(httpRequest, httpResponse);
		}
	}
	
	
}

package by.epamtc.bakulin.controller.command.implementation;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epamtc.bakulin.controller.command.Command;

@MultipartConfig
public class EmptyCommand implements Command {

	@Override
	public String execute(HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
		httpResponse.setContentType("text/html");
		return "/index.jsp";
	}
	
}

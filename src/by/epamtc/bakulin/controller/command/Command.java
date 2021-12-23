package by.epamtc.bakulin.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
	
	String REQ_PARAM_COMMAND = "command";
	
	String execute(HttpServletRequest httpRequest, HttpServletResponse httpResponse);
}

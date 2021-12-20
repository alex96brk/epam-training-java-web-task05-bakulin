package by.epamtc.bakulin.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epamtc.bakulin.controller.Router;

public interface Command {
	
	String REQ_PARAM_COMMAND = "command";
	
	Router execute(HttpServletRequest httpRequest, HttpServletResponse httpResponse);
}

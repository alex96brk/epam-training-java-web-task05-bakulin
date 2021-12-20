package by.epamtc.bakulin.controller.command.implementation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epamtc.bakulin.controller.Router;
import by.epamtc.bakulin.controller.command.Command;

public class EmptyCommand implements Command {

	@Override
	public Router execute(HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
		return new Router();
	}
	
}

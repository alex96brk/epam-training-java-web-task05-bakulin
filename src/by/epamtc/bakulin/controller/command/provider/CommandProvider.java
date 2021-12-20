package by.epamtc.bakulin.controller.command.provider;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import by.epamtc.bakulin.controller.command.Command;
import by.epamtc.bakulin.controller.command.implementation.Commands;

public class CommandProvider {
	public static Command getCommand(HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
		Command command = Commands.EMPTY.getCommand();
		String action = httpRequest.getParameter(Command.REQ_PARAM_COMMAND);
		boolean isEmptyAction = action == null || StringUtils.isBlank(action) || action.isEmpty();
		if(!isEmptyAction) {
			Commands commands = Commands.valueOf(action.toUpperCase());
			command = commands.getCommand();
		}
		return command;
	}
}

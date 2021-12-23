package by.epamtc.bakulin.controller.command;

import by.epamtc.bakulin.controller.command.implementation.EmptyCommand;
import by.epamtc.bakulin.controller.command.implementation.FileUploadCommand;
import by.epamtc.bakulin.controller.command.implementation.ErrorCommand;


public enum Commands {
	FILE_UPLOAD(new FileUploadCommand()),
	ERROR(new ErrorCommand()),
	EMPTY(new EmptyCommand());
	
	private Command command;
	
	Commands(Command command) {
		this.command = command;
	}
	
	public Command getCommand() {
		return command;
	}
}

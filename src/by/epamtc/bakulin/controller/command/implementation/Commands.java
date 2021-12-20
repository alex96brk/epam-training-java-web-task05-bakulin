package by.epamtc.bakulin.controller.command.implementation;

import by.epamtc.bakulin.controller.command.Command;

public enum Commands {
	FIND_ALL(new FindAllCommand()),
	EMPTY(new EmptyCommand());
	
	private Command command;
	
	Commands(Command command) {
		this.command = command;
	}
	
	public Command getCommand() {
		return command;
	}
}

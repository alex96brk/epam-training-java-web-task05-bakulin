package by.epamtc.bakulin.controller.command.implementation;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;

import by.epamtc.bakulin.controller.command.Command;

public class ErrorCommand implements Command {
	
	private List<FileItem> formItems;

	@Override
	public String execute(HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setFormItems(List<FileItem> formItems) {
		this.formItems = formItems;
		
	}

}

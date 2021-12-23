package by.epamtc.bakulin.controller.command.implementation;

import java.util.List;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;

import by.epamtc.bakulin.controller.command.Command;

@MultipartConfig
public class ErrorCommand implements Command {
	
	private List<FileItem> formItems;
	private String description;

	@Override
	public String execute(HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
		httpResponse.setContentType("text/html");
		return "/error-page.jsp";
	}

	@Override
	public void setFormItems(List<FileItem> formItems) {
		this.formItems = formItems;
	}
	
	@Override
	public void setDescription(String description) {
		this.description = description;
	}

}

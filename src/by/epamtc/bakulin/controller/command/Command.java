package by.epamtc.bakulin.controller.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;

public interface Command {
	
	String REQ_PARAM_COMMAND = "command";
	
	String execute(HttpServletRequest httpRequest, HttpServletResponse httpResponse);
	
	void setFormItems(List<FileItem> formItems);
	
	void setDescription(String description);
}

package by.epamtc.bakulin.controller.command.provider;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import by.epamtc.bakulin.controller.command.Command;
import by.epamtc.bakulin.controller.command.Commands;
import by.epamtc.bakulin.controller.command.implementation.EmptyCommand;


public class CommandProvider {
	public Command getCommand(HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
		ServletFileUpload servletFileUpload = new ServletFileUpload(new DiskFileItemFactory());
		Command command = new EmptyCommand();
		try {
			List<FileItem> formItems = servletFileUpload.parseRequest(httpRequest);
			System.out.println(formItems.isEmpty());
			for (FileItem fileItem : formItems) {
				if(fileItem.getFieldName().equals("command")) {
					command = Commands.valueOf(fileItem.getString().toUpperCase()).getCommand();
				}
			}
		} catch (FileUploadException e) {
			System.out.println(e.getMessage());
		}
		return command;
	}
}

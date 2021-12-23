package by.epamtc.bakulin.controller.command.implementation;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang3.StringUtils;
import org.xml.sax.SAXException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;

import com.google.gson.Gson;

import by.epamtc.bakulin.controller.command.Command;
import by.epamtc.bakulin.model.Gem;
import by.epamtc.bakulin.service.factory.GemServiceFactory;
import by.epamtc.bakulin.service.implementation.GemService;
import by.epamtc.bakulin.util.PropertyReader;
import by.epamtc.bakulin.util.xml.document.gem.builder.GemBuilder;
import by.epamtc.bakulin.util.xml.document.gem.builder.factory.provider.GemBuilderFactoryProvider;
import by.epamtc.bakulin.util.xml.exception.ParserNotFoundException;
import by.epamtc.bakulin.util.xml.exception.XsdException;
import by.epamtc.bakulin.util.xml.validator.XSDValidator;

public class FileUploadCommand implements Command {
	private static final String UPLOAD_DIRECTORY = "upload";
	private GemService gemService;
	private Gson gsonInstance;
	private List<FileItem> formItems;
	private String description;
	

	public FileUploadCommand() {
		this.gsonInstance = new Gson();
	}

	@Override
	public String execute(HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
		String parserType = StringUtils.EMPTY;
		String filePath = StringUtils.EMPTY;
		String uploadPath = httpRequest.getServletContext().getRealPath("./") + UPLOAD_DIRECTORY;
		File uploadDirectory = new File(uploadPath);
		if (!uploadDirectory.exists()) {
			uploadDirectory.mkdir();
		}
		try {
			for (FileItem fileItem : formItems) {
				if (fileItem.getFieldName().equals("radio")) {
					parserType = fileItem.getString();
				}
				if (fileItem.getFieldName().equals("file")) {
					String fileName = new File(fileItem.getName()).getName();
					filePath = uploadPath + File.separator + fileName;
					File storeFile = new File(filePath);
					fileItem.write(storeFile);
				}
			}
			String xsdPath = (String)httpRequest.getAttribute("xsd");
			XSDValidator.validateXMLSchema(xsdPath, filePath);
			GemBuilder gemBuilder = GemBuilderFactoryProvider.getGemBuilderFactory(parserType).newInstance();
			gemService = GemServiceFactory.newService(gemBuilder);
			gemBuilder.buildGemSet(filePath);
			List<Gem> gems = gemService.findAll();
			httpRequest.setAttribute("gemsJson", gsonInstance.toJson(gems));
			httpRequest.setAttribute("parserType", parserType);
		} catch (XsdException e) {
			httpRequest.setAttribute("errorMessage", e.getMessage());
			return "/error-page.jsp";
		} catch (ParserNotFoundException e) {
			httpRequest.setAttribute("errorMessage", e.getMessage());
			return "/error-page.jsp";
		} catch (IOException e) {
			httpRequest.setAttribute("errorMessage", e.getMessage());
			return "/error-page.jsp";
		} catch (SAXException e) {
			httpRequest.setAttribute("errorMessage", e.getMessage());
			return "/error-page.jsp";
		} catch (Exception e) {
			httpRequest.setAttribute("errorMessage", e.getMessage());
			return "/error-page.jsp";
		}
		return "/gem-manage-page.jsp";
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

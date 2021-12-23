package by.epamtc.bakulin.controller.command.implementation;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;

import com.google.gson.Gson;

import by.epamtc.bakulin.controller.command.Command;
import by.epamtc.bakulin.model.Gem;
import by.epamtc.bakulin.service.factory.GemServiceFactory;
import by.epamtc.bakulin.service.implementation.GemService;
import by.epamtc.bakulin.util.xml.document.gem.builder.GemBuilder;
import by.epamtc.bakulin.util.xml.document.gem.builder.factory.provider.GemBuilderFactoryProvider;

public class FileUploadCommand implements Command {
	private static final String UPLOAD_DIRECTORY = "upload";
	private GemService gemService;
	private Gson gsonInstance;
	private List<FileItem> formItems;
	

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
					System.out.println(parserType);
				}
				if (fileItem.getFieldName().equals("file")) {
					String fileName = new File(fileItem.getName()).getName();
					filePath = uploadPath + File.separator + fileName;
					File storeFile = new File(filePath);
					fileItem.write(storeFile);
				}
			}

			GemBuilder gemBuilder = GemBuilderFactoryProvider.getGemBuilderFactory(parserType).newInstance();
			gemService = GemServiceFactory.newService(gemBuilder);
			gemBuilder.buildGemSet(filePath);
			List<Gem> gems = gemService.findAll();
			httpRequest.setAttribute("gemsJson", gsonInstance.toJson(gems));
			httpRequest.setAttribute("parserType", parserType);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "/gem-manage-page.jsp";
	}

	@Override
	public void setFormItems(List<FileItem> formItems) {
		this.formItems = formItems;
		
	}
	
	

}

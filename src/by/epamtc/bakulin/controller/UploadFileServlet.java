package by.epamtc.bakulin.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang3.StringUtils;

import com.google.gson.Gson;

import by.epamtc.bakulin.model.Gem;
import by.epamtc.bakulin.service.factory.GemServiceFactory;
import by.epamtc.bakulin.service.implementation.GemService;
import by.epamtc.bakulin.util.xml.document.gem.builder.GemBuilder;
import by.epamtc.bakulin.util.xml.document.gem.builder.factory.provider.GemBuilderFactoryProvider;

@MultipartConfig
public class UploadFileServlet extends HttpServlet {

	private static final long serialVersionUID = 5765688843020002219L;
	private GemService gemService;
	private Gson gsonInstance;
	
	private static final String UPLOAD_DIRECTORY = "upload";

	public UploadFileServlet() {
		this.gsonInstance = new Gson();
	}

	@Override
	protected void doGet(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws ServletException, IOException {
		httpResponse.setContentType("text/html");
		ServletContext servletContext = getServletContext();
		RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/gem-manage-page.jsp");
		ServletFileUpload servletFileUpload = new ServletFileUpload(new DiskFileItemFactory());
		String command = StringUtils.EMPTY;
		String parserType = StringUtils.EMPTY;
		String filePath = StringUtils.EMPTY;
		String uploadPath = httpRequest.getServletContext().getRealPath("./") + UPLOAD_DIRECTORY;
		File uploadDirectory = new File(uploadPath);
		if(!uploadDirectory.exists()) {
			uploadDirectory.mkdir();
		}
		try {
			List<FileItem> formItems = servletFileUpload.parseRequest(httpRequest);
			if (formItems != null && formItems.size() > 0) {
				for (FileItem fileItem : formItems) {
					if(fileItem.getFieldName().equals("radio")) {
						parserType = fileItem.getString();
					}
					if(fileItem.getFieldName().equals("file")) {
						String fileName = new File(fileItem.getName()).getName();
						filePath = uploadPath + File.separator + fileName;
						File storeFile = new File(filePath);
						fileItem.write(storeFile);
					}
					if(fileItem.getFieldName().equals("command")) {
						command = fileItem.getString();
					}
					
				}
			}
			GemBuilder gemBuilder = GemBuilderFactoryProvider.getGemBuilderFactory(parserType).newInstance();
			gemService = GemServiceFactory.newService(gemBuilder);
			gemBuilder.buildGemSet(filePath);
			List<Gem> gems = gemService.findAll();
			httpRequest.setAttribute("gemsJson", gsonInstance.toJson(gems));
			httpRequest.setAttribute("parserType", parserType);
			requestDispatcher.forward(httpRequest, httpResponse);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	protected void doPost(HttpServletRequest httpRequest, HttpServletResponse httpResponse)
			throws ServletException, IOException {
		doGet(httpRequest, httpResponse);
	}

}

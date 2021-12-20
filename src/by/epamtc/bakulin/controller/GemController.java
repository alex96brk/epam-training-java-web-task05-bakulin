package by.epamtc.bakulin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import by.epamtc.bakulin.controller.command.Command;
import by.epamtc.bakulin.controller.command.provider.CommandProvider;
import by.epamtc.bakulin.model.Gem;
import by.epamtc.bakulin.service.factory.GemServiceFactory;
import by.epamtc.bakulin.service.implementation.GemService;
import by.epamtc.bakulin.util.xml.document.gem.builder.GemBuilder;
import by.epamtc.bakulin.util.xml.document.gem.builder.factory.provider.GemBuilderFactoryEnum;
import by.epamtc.bakulin.util.xml.document.gem.builder.factory.provider.GemBuilderFactoryProvider;
import by.epamtc.bakulin.util.xml.exception.ParserNotFoundException;

public class GemController extends HttpServlet{

	private static final long serialVersionUID = -3118174965322914877L;
	private GemService gemService;
	private Gson gsonInstance;
	
	public GemController() {
		this.gsonInstance = new Gson();
		this.gemService = null;
	}

	@Override
	protected void doGet(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws ServletException, IOException {
		httpResponse.setContentType("text/html");
		ServletContext servletContext = getServletContext();
		RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/gem-manage-page.jsp");
		
		try {
			GemBuilder gemBuilder = GemBuilderFactoryProvider.getGemBuilderFactory(GemBuilderFactoryEnum.GEM_DOM_PARSER).newInstance();
			gemBuilder.buildGemSet("C:/Users/E-group/Desktop/epam/xml-task-resources/gems.xml");
			gemService = GemServiceFactory.newService(gemBuilder);
			List<Gem> gems = gemService.findAll();
			System.out.println(gsonInstance.toJson(gems));
			httpRequest.setAttribute("gemsJson", gsonInstance.toJson(gems));
			requestDispatcher.forward(httpRequest, httpResponse);
			
		} catch (ParserNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
//	@Override
//	protected void doGet(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws ServletException, IOException {
//		boolean isWelcome = httpRequest.getParameter(Command.REQ_PARAM_COMMAND).equals("welcome");
//		if (isWelcome) {
//			commandHandler(httpRequest, httpResponse);
//		}
//		if (!isWelcome) {
//			httpResponse.sendError(403);
//		}
//	}
	
	
//	private void commandHandler(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws ServletException, IOException {
//		Command command = CommandProvider.getCommand(httpRequest, httpResponse);
//		Router router = command.execute(httpRequest, httpResponse);
//		String page = router.getPage();
//		boolean isForward = router.getTransitionType() == Router.Transition.FORWARD;
//		if(isForward) {
//			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(page);
//			requestDispatcher.forward(httpRequest, httpResponse);
//		}
//		if(!isForward) {
//			httpResponse.sendRedirect(page);
//		}
//		
//	}



}

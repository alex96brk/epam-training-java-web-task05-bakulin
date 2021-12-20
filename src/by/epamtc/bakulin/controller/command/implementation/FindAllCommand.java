package by.epamtc.bakulin.controller.command.implementation;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import by.epamtc.bakulin.controller.Router;
import by.epamtc.bakulin.controller.command.Command;
import by.epamtc.bakulin.model.Gem;
import by.epamtc.bakulin.service.factory.GemServiceFactory;
import by.epamtc.bakulin.service.implementation.GemService;
import by.epamtc.bakulin.util.xml.document.gem.builder.GemBuilder;
import by.epamtc.bakulin.util.xml.document.gem.builder.factory.provider.GemBuilderFactoryEnum;
import by.epamtc.bakulin.util.xml.document.gem.builder.factory.provider.GemBuilderFactoryProvider;
import by.epamtc.bakulin.util.xml.exception.ParserNotFoundException;

public class FindAllCommand implements Command {

	private GemService gemService;
	private Gson gsonInstance;

	public FindAllCommand() {
		this.gsonInstance = new Gson();
		this.gemService = null;
	}

	@Override
	public Router execute(HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
		GemBuilder gemBuilder;
		Router router = new Router(Router.WELCOME_PAGE);
		HttpSession httpSession = httpRequest.getSession();
		try {
			gemBuilder = GemBuilderFactoryProvider.getGemBuilderFactory(GemBuilderFactoryEnum.GEM_DOM_PARSER).newInstance();
			gemBuilder.buildGemSet("C:/Users/E-group/Desktop/epam/xml-task-resources/gems.xml");
			gemService = GemServiceFactory.newService(gemBuilder);
			List<Gem> gems = gemService.findAll();
			System.out.println(gsonInstance.toJson(gems));
			httpSession.setAttribute("gemsJson", gsonInstance.toJson(gems));
		} catch (ParserNotFoundException e) {
			e.printStackTrace();
		}
		return router;
	}

}

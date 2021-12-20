package by.epamtc.bakulin.controller;

import org.apache.commons.lang3.StringUtils;

public class Router {
	
	public static final String WELCOME_PAGE ="/index.jsp";
	
	private String page;
	
	private Transition transitionType;
	
	public Router(String page, Transition transitionType) {
		this.page = page;
		this.transitionType = transitionType;
	}
	
	public Router(String page) {
		this(page, Transition.FORWARD);
	}
	
	public Router() {
		this(StringUtils.EMPTY);
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public Transition getTransitionType() {
		return transitionType;
	}
	
	enum Transition {
		FORWARD, REDIRECT
	}
	
}


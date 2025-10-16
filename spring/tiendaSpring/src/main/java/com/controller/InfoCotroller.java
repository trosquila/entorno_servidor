package com.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InfoCotroller {
	@RequestMapping(value="/infoController")
	public String infoController() {
	return "infoView";
	}

}
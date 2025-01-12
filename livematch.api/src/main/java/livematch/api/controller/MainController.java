package livematch.api.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import livematch.api.utils.APIVersionUtil;

@RestController
public class MainController {
	String apiVersion= APIVersionUtil.getApiVersion();	
	@RequestMapping(value="/")
	public String index() {
		return "Live Match API";
	}
}

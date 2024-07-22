package com.in_28mins.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CatalogController {
	
	@RequestMapping(value = "/catalogs")
	public String showCatalog() {
		return "catalogs";
	}
}

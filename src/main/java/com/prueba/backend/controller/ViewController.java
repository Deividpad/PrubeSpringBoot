package com.prueba.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
	
	@GetMapping("/cotizacion")
	public String index() {
		return "index";
	}
}

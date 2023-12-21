package com.blq.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
public class BookController {
	@RequestMapping("/home") // membuat mapping url secara khusus
	public String home() {
		return "book/book-template.html";
	}
}

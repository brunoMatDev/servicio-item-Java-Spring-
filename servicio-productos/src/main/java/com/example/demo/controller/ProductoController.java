package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Producto;
import com.example.demo.service.ProductoServiceImp;

import ch.qos.logback.core.model.Model;	

@RestController
public class ProductoController {
	@Autowired
	ProductoServiceImp productoService;
		
	
	@GetMapping("/listar")
	public List<Producto> Listar (Model model){
		
		return productoService.FindAll();
		
	}
	
}

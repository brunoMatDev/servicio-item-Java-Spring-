package com.item.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.item.entity.Item;
import com.item.service.ItemServiceImpl;

@RestController
public class ItemController {
	@Autowired
	private ItemServiceImpl servicio;
	
	@GetMapping("/listar")
	public List<Item>listar() {
		return servicio.findAll();
	}
	
	@GetMapping("/ver/{id}/cantidad/{cantidad}")
	public Item detalle(@PathVariable Long id, @PathVariable Integer cantidad){
		return servicio.findById(id, cantidad);
	}

}

package com.item.service;

import java.util.List;

import com.item.entity.Item;

public interface IItemService {
	public List<Item> findAll();
	public Item findById(Long id,Integer cantidad);
}

package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IProductoDao;
import com.example.demo.entity.Producto;

@Service
public class ProductoServiceImp implements IProductoService{
	@Autowired  //Permite inyectar una clase sin tener que instanciarla 
	IProductoDao iProductoDao;

	@Override
	public List<Producto> FindAll() {
		// TODO Auto-generated method stub
		return (List<Producto>)iProductoDao.findAll();
	}


}

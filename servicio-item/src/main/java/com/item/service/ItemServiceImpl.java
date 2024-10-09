package com.item.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.item.entity.Producto;
import com.item.entity.Item;
@Service
public class ItemServiceImpl implements IItemService {

	@Autowired
	private RestTemplate clienteRest;
	@Override
	public List<Item> findAll() {
		// TODO Auto-generated method stub
		/*Se puede conectar poniendo el url de la api
		 * Como por ejemplo -> http://localhost:8001/listar*/
		
		List<Producto> productos = Arrays.asList(clienteRest.getForObject("http://localhost:8001/listar", Producto[].class));
		//Convierto en cada y con el map accedo a producto
		return productos.stream().map(p->new Item(p,1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		// TODO Auto-generated method stub
		Map <String,String> pathVariable=new HashMap<String, String>();
		pathVariable.put("id",id.toString());
		Producto producto = clienteRest.getForObject("http://localhost:8001/ver/{id}",Producto.class,pathVariable);
		return new Item(producto,cantidad);
	}

}

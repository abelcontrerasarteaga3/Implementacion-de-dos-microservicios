package com.facturacion.start.service;

import java.util.List;



public interface BaseRep<T> {
	
	 public T save(T object);
	 public T update(T object);
	 public List<T> findAll();
	 public T fandById(Integer Id);

}

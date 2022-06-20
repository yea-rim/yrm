package com.kh.spring20.repository;

import java.util.List;

import com.kh.spring20.entity.ProductDto;

public interface ProductDao {
	List<ProductDto> list();
	ProductDto find(int no);
}

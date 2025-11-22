package com.yt.service;

import java.util.List;

import com.yt.model.Product;

public interface IProductServiceMgmtService 
{
	public List<Product> getAllProducts();
	public String registerProduct(Product product);
	public Product getProductById(int id);
	public String UpdateProduct(Product prod);
	public String deleteProductById(int id);

}

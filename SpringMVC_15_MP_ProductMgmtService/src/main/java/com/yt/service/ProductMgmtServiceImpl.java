package com.yt.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yt.model.Product;
import com.yt.repository.IProductRepository;

@Service
public class ProductMgmtServiceImpl implements IProductServiceMgmtService 
{
	@Autowired
	private IProductRepository prodRepo;

	@Override
	public List<Product> getAllProducts() 
	{
		return prodRepo.findAll();
	}

	@Override
	public String registerProduct(Product product) 
	{
		Product p = new Product();
		BeanUtils.copyProperties(product, p);
		p.setCreatedBy("user.name");
		Integer pid = prodRepo.save(p).getPid();
		return "Product with id:  "+pid+" Added Successfully!";
	}

	@Override
	public Product getProductById(int id) 
	{
		Product prod = prodRepo.findById(id).orElseThrow(()->new IllegalArgumentException());
		return prod;
	}

	@Override
	public String UpdateProduct(Product prod) 
	{
		Integer pid = prodRepo.save(prod).getPid();
		return "Product with id: "+pid+" successfully.";
	}

	@Override
	public String deleteProductById(int id) 
	{
		prodRepo.deleteById(id);
		return "Product with id : "+id+" deleted successfully.";
	}
	
	
	
	
	
	
	
	
}

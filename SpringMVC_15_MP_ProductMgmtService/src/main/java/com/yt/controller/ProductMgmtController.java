package com.yt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yt.model.Product;
import com.yt.service.IProductServiceMgmtService;

@Controller
public class ProductMgmtController 
{
	
	@Autowired
	private IProductServiceMgmtService service;
	
	@GetMapping("/")
	public String showHomePage()
	{
		return "home";
	}
	
	@GetMapping("/prod_report")
	public String getEmployeeDeatails(Map<String,Object> map)
	{
		List<Product> prod = service.getAllProducts();
		map.put("prodList", prod);
		return "show_prod_report";
	}
	
	@GetMapping("/add_prod")
	public String addnewProduct(@ModelAttribute("prod") Product prod)
	{
		return "register_prod";
	}
	
	@PostMapping("/add_prod")
	public String saveProduct(RedirectAttributes attrs, @ModelAttribute("prod") Product prod,Map<String,Object> map)
	{
		String msg = service.registerProduct(prod);
		List<Product> prodList = service.getAllProducts();
		map.put("resultMsg", msg);
		map.put("prodList", prodList);
		attrs.addFlashAttribute("resultMsg", msg);
		return "redirect:/prod_report";
	}
	
	@GetMapping("/editProd")
	public String showEditProductForm(@RequestParam("pid") int pid,@ModelAttribute("prod") Product prod)
	{
		//gather data
		Product prod1 = service.getProductById(pid);
		//copied data
		BeanUtils.copyProperties(prod1, prod);
		return "update_product";
	}
	
	@PostMapping("/editProd")
	public String EditProduct(RedirectAttributes attrs,@ModelAttribute("prod") Product prod)
	{	
			String msg = service.UpdateProduct(prod);
			attrs.addFlashAttribute("resultMsg", msg);
			return "redirect:/prod_report";
	}
	
	@GetMapping("/deleteProd")
	public String deleteProduct(RedirectAttributes attrs,@RequestParam("pid") int pid)
	{
		String msg = service.deleteProductById(pid);
		attrs.addFlashAttribute("resultMsg", msg);
		return "redirect:/prod_report";
	}
}

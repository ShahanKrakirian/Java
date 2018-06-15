package com.shahan.productscategories.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shahan.productscategories.models.Category;
import com.shahan.productscategories.models.CategoryProduct;
import com.shahan.productscategories.models.Product;
import com.shahan.productscategories.services.CategoryService;
import com.shahan.productscategories.services.MixService;
import com.shahan.productscategories.services.ProductService;

@Controller
public class CategoryController {
	private final CategoryService categoryService;
	private final ProductService productService;
	private final MixService mixService;
	
	public CategoryController(CategoryService categoryService, ProductService productService, MixService mixService) {
		this.categoryService = categoryService;
		this.productService = productService;
		this.mixService = mixService;
	}
	
	@RequestMapping("/categories/new")
	public String categories(@ModelAttribute("categoryToAdd") Category category) {
		return "/productscategories/newCategory.jsp";
	}
	
	@RequestMapping(value="/categories/new", method=RequestMethod.POST)
	public String newCategoryProcess(@Valid @ModelAttribute("categoryToAdd") Category category, BindingResult result) {
		if (result.hasErrors()) {
			return "/productscategories/newCategory.jsp";
		} else {
			categoryService.createCategory(category);
			return "redirect:/categories/new";
		}
	}
	
	@RequestMapping("/categories/{cid}")
	public String category(@ModelAttribute("productToAdd") CategoryProduct product, @PathVariable("cid") Long id, Model model) {
		
		Category currentCat = categoryService.findById(id);
		List<CategoryProduct> associatedCategoryProducts = currentCat.getCategoriesProducts();
		
		ArrayList<Product> productsAssociated = new ArrayList<Product>();
		ArrayList<String> productsAssociatedNames = new ArrayList<String>();

		for(CategoryProduct productId : associatedCategoryProducts) { //Creates list of products.
			productsAssociated.add(productId.getProduct());
		}
		for(Product adding : productsAssociated) { //Creates list of names of associated products.
			productsAssociatedNames.add(adding.getName());
		}
		
		if (productsAssociatedNames.isEmpty()) {
			productsAssociatedNames.add("");
		}
		
		List<Product> others = productService.findOthers(productsAssociatedNames);
		
		System.out.println(others);
		
		model.addAttribute("others", others);
		model.addAttribute("associatedProducts", productsAssociated);
		model.addAttribute("category", currentCat);
		
		return "/productscategories/category.jsp";
	}
	
	@RequestMapping("/categories/{cid}/newproductassociation")
	public String newProductAssociation(@Valid @ModelAttribute("productToAdd") CategoryProduct categoryproduct, BindingResult result, @PathVariable("cid") Long id) {
		if (result.hasErrors()) {
			return "redirect:/categories/" + id;
		} else {
			categoryproduct.setCategory(categoryService.findById(id));
			mixService.save(categoryproduct);
			return "redirect:/categories/" + id;
		}
	}
}

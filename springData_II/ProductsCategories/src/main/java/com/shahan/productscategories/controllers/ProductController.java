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
public class ProductController {
	private final ProductService productService;
	private final CategoryService categoryService;
	private final MixService mixService;
	
	public ProductController(ProductService productService, CategoryService categoryService, MixService mixService) {
		this.productService = productService;
		this.categoryService = categoryService;
		this.mixService = mixService;
	}
	
	@RequestMapping("/products/new")
	public String products(@ModelAttribute("productToAdd") Product product) {
		return "/productscategories/newProduct.jsp";
	}
	
	@RequestMapping(value="/products/new", method=RequestMethod.POST)
	public String newProductProcess(@Valid @ModelAttribute("productToAdd") Product product, BindingResult result) {
		if (result.hasErrors()) {
			return "/productscategories/newProduct.jsp";
		} else {
			productService.createProduct(product);
			return "redirect:/products/new";
		}
	}
	
	@RequestMapping("/products/{pid}")
	public String product(@ModelAttribute("categoryToAdd") CategoryProduct category, @PathVariable("pid") Long id, Model model) {
		
		Product currentProd = productService.findById(id);
		List<CategoryProduct> associatedCategoryProducts = currentProd.getCategoriesProducts();
		
		ArrayList<Category> categoriesAssociated = new ArrayList<Category>();
		ArrayList<String> categoriesAssociatedNames = new ArrayList<String>();

		for(CategoryProduct categoryId : associatedCategoryProducts) { //Creates list of categories.
			categoriesAssociated.add(categoryId.getCategory());
		}
		for(Category adding : categoriesAssociated) { //Creates list of names of associated categories.
			categoriesAssociatedNames.add(adding.getName());
		}
		
		if (categoriesAssociatedNames.isEmpty()) {
			categoriesAssociatedNames.add("");
		}
		System.out.println(categoriesAssociatedNames);
		
		List<Category> others = categoryService.findOthers(categoriesAssociatedNames);
		
		model.addAttribute("others", others);
		model.addAttribute("associatedCategories", categoriesAssociated);
		model.addAttribute("product", currentProd);
		
		return "/productscategories/product.jsp";
	}
	
	@RequestMapping("/products/{pid}/newcategoryassociation")
	public String newCategoryAssociation(@Valid @ModelAttribute("categoryToAdd") CategoryProduct categoryproduct, BindingResult result, @PathVariable("pid") Long id) {
		if (result.hasErrors()) {
			return "redirect:/products/" + id;
		} else {
			categoryproduct.setProduct(productService.findById(id));
			mixService.save(categoryproduct);
			return "redirect:/products/" + id;
		}
	}

}

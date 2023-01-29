package com.example.jpacrud.controller;

import com.example.jpacrud.model.Product;
import com.example.jpacrud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;


    @RequestMapping("/product")
    public String viewHomePage(Model model, @Param("keyword") String keyword) {
        if(keyword==null) {
            System.out.println("Vvedite datu");
        }else {
            List<Product> listProducts = productService.listAllProduct(keyword);
          model.addAttribute("listProducts", listProducts);

            model.addAttribute("keyword", keyword);
        }

        return "product_page";
    }

    @RequestMapping("/new")
    public String showNewProductPage(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);

        return "new_product";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Product product) {
        productService.save(product);

        return "redirect:/";
    }
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_product");
        Product product = productService.get(id);
        mav.addObject("product", product);

        return mav;
    }
    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") int id) {
        productService.delete(id);
        return "redirect:/";
    }


   
}

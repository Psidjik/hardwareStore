package controllers;

import dtos.ClientDto;
import dtos.ProductDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.FeedbackService;
import service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
    private ProductService productService;
    private FeedbackService feedbackService;

    @ModelAttribute("productModel")
    public ProductDto initProduct() {
        return new ProductDto();
    }

    @GetMapping("/add")
    public String addProduct(Model model) {
        model.addAttribute("available", productService.showCategory());
        return "product-add";
    }

    @PostMapping("/add")
    public String addProduct(@Valid ProductDto productDto, RedirectAttributes redirectAttributes, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("productDto", productDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.productDto",
                    bindingResult);
            return "redirect:/product/add";
        }
        productService.addNewProduct(productDto);
        return "redirect:/product/all";
    }

    @GetMapping("/all")
    public String getAllProducts(Model model) {
        model.addAttribute("productInfos", productService.getAllProducts());
        return "product-all";
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
    @Autowired
    public void setFeedbackService(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }
}

package com.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.ssm.domain.Product;
import com.ssm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    /***
     * 查询所有
     * 分页显示
     * @param model
     * @return
     */
    @RequestMapping("/findAll")
    public String findAll(Model model,
      @RequestParam(name = "page", required = true, defaultValue = "1") int page,
      @RequestParam(name = "size", required = true, defaultValue = "3") int size) {

        List<Product> productList = productService.findAll(page, size);
        PageInfo pageInfo = new PageInfo(productList);
        model.addAttribute("pageInfo", pageInfo);
        return "product-list";
    }


    /**
     * 保存商品
     *
     * @return
     */
    @RequestMapping("/saveProduct")
    public String saveProduct(Product product) {
        System.out.println(product);
        productService.saveProduct(product);
        //进行重定向到查询页面
        return "redirect:/product/findAll";
    }

    /**
     * 多选删除功能
     *
     * @param ids
     * @return
     */
    @RequestMapping("/delProductBySel")
    public String delProductBySel(String ids) {

        productService.delProductById(ids);
        return "redirect:/product/findAll";
    }

    /***
     * 进行页面的回显功能,根据id值去查找product
     * @return
     */
    @RequestMapping("/findProductById")
    public String findProductById(String id, Model model) {
        Product product = productService.findProductById(id);
        //存储到request域中
        //System.out.println(product);
        model.addAttribute("product", product);
        //使用请求的方式转发到更新页面
        return "product-update";
    }

    /**
     * 更新product根据id
     *
     * @param product
     * @return
     */
    @RequestMapping("/updateProductById")
    public String updateProductById(Product product) {
        System.out.println(product);
        productService.updateProductById(product);
        return "redirect:/product/findAll";
    }

}
